import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int input = 5;
        int array[] = new int[input];

        for (int i = 0; i < input; i++) {
            array[i] = scanner.nextInt();
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int max_location = -1;
        int min_location = -1;

        for (int i = 0; i<input; i++) {
            if (array[i] > max) {
                max = array[i];
                max_location = i;
            }
            if (array[i] < min) {
                min = array[i];
                min_location = i;
            }
        }

        System.out.println("The largest element is " + max + " at index " + max_location);
        System.out.println("The smallest element is " + min + " at index " + min_location);

        scanner.close();
    }
}
