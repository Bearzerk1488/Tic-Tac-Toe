import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[][] array = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = ".";
            }
        }
        int middle = n / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][i] = "*"; //from left up to right down
                array[Math.abs(i - (n - 1))][i] = "*"; //from right up to left down
                array[middle][i] = "*"; //middle column
                array[i][middle] = "*"; //middle row
            }
        }
        for (String[] a : array
        ) {
            for (String s : a
            ) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}