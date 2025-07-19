import java.io.*;
import java.util.*;

public class Task1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int limit = 10;
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        int sum = 0;
        int count = 0;
        int array[] = new int[limit];

        for (int i = 0; i < limit; i++) {
            array[i] = scanner.nextInt();

            if (array[i] > 0 && array[i] % 2 != 0) {

                sum += array[i];
                count++;

                if (array[i] < minimum) {
                    minimum = array[i];
                }
                if (array[i] > maximum) {
                    maximum = array[i];

                }
            }
        }
        double average = (double) sum / count;

        if (count == 0) {
            System.out.println("No positive odd numbers found.");
        } else {
            System.out.println("Sum: " + sum);
            System.out.println("Minimum: " + minimum);
            System.out.println("Maximum: " + maximum);
            System.out.println("Average: " + average);

        }

        scanner.close();

    }
}
