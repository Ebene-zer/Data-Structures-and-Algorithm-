import Assignment1.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            try {
                System.out.println("\n=== Algorithm Options Menu ===");
                System.out.println("1. Find Maximum Element");
                System.out.println("2. Check Element Uniqueness");
                System.out.println("3. Multiply Matrices");
                System.out.println("4. Perform Gaussian Elimination");
                System.out.println("5. Count Binary Digits");
                System.out.println("6. Compute Factorial (Recursive)");
                System.out.println("7. Solve Tower of Hanoi Puzzle");
                System.out.println("8. Compute Fibonacci (Recursive & Iterative)");
                System.out.println("9. Exit");
                System.out.print("Enter your choice (1-9): ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        FindMaxElement maxFinder = new FindMaxElement();
                        maxFinder.findMax(scanner);
                        break;
                    case 2:
                        FindUniqueElement uniqueChecker = new FindUniqueElement();
                        uniqueChecker.checkUniqueness(scanner);
                        break;
                    case 3:
                        new MatrixMultiplication().multiplyMatrices(scanner);
                        break;
                    case 4:
                        new GaussianElimination().performElimination(scanner);
                        break;
                    case 5:
                        CountBinaryDigits binaryCount = new CountBinaryDigits();
                        binaryCount.countDigits(scanner);
                        break;
                    case 6:
                        new RecursiveFactorial().computeFactorial(scanner); //Another way to instantiate a class
                        break;
                    case 7:
                        new TowerOfHanoi().solveHanoi(scanner);
                        break;
                    case 8:
                        new Fibonacci().computeFibonacci(scanner);
                        break;
                    case 9:
                        System.out.println("Exiting program.");
                        continueProgram = false;
                        break;
                    default:
                        System.out.println("Invalid choice: Choose from 1-9.");
                }

            } catch (Exception e) {
                System.out.println("Invalid input: Enter a number.");
                scanner.nextLine(); // clear invalid input
            }
        }

        scanner.close();
    }
}


