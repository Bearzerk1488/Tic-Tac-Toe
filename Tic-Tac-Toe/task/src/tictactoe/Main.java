package tictactoe;

import java.util.Scanner;

public class Main {
    private static final int FIELD = 3;

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        char[][] gameField = new char[FIELD][FIELD];
        char[] arr = scanner.nextLine().trim().toCharArray();
        int counter = 0;
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                gameField[i][j] = arr[counter];
                counter++;
            }
        }
        drawField(gameField);
    }

    private static void drawField(char[][] gameField) {
        System.out.println("---------");
        for (int i = 0; i < gameField.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < gameField.length; j++) {
                System.out.print(gameField[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
