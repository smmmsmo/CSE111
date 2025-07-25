import java.io.*;
import java.util.*;

public class Task4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String newString = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            char prevChar;
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a') {
                    prevChar = 'z';
                    newString += prevChar;
                } else {
                    prevChar = (char) (ch - 1);
                    newString += prevChar;
                }
            }
        }
        System.out.println(newString);
        scanner.close();

    }
}
