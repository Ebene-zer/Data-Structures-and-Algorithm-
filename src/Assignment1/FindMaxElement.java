package Assignment1;


/*

Finding Maximum element in a given list of numbers
           Algorithm
1. Start
2. Read the list of n numbers
3. Assign the first number as the maximum
4. For each remaining number:
If the number is greater than the current maximum, update the maximum
5. After checking all numbers, output the maximum
6. End

          Flowchart
[Start]
|
Read n
|Is n > 0 ?
    /    \
   No     Yes
   Error     |
            Read Array
            max = arr[0]
            for i = 1 to n - 1
                if arr[i] > max
                   max = arr[i]
            End for
            Display max

            [Repeat]


          Pseudocode
BEGIN
INPUT n
INPUT numbers[1 to n]
max ← numbers[1]
FOR i from 2 to n DO
IF numbers[i] > max THEN
max ← numbers[i]
END IF
END FOR
OUTPUT max
END

 */


import java.util.Scanner;
import java.util.InputMismatchException;

public class FindMaxElement {
    public void findMax(Scanner scanner) {
        try {
            System.out.print("Enter number of elements: ");
            int n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("Error: Number of elements must be greater than 0.");
                return;
            }

            int[] numbers = new int[n];
            System.out.println("Enter " + n + " numbers:");

            for (int i = 0; i < n; i++) {
                numbers[i] = scanner.nextInt();
            }

            // Clear input buffer after reading numbers
            scanner.nextLine();

            int max = numbers[0];
            for (int i = 1; i < n; i++) {
                if (numbers[i] > max) {
                    max = numbers[i];
                }
            }

            System.out.println("The maximum number is: " + max);

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid integer inputs.");
            scanner.nextLine();
        }
    }
}


/*
        Analysis
Basic Operation: Comparison if (numbers[i] > max)

Number of basic operations: n - 1 (since we start from index 1)

Time Complexity:

Best case: O(n)

Worst case: O(n)

Average case: O(n)
(since in all cases, it loops through n-1 elements)

Space Complexity:

O(n) for storing the array
 */