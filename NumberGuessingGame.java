import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int maxAttempts = 7;
        int score = 0;
        boolean playAgain = true;

        System.out.println(" Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = rand.nextInt(100) + 1; // generates number from 1 to 100
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n I've picked a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it!");

            while (attempts < maxAttempts) {
                System.out.print(" Enter your guess: ");
                int userGuess;

                // Validate integer input
                if (sc.hasNextInt()) {
                    userGuess = sc.nextInt();
                } else {
                    System.out.println(" Please enter a valid integer.");
                    sc.next(); // clear invalid input
                    continue;
                }

                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println(" Correct! You've guessed the number in " + attempts + " attempts.");
                    score++;
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println(" Too low!");
                } else {
                    System.out.println(" Too high!");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println(" You've used all your attempts. The number was: " + numberToGuess);
            }

            // Ask user if they want to play again
            System.out.print(" Do you want to play another round? (yes/no): ");
            String response = sc.next().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\n Game Over! Your final score is: " + score);
        sc.close();
    }
}
