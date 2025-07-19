import java.io.*;
import java.util.*;

public class Task3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("N = ");

        int N = scanner.nextInt();

        double original[] = new double[N];

        for (int i = 0; i < original.length; i++) {
            original[i] = scanner.nextDouble();
        }

        double new_original[] = new double[N];
        int index = 0;

        if (original.length > 0) {
            new_original[index++] = original[0];

            for (int i = 1; i < N; i++) {
                if (original[i] != original[i - 1]) {
                    new_original[index++] = original[i];
                }
            }
        }

        System.out.print("New array: ");
        for (int i = 0; i < index; i++) {
            System.out.print(new_original[i] + " ");
        }

        System.out.println();
        System.out.println("Removed items : " + (original.length - index));
        scanner.close();

    }
}
