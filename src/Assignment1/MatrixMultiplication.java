package Assignment1;
     /*
        ALGORITHM

Start
Read matrix dimensions: m, n, p
Check if all dimensions are positive
Read matrix A (m×n elements)
Read matrix B (n×p elements)
Initialize result matrix C (m×p) with zeros
For each row i in A
For each column j in B
For each k from 0 to n-1
Multiply A[i][k] × B[k][j] and add to C[i][j]
Print result matrix C
End


        FLOWCHART

[Start]
     |
     Read m, n, p
         |
         Is m, n, p, > 0 ?
             /    \
            No     Yes
                     |
                   Read Matrix A (mxn)
                   Read Matrix B (nxp)
                   Initialize Matrix C (mxp)
                   for i = 0 to m - 1
                     for j = 0 to p - 1
                       for k = 0 to n - 1
                       c[i][j] += A[i][k] * B[k][j]
                    End loops
                    Display C
[End]


                           PSEUDOCODE

BEGIN
    INPUT m, n, p
    IF m, n, p <= 0 THEN
        DISPLAY "Invalid dimensions"
    ELSE
        INPUT matrix A of size m×n
        INPUT matrix B of size n×p
        INITIALIZE matrix C of size m×p to 0
        FOR i = 0 to m-1
            FOR j = 0 to p-1
                FOR k = 0 to n-1
                    C[i][j] += A[i][k] * B[k][j]
        DISPLAY matrix C
END

      */



import java.util.Scanner;
import java.util.InputMismatchException;

public class MatrixMultiplication {
    public void multiplyMatrices(Scanner scanner) {
        try {
            System.out.print("Enter number of rows of Matrix A (m): ");
            int m = scanner.nextInt();
            System.out.print("Enter number of columns of Matrix A (and rows of Matrix B) (n): ");
            int n = scanner.nextInt();
            System.out.print("Enter number of columns of Matrix B (p): ");
            int p = scanner.nextInt();

            if (m <= 0 || n <= 0 || p <= 0) {
                System.out.println("Error: All matrix dimensions must be greater than 0.");
                return;
            }

            int[][] A = new int[m][n];
            int[][] B = new int[n][p];
            int[][] C = new int[m][p];

            System.out.println("Enter Matrix A (" + m + "x" + n + "):");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = scanner.nextInt();
                }
            }

            System.out.println("Enter Matrix B (" + n + "x" + p + "):");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < p; j++) {
                    B[i][j] = scanner.nextInt();
                }
            }

            scanner.nextLine(); // clear buffer

            // Multiply matrices
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < p; j++) {
                    C[i][j] = 0;
                    for (int k = 0; k < n; k++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }

            System.out.println("Resultant Matrix C (" + m + "x" + p + "):");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < p; j++) {
                    System.out.print(C[i][j] + " ");
                }
                System.out.println();
            }

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid integer inputs.");
            scanner.nextLine();
        }
    }
}




/*
         ANALYSIS

Basic Operation: Multiplication A[i][k] * B[k][j] and addition +=
Number of basic operations:
Multiplications = m × n × p
Additions = m × n × p
Total = 2 × m × n × p
Time Complexity: O(m × n × p)
Space Complexity: O(m×n + n×p + m×p) ≈ O(n³) for cubic cases (like square matrices)
 */