package Assignment1;

/*
             ALGORITHM
  Start
Read number of elements, check if greater than 0
Read elements into an array
For each element in the array
Compare it with every other element after it
If a duplicate is found, display "Not unique" and stop
If loop completes with no duplicates, display "All elements are unique"
End


            FLOWCHART

 [Start]
    |
 Read n
     |
     Is n > 0 ?
         /  \
        No  Yes
              |
              Read Array
              for i = 0 to n - 2
                 for j = i + 1 to n - 1
                   if arr[i] == arr [j]
                      Display "Not unique"
                      End
               End loops
               Display "All elements are unique"

 [End]


            PSEUDOCODE

  BEGIN
    INPUT n
    IF n <= 0 THEN
        DISPLAY "Invalid input size"
    ELSE
        INPUT array of n elements
        FOR i = 0 to n-2
            FOR j = i+1 to n-1
                IF array[i] == array[j] THEN
                    DISPLAY "Not unique"
                    EXIT
        DISPLAY "All elements are unique"
  END

 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class FindUniqueElement {
    public void checkUniqueness(Scanner scanner) {
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

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (numbers[i] == numbers[j]) {
                        System.out.println("The numbers are NOT unique.");
                        return;
                    }
                }
            }

            System.out.println("All numbers are unique.");

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid integer inputs.");
            scanner.nextLine();
        }
    }
}



/*
     ANALYSIS

Basic Operation: Comparison if (numbers[i] == numbers[j])
Number of basic operations:
Number of comparisons = n(n-1)/2
Time Complexity:
Best case: O(1) (if first duplicate found early)
Worst case: O(n²) (if no duplicates and all comparisons done)
Average case: Between O(1) and O(n²)
Space Complexity:
O(n) for storing the array

 */