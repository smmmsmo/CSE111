import java.io.*;
import java.util.*;

public class Task2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        String str3 = str1 + " " + str2;

        int number = 0;

        for (int i = 0; i < str3.length(); i++) {
            if (str3.charAt(i) == ' ') {
                continue;
            }
            if ((str3.charAt(i) >= 'A' && str3.charAt(i) <= 'Z')
                    || ((str3.charAt(i) >= 'a' && str3.charAt(i) <= 'z'))) {
                number = number + (int) str3.charAt(i);
            }
        }
        System.out.println(str3);
        System.out.println(number);

        scanner.close();

    }
}
