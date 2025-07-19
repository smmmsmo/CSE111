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
        System.out.println(" Remove element : ");
        int remove = scanner.nextInt();

        int newIndex = 0;
        boolean found = false;
        for (int i = 0; i < input; i++) {
            if (array[i] != remove) {
                new_array[newIndex] = array[i];
                newIndex++;
            } else {
                found = true;
            }
        }

        System.out.println("Original array : " + Arrays.toString(array));
        if (found) {
            System.out.println("New array after removing " + remove + " : " + Arrays.toString(new_array));
        } else {
            System.out.println("No elements found");
        }

        scanner.close();
    }
}
