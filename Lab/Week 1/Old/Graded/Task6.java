import java.io.*;
import java.util.*;

public class Task6 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("N = ");

        int input = scanner.nextInt();

        int array[] = new int[input];
        boolean isDuplicate[] = new boolean[input];

        for (int i = 0; i < input; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < input; i++) {
            if (isDuplicate[i]) {
                continue;
            }
            int count = 1;

            for (int j = i + 1; j < input; j++) {
                if (array[i] == array[j]) {
                    count++;
                    isDuplicate[j] = true;
                }

            }
            if (count >= 1) {
                System.out.println(array[i] + " - " + count + " times.");
            }
        }
        scanner.close();

    }
}
