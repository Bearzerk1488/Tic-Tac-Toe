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
        int column1 = scanner.nextInt();
        int column2 = scanner.nextInt();
        int[][] resultArray = array.clone();
        for (int i = 0; i < n; i++) {
            int temp = resultArray[i][column2];
            resultArray[i][column2] = resultArray[i][column1];
            resultArray[i][column1] = temp;
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