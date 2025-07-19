import java.io.*;
import java.util.*;

public class Task1 {

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
        int start = Math.min(number1, number2);
        int end = Math.max(number1, number2);
        for (int i = start; i <= end; i++) {
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

        int result = primeCount(input1, input2);
        System.out.println("There are " + result + " prime numbers between " + input1 + " and " + input2 + ".");
        scanner.close();

    }

}
