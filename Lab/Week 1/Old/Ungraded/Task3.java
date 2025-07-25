import java.util.*;

public class Task3 {

    // Method to sort the array using Bubble Sort
    public static void sortArray(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Main method to read input, sort the array, and calculate the median
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        int numbers[] = new int[input];

        for (int i = 0; i < input; i++) {
            numbers[i] = scanner.nextInt();
        }

        sortArray(numbers);

        int median;
        if (input % 2 == 0) {
            median = (((numbers[(input / 2) - 1]) + (numbers[input / 2])) / 2);
        } else {
            median = numbers[input / 2];
        }

        System.out.println("Median: " + median);
        scanner.close();
    }
}
