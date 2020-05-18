import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        char[][] arr = new char[4][4];
        for (int i = 0; i < 4; i++) {
            arr[i] = scanner.nextLine().toCharArray();
        }
        boolean isPretty = true;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (isPretty
                        && arr[i][j] == arr[i][j - 1]
                        && arr[i][j - 1] == arr[i - 1][j - 1]
                        && arr[i][j] == arr[i - 1][j]) {
                    System.out.println("NO");
                    isPretty = false;
                }
            }
        }
        if (isPretty) {
            System.out.println("YES");
        }
    }
}