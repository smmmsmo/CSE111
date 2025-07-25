import java.io.*;
import java.util.*;

public class Task2 {

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int primeCount(int number1, int number2) {
        int count = 0;

        for (int i = number1; i <= number2; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input1 = scanner.nextInt();
        int input2 = scanner.nextInt();

        int min = Math.min(input1, input2);
        int max = Math.max(input1, input2);

        int result = primeCount(min, max);
        System.out.println("There are " + result + " prime numbers between " + min + " and " + max + ".");
        scanner.close();

    }

}
