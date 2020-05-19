import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        int[][] resultArray = new int[m][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                resultArray[j][i] = array[i][j];
//            }
//        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultArray[j][n - i - 1] = array[i][j];
            }
        }
        for (int[] a : resultArray
        ) {
            for (int i : a
            ) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}