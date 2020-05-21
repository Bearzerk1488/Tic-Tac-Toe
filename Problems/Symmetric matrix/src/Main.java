import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[][] matrix = new int[length][length];
        boolean isSymmetric = true;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    isSymmetric = false;
                }
            }
        }
        if (isSymmetric) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}