package HomeWork2;

import java.sql.*;

public class Database {

    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres?currentSchema=public";
    private static final String USER = "postgres";
    private static final String DB_NAME = "Students";

    private static final String PASS = "password";

    public static void main(String[] args) throws SQLException {

        try {
            connect();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }

        create();

        for (int i = 1; i < 5; i++) {
            insert(i, "Bob");
        }

        delete("Bob2");

        select("Bob3");

        update("Bob4", 44);

        System.out.println("\n ===================== \n");

        select("");

        disconnect();
    }

    public static void create() throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS public.\"" + DB_NAME + "\"\n" +
                "(\n" +
                "    \"LastName\" text NOT NULL,\n" +
                "    \"Score\" integer NOT NULL,\n" +
                "    PRIMARY KEY (\"LastName\")\n" +
                ")\n" +
                "WITH (\n" +
                "    OIDS = FALSE\n" +
                ");\n" +
                "\n" +
                "ALTER TABLE public.\"" + DB_NAME + "\"\n" +
                "    OWNER to postgres;");
    }

    public static void insert(int i, String nameStud) throws SQLException{

        pstmt = connection.prepareStatement("INSERT INTO public.\"" + DB_NAME + "\" (\"LastName\", \"Score\")" +
                "VALUES (?,?);");

        pstmt.setString(1, nameStud + i);
        pstmt.setInt(2, 50 + i);
        pstmt.addBatch();

        pstmt.executeBatch();
    }

    public static void delete(String nameStud) throws SQLException{
        stmt.executeUpdate("DELETE FROM public.\"" + DB_NAME + "\" WHERE \"LastName\" = \'"+ nameStud +"\'");
    }

    public static void select(String nameStud) throws SQLException{

        String condition = (nameStud.isEmpty())? "": String.format(" WHERE \"LastName\" = \'%s'", nameStud);
        String sql = String.format("SELECT \"LastName\", \"Score\" FROM public.\"" + DB_NAME + "\"" + condition);
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString("LastName") + " " + rs.getString("Score"));
        }
    }

    public static void update(String nameStud, int score) throws SQLException{
        stmt.executeUpdate(String.format("UPDATE public.\"" + DB_NAME + "\" SET \"Score\" = " + score +
                " WHERE \"LastName\" = \'%s'", nameStud));
    }

    public static void connect() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = connection.createStatement();
    }

    public static void disconnect(){
        try {
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
