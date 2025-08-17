import java.util.*;

public class Task5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int row = scanner.nextInt();
        int column = scanner.nextInt();

        int array[][] = new int[row][column];
        int transposed[][] = new int[column][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                transposed[j][i] = array[i][j];
            }
        }
        System.out.println("Original Matrix:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("");

        System.out.println("Transposed Matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(transposed[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}