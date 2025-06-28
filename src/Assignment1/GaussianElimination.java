package Assignment1;


/*
            ALGORITHM

Start
Read dimension n
Check if n > 0
Read matrix A of size n x (n+1)
For i = 0 to n-2
For j = i+1 to n-1
Calculate factor = A[j][i] / A[i][i]
For k = i to n
Set A[j][k] = A[j][k] - factor × A[i][k]
End loops
Print upper triangular matrix
End

             FLOWCHART

[Start]
    |
  Read n
     |
     Is n > 0 ?
        /    \
       No     Yes
        |       |
       Error   Read Matrix A(nx(n+1))
               for i = 0, to n-2
                 for j = i + 1 to n - 1
                    factor = A[j][i]/A[i][i]
                    for k = i to n
                    A[j][k] = A[j][k] - factor x A[i][k]
                End loops
                Display A
[End]



               PSEUDOCODE

BEGIN
    INPUT n
    IF n <= 0 THEN
        DISPLAY "Invalid size"
    ELSE
        INPUT Matrix A (n x n+1)
        FOR i = 0 to n-2
            FOR j = i+1 to n-1
                factor = A[j][i] / A[i][i]
                FOR k = i to n
                    A[j][k] = A[j][k] - factor × A[i][k]
        DISPLAY Matrix A
END

 */


//CODE
import java.util.Scanner;
import java.util.InputMismatchException;

public class GaussianElimination {
    public void performElimination(Scanner scanner) {
        try {
            System.out.print("Enter the number of variables (n): ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("Error: Number of variables must be greater than 0.");
                return;
            }

            double[][] A = new double[n][n + 1];

            System.out.println("Enter the augmented matrix A (" + n + "x" + (n + 1) + "):");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n + 1; j++) {
                    A[i][j] = scanner.nextDouble();
                }
            }

            // Clear buffer
            scanner.nextLine();

            // Forward elimination
            for (int i = 0; i < n - 1; i++) {
                if (A[i][i] == 0) {
                    System.out.println("Error: Division by zero detected during elimination.");
                    return;
                }
                for (int j = i + 1; j < n; j++) {
                    double factor = A[j][i] / A[i][i];
                    for (int k = i; k < n + 1; k++) {
                        A[j][k] = A[j][k] - factor * A[i][k];
                    }
                }
            }

            // Display upper triangular matrix
            System.out.println("Upper Triangular Matrix (after forward elimination):");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n + 1; j++) {
                    System.out.printf("%.2f ", A[i][j]);
                }
                System.out.println();
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid numeric inputs.");
            scanner.nextLine();
        }
    }
}



/*
       ANALYSIS

Basic Operation: Multiplication and subtraction in A[j][k] = A[j][k] - factor * A[i][k]
Number of basic operations:
Approx (n-1)(n-i)(n+1-i) → Simplifies to O(n³) for cubic complexity
Time Complexity: O(n³)
Space Complexity: O(n²) (for matrix A)
 */
