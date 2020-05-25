import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean isSolved = true;
        int[][] field = new int[n * n][n * n];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < field.length; i++) {
            int[] array = new int[n * n];
            array = Arrays.copyOf(field[i], n * n);
            Arrays.sort(array);
            if (n == 1 && array[0] != 1) {
                isSolved = false;
                break;
            }
            for (int j = 1; j < array.length; j++) {
                if (array[j - 1] != 0 && array[j - 1] + 1 != array[j]) {
                    isSolved = false;
                    break;
                }
            }
        }
        for (int i = 0; i < field.length; i++) {
            int[] array = new int[field.length];
            for (int j = 0; j < field[i].length; j++) {
                array[j] = field[j][i];
            }
            Arrays.sort(array);
            for (int j = 1; j < array.length; j++) {
                if (array[j - 1] != 0 && array[j - 1] + 1 != array[j]) {
                    isSolved = false;
                    break;
                }
            }
        }

        for (int i = 0; i < field.length; i++) {
            int[] a = Arrays.copyOf(field[i], field.length);
            if (field.length == 1 && a[0] != 1) {
                isSolved = false;
                break;
            }
            for (int j = i + 1; j < field.length; j++) {
                for (int k = 0; k < field.length; k++) {
                    if (a[k] == field[j][k] || a[k] == 0) {
                        isSolved = false;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < field.length; i++) {
            int[] array = new int[field.length];
            for (int j = 0; j < field[i].length; j++) {
                array[j] = field[j][i];
            }
            for (int j = i + 1; j < field.length; j++) {
                for (int k = 0; k < field.length; k++) {
                    if (array[k] == field[k][j]) {
                        isSolved = false;
                        break;
                    }
                }
            }
        }

        System.out.println(isSolved ? "YES" : "NO");
    }
}
