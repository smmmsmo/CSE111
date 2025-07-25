import java.util.*;

public class Task4 {
    public static void main(String[] args) {

Scanner scanner = new Scanner(System.in);

        System.out.println("Row size: ");
        int row = scanner.nextInt();

        System.out.println("Column size: ");
        int column = scanner.nextInt();

        int array[][] = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter multiplication factor (k): ");
        int k = scanner.nextInt();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                array[i][j] = array[i][j] * k;
                if (j < column - 1) {
                    System.out.print(array[i][j] + " ");
                } else {
                    System.out.print(array[i][j]);
                }
            }
            System.out.println();
        }

        scanner.close();

    }

}
