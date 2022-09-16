package Classes;

public class Debug {

    static void print(Object... args) {
        for (Object arg : args) {
            System.out.print(arg);
        }
    }

    static void println(Object... args) {
        for (Object arg : args) {
            System.out.print(arg);
        }
        System.out.println();
    }

    static void printBidimensionalArray(Object[][] array) {
        for (Object[] row : array) {
            for (Object element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    static void printBidimensionalArray(char[][] array) {
        for (char[] row : array) {
            for (char element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    static void printBidimensionalArray(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}
