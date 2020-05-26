package tictactoe;

import java.util.Scanner;

public class Main {
    private static final int FIELD = 3;
    private static states state;

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        char[][] gameField = new char[FIELD][FIELD];
        char[] arr = scanner.nextLine().trim().toUpperCase().toCharArray();
        int counter = 0;
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                gameField[i][j] = arr[counter];
                counter++;
            }
        }
        drawField(gameField);
        checkState(gameField);
        System.out.println(state.getState());
    }

    private static void checkState(char[][] gameField) {
        int x = 0;
        int o = 0;
        int space = 0;
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                if (gameField[i][j] == 'X') {
                    x++;
                } else if (gameField[i][j] == 'O') {
                    o++;
                } else if (gameField[i][j] == '_') {
                    space++;
                }
            }
        }

        int xRowCounter = 0;
        int oRowCounter = 0;
        int xColumnCounter = 0;
        int oColumnCounter = 0;
        for (int i = 0; i < gameField.length; i++) {
            StringBuilder row = new StringBuilder();
            StringBuilder column = new StringBuilder();
            for (int j = 0; j < gameField.length; j++) {
                row.append(gameField[i][j]);
                column.append(gameField[j][i]);
            }
            if (row.toString().equals("XXX")) {
                xRowCounter++;
            } else if (row.toString().equals("OOO")) {
                oRowCounter++;
            }
            if (column.toString().equals("XXX")) {
                xColumnCounter++;
            } else if (column.toString().equals("OOO")) {
                oColumnCounter++;
            }
        }

        int xDiagonal = 0;
        int oDiagonal = 0;
        StringBuilder diagonal1 = new StringBuilder();
        StringBuilder diagonal2 = new StringBuilder();
        for (int i = 0; i < gameField.length; i++) {
            diagonal1.append(gameField[i][i]);
            diagonal2.append(gameField[gameField.length - 1 - i][i]);
        }
        if (diagonal1.toString().equals("XXX")) {
            xDiagonal++;
        } else if (diagonal1.toString().equals("OOO")) {
            oDiagonal++;
        }
        if (diagonal2.toString().equals("XXX")) {
            xDiagonal++;
        } else if (diagonal2.toString().equals("OOO")) {
            oDiagonal++;
        }

        if (Math.abs(x - o) > 1
                || xRowCounter > 1 || oRowCounter > 1
                || xColumnCounter > 1 || oColumnCounter > 1
                || xDiagonal > 1 || oDiagonal > 1
                || (xRowCounter > 0 && xRowCounter == oRowCounter)
                || (xColumnCounter > 0 && xColumnCounter == oColumnCounter)) {
            state = states.IMPOSSIBLE;
        } else if (xRowCounter == 1 || xColumnCounter == 1 || xDiagonal == 1) {
            state = states.X_WINS;
        } else if (oRowCounter == 1 || oColumnCounter == 1 || oDiagonal == 1) {
            state = states.O_WINS;
        } else if (space == 0) {
            state = states.DRAW;
        } else if (space > 0) {
            state = states.GAME_NOT_FINISHED;
        }

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

    enum states {
        GAME_NOT_FINISHED("Game not finished"),
        DRAW("Draw"),
        X_WINS("X wins"),
        O_WINS("O wins"),
        IMPOSSIBLE("Impossible");

        String state;

        states(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }
}
