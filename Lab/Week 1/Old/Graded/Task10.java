import java.io.*;
import java.util.*;

public class Task10 {

    public static void printMap(int arr[][]) {
        for (int row[] : arr) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static String toUpper(String input) {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }
            result += ch;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int arr2D[][] = new int[rows][cols];

        System.out.println("Enter grid values row by row:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr2D[i][j] = sc.nextInt();
            }
        }

        int playerCount = 0;
        int treasureCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr2D[i][j] == 7)
                    playerCount++;
                if (arr2D[i][j] == 10)
                    treasureCount++;
            }
        }

        if (playerCount != 1 || treasureCount != 1) {
            System.out.println("Error: Grid must contain exactly one player (7) and one treasure (10).");
            return;
        }

        int rowPosition = -1, columnPosition = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr2D[i][j] == 7) {
                    rowPosition = i;
                    columnPosition = j;
                    break;
                }
            }
        }

        System.out.println("Initial Map:");
        printMap(arr2D);

        int turns = 5;
        sc.nextLine();

        while (turns > 0) {
            System.out.printf("Enter move %d: ", (6 - turns));
            String inp = toUpper(sc.nextLine().trim());

            int new_row = rowPosition;
            int new_column = columnPosition;

            if (inp.equals("UP"))
                new_row--;
            else if (inp.equals("DOWN"))
                new_row++;
            else if (inp.equals("LEFT"))
                new_column--;
            else if (inp.equals("RIGHT"))
                new_column++;
            else {
                System.out.println("Invalid move. Use UP, DOWN, LEFT, or RIGHT.");
                continue;
            }

            if (new_row < 0 || new_row >= rows || new_column < 0 || new_column >= cols) {
                System.out.println("Out of bounds. You lose!");
                return;
            }

            if (arr2D[new_row][new_column] == -1) {
                System.out.println("Stepped on a mine. You lose!");
                return;
            }

            if (arr2D[new_row][new_column] == 10) {
                arr2D[rowPosition][columnPosition] = 0;
                arr2D[new_row][new_column] = 7;
                System.out.println("Treasure found. You win!");
                System.out.println("Final state:");
                printMap(arr2D);
                return;
            }

            arr2D[rowPosition][columnPosition] = 0;
            arr2D[new_row][new_column] = 7;
            rowPosition = new_row;
            columnPosition = new_column;

            System.out.println("Current state:");
            printMap(arr2D);
            turns--;
        }

        System.out.println("Failed to find the treasure.");

        sc.close();

    }
}
