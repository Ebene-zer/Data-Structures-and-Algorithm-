package Assignment1;

/*
     ALGORITHM
Start
Read integer n
Check if n > 0
Initialize counter count = 0
While n > 0
Divide n by 2
Increment count
When n reaches 0, display count
End

       FLOWCHART

 [Start]
     |
     Read n
        |
        Is n > 0 ?
            /   \
            No   Yes
            |      |
          Error    Count = 0
                   while n > 0
                     n = n / 2
                     count ++
                   End while
                   Display count
[End]


             PSEUDOCODE

BEGIN
    INPUT n
    IF n <= 0 THEN
        DISPLAY "Invalid input"
    ELSE
        SET count = 0
        WHILE n > 0
            n = n / 2
            count = count + 1
        DISPLAY count
END


 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class CountBinaryDigits {
    public void countDigits(Scanner scanner) {
        try {
            System.out.print("Enter a positive integer: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("Error: Number must be greater than 0.");
                return;
            }

            int count = 0;
            int original = n;

            while (n > 0) {
                n = n / 2;
                count++;
            }

            System.out.println("Number of binary digits in " + original + " is: " + count);

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid positive integer.");
            scanner.nextLine();
        }
    }
}



/*
         ANALYSIS

Basic Operation: Division n = n / 2
Number of basic operations:
Number of divisions = log₂(n)
Time Complexity: O(log n)
Space Complexity: O(1)
 */