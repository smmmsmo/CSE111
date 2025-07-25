import java.util.*;

public class Task1 {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        int array[] = new int[input];
        int new_array[] = new int[input];

        for (int i = 0; i < input; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Remove element : ");
        int remove = scanner.nextInt();
        int index = 0;

        for (int i = 0; i < input; i++) {
            if (array[i] != remove) {
                new_array[index++] = array[i];
            }
        }

        System.out.println("Input array:");
        for (int i = 0; i < input; i++) {
            System.out.print(array[i]);
            if (i < input - 1)
                System.out.print(" ");
        }
        System.out.println();

        System.out.println("New array:");
        for (int i = 0; i < index; i++) {
            System.out.print(new_array[i]);
            if (i < index - 1)
                System.out.print(" ");
        }
        System.out.println();

        scanner.close();

    }
}
