import java.io.*;
import java.util.*;

public class Task5 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");

        int input = scanner.nextInt();

        int array[] = new int[input];

        for (int i = 0; i < input; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i = input - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }

        scanner.close();

    }
}
