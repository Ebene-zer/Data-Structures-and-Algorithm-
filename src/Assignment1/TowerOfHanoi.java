package Assignment1;

/*
      ALGORITHM

Start
Read number of disks n
If n ≤ 0, display error
Call recursive function to move disks:
If n == 1, move from source to destination
Else:
Move n-1 disks from source to auxiliary
Move remaining disk to destination
Move n-1 disks from auxiliary to destination
Display all moves
End

             FLOWCHART
[Start]
    |
   Read n
      |
    Is n <= 0 ?
     /     \
   Yes     No
    |       |
  Error    Call hanoi(n, src, aux)
                   |
              Is n == 1 ?
                /      \
              Yes      No
               |       |
           Move disk   hanoi(n-1, src, aux,dest)
           from src to dest
                        hanoi(n-1, aux, dest, src)
[End]


               PSEUDOCODE

BEGIN
    INPUT n
    IF n ≤ 0 THEN
        DISPLAY "Invalid input"
    ELSE
        CALL hanoi(n, "A", "C", "B")
END

FUNCTION hanoi(n, source, destination, auxiliary)
    IF n == 1 THEN
        DISPLAY "Move disk from source to destination"
    ELSE
        CALL hanoi(n-1, source, auxiliary, destination)
        DISPLAY "Move disk from source to destination"
        CALL hanoi(n-1, auxiliary, destination, source)
END

 */

//   CODE

import java.util.Scanner;
import java.util.InputMismatchException;

public class TowerOfHanoi {
    public void solveHanoi(Scanner scanner) {
        try {
            System.out.print("Enter number of disks: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("Error: Number of disks must be greater than 0.");
                return;
            }

            System.out.println("Steps to solve Tower of Hanoi with " + n + " disks:");
            hanoi(n, "A", "C", "B");

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid integer.");
            scanner.nextLine();
        }
    }

    // Recursive function
    private void hanoi(int n, String source, String destination, String auxiliary) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
        } else {
            hanoi(n - 1, source, auxiliary, destination);
            System.out.println("Move disk " + n + " from " + source + " to " + destination);
            hanoi(n - 1, auxiliary, destination, source);
        }
    }
}

/*
      ANALYSIS

Basic Operation: Move disk
Number of basic operations (moves):
M(n) = 2^n - 1
Time Complexity: O(2^n) (exponential)
Space Complexity: O(n) (because of recursive call stack)
 */