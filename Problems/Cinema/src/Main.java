import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        int[][] cinema = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                cinema[i][j] = scanner.nextInt();
            }
        }
        int ticketsCount = scanner.nextInt();
        boolean isFound = false;
        for (int i = 0; i < row; i++) {
            int temp = ticketsCount;
            for (int j = 0; j < column; j++) {
                if (!isFound && cinema[i][j] == 0) { //checking if seat is free
                    temp--; //minus one ticket
                    if (temp == 0) { //if no tickets needed, stopping the program
                        System.out.println(i + 1);
                        isFound = true;
                    } else if (j + 1 < column && cinema[i][j + 1] != 0) { //if more tickets needed, check if next seat is free
                        temp = ticketsCount;                              //if next seat doesn't free, reset circle
                    }
                }
            }
        }

        if (!isFound) {
            System.out.println(0);
        }
    }

}