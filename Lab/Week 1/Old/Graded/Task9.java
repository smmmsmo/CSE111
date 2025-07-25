import java.util.*;

public class Task9 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        boolean isIdentityMatrix = true;

        int A[][] = new int[input][input];

        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                if (i != j){
                    if (A[i][j] != 0) {
                        isIdentityMatrix = false;
                        break;
                    }
                } else if (i == j) {
                    if (A[i][j] != 1) {
                        isIdentityMatrix = false;
                        break;
                    }
                }
            }
            if (!isIdentityMatrix) {
                break;
            }
        }

        if (isIdentityMatrix) {
            System.out.println("Identity matrix.");
        } else {
            System.out.println("Not an identity matrix.");
        }
        scanner.close();
    }
}
