package HomeWork3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class inputOutput {
    public static void main(String[] args) {
        try {
            // Task 1
            readFile("filesForExample/java.txt");

            // Task 2
            String[] paths = {"filesForExample/filesForConnection/Java Virtual Machine.txt",
                    "filesForExample/filesForConnection/Class libraries.txt",
                    "filesForExample/filesForConnection/Languages.txt",
                    "filesForExample/filesForConnection/Similar platforms.txt",
                    "filesForExample/filesForConnection/Java Development Kit.txt"};

            connectFiles(paths, "filesForExample/filesForConnection/result.txt");

            // Task 3
            readPage("filesForExample/filesForConnection/result.txt",2);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // Task 1
    public static void readFile(String path) throws IOException {
        System.out.println("Read file: " + path + "\n");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(path));
        int x;
        while ((x = in.read()) != -1) {
            out.write(x);
            System.out.print((char) x);
        }
        byte[] arr = out.toByteArray();
        System.out.println("\n" + Arrays.toString(arr));
        in.close();
        out.close();

        printDelimiter();
    }

    // Task 2
    public static void connectFiles(String[] paths, String resultFile) throws IOException {
        System.out.println("Connect file: " + Arrays.toString(paths) + "\n");

        ArrayList<InputStream> al = new ArrayList<>();
        for (String path : paths) {
            al.add(new FileInputStream(path));
        }

        BufferedInputStream in = new BufferedInputStream(new SequenceInputStream(Collections.enumeration(al)));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(resultFile));
        int x;
        while ((x = in.read()) != -1) {
            out.write(x);
            System.out.print((char) x);
        }
        in.close();
        out.close();

        printDelimiter();
    }

    // Task 3
    public static void readPage(String path, int numberPage) throws IOException {

        System.out.println("Read page: " + numberPage + " file: " + path + "\n");

        long t = System.currentTimeMillis();
        int numberOfSymbolsOnPage = 1800;
        RandomAccessFile raf = new RandomAccessFile(path, "r");
        raf.seek(numberPage * numberOfSymbolsOnPage);
        for (int i = 0; i < numberOfSymbolsOnPage; i++) {
            System.out.print((char) raf.read());
        }
        raf.close();

        System.out.println();
        System.out.println(System.currentTimeMillis() - t);

        printDelimiter();
    }

    public static void printDelimiter(){
        System.out.println("\n========================================\n");
    }
}
