package HomeWork8;

public class Spiral {
    public static void main(String[] args) {
        int[][] spiral = getSpiral( 5, 7);
        printSpiral(spiral);
    }

    private static int[][] getSpiral (int row, int col){
        int[][] array = new int[row][col];
        int minRow = 0, maxRow = row - 1, minCol = 0, maxCol = col - 1;
        int count = 0;
        int max = row * col;
        while (count < max) {
            for (int i = minCol; i <= maxCol; i++) {
                array[minRow][i] = count;
                count++;
            }
            minRow = minRow + 1;
            for (int i = minRow; i <= maxRow; i++) {
                array[i][maxCol] = count;
                count++;
            }
            maxCol = maxCol - 1;
            for (int i = maxCol; i >= minCol; i--) {
                array[maxRow][i] = count;
                count++;
            }
            maxRow = maxRow - 1;
            for (int i = maxRow; i >= minRow; i--) {
                array[i][minCol] = count;
                count++;
            }
            minCol = minCol + 1;
        }
        return array;
    }

    private static void printSpiral(int[][] array) {
        int row = array.length;
        int col = array[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("%3d ", array[i][j]);
            }
            System.out.println("");
        }
    }
}
