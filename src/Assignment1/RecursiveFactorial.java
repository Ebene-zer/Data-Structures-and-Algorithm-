package Assignment1;

/*
        ALGORITHM
Start
Read integer n
If n < 0, display error and stop
If n == 0, factorial is 1
Else, recursively compute factorial
Display result
End


        FLOWCHART

[Start]
    |
  Read n
      |
   Is n < 0 ?
       /  \
     Yes   No
      |      |
    Error    Is n == 0
              /     \
            Yes      No
             |       |
      result = 1     result = n x factorial(n-1)
                                  |
                                  Display result
[End]




               PSEUDOCODE

 BEGIN
    INPUT n
    IF n < 0 THEN
        DISPLAY "Invalid input"
    ELSE
        CALL factorial(n)
        DISPLAY result
END
FUNCTION factorial(n)
    IF n == 0 THEN
        RETURN 1
    ELSE
        RETURN n × factorial(n-1)
END

 */


//       CODE
import java.util.Scanner;
import java.util.InputMismatchException;

public class RecursiveFactorial {
    public void computeFactorial(Scanner scanner) {
        try {
            System.out.print("Enter a non-negative integer: ");
            int n = scanner.nextInt();

            if (n < 0) {
                System.out.println("Error: Factorial is not defined for negative numbers.");
                return;
            }

            long result = factorial(n);
            System.out.println(n + "! = " + result);

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid integer.");
            scanner.nextLine();
        }
    }

    // Recursive method
    private long factorial(int n) {
        if (n == 0)
            return 1;
        else
            return n * factorial(n - 1);
    }
}


/*
     ANALYSIS

Basic Operation: Multiplication n * factorial(n-1)
Number of basic operations:
Number of multiplications = n
Time Complexity: O(n)
Space Complexity: O(n) (because of recursion call stack)
 */