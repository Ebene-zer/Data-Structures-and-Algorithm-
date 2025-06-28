package Assignment1;


/*
        ALGORITHM

Recursive:

Start
Read n
If n < 0, display error
If n == 0, return 0
If n == 1, return 1
Else, recursively compute F(n-1) + F(n-2)
Display result

Iterative:
Start
Read n
If n < 0, display error
Initialize F0 = 0, F1 = 1
For i = 2 to n
Fi = Fi-1 + Fi-2
Display Fi

              FLOWCHART

[Start]
    |
   Read n
     |
  Is n < 0 ?
     /   \
    Yes  No
    |     |
  Error   Is n == 0 ?
             /    \
            Yes    No
             |      |
        Return 0    Is n == 1 ?
                       /    \
                     Yes     No
                     |        |
                  Return 1    Return F(n-1)+F(n-2)
[End]


             PSEUDOCODE
    Recursive;
BEGIN
    INPUT n
    IF n < 0 THEN
        DISPLAY error
    ELSE
        CALL fib(n)
        DISPLAY result
END

FUNCTION fib(n)
    IF n == 0 RETURN 0
    ELSE IF n == 1 RETURN 1
    ELSE RETURN fib(n-1) + fib(n-2)


      Iterative;
BEGIN
    INPUT n
    IF n < 0 THEN
        DISPLAY error
    ELSE IF n == 0 RETURN 0
    ELSE IF n == 1 RETURN 1
    SET F0 = 0, F1 = 1
    FOR i = 2 TO n
        Fi = F0 + F1
        F0 = F1
        F1 = Fi
    DISPLAY F1
END


 */



import java.util.Scanner;
import java.util.InputMismatchException;

public class Fibonacci {
    public void computeFibonacci(Scanner scanner) {
        try {
            System.out.print("Enter a non-negative integer: ");
            int n = scanner.nextInt();

            if (n < 0) {
                System.out.println("Error: Fibonacci is not defined for negative numbers.");
                return;
            }

            long recursiveResult = recursiveFibonacci(n);
            long iterativeResult = iterativeFibonacci(n);

            System.out.println("Fibonacci (Recursive) F(" + n + ") = " + recursiveResult);
            System.out.println("Fibonacci (Iterative) F(" + n + ") = " + iterativeResult);

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid non-negative integer.");
            scanner.nextLine();
        }
    }

    // Recursive method
    private long recursiveFibonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    // Iterative method
    private long iterativeFibonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;

        long f0 = 0, f1 = 1, fn = 0;
        for (int i = 2; i <= n; i++) {
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return f1;
    }
}


/*
          ANALYSIS

   Recursive:

Time Complexity: O(2ⁿ) (Exponential, inefficient for large n)

Space Complexity: O(n) (call stack)

   Iterative:

Time Complexity: O(n)

Space Complexity: O(1)
 */