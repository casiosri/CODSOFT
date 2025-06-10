import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int round = 1;
        int totalScore = 0;
        String playAgain;

        System.out.println("=== Welcome to the Number Game! ===");

        do {
            int numberToGuess = rand.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + round + ": Guess the number between 1 and 100.");

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                int guess;

                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a number.");
                    continue;
                }

                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("Correct! You guessed the number.");
                    guessedCorrectly = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            if (guessedCorrectly) {
                int score = 100 - (attempts - 1) * 10;
                totalScore += score;
                System.out.println("You scored " + score + " points this round.");
            } else {
                System.out.println("Out of attempts! The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play another round? (y/n): ");
            playAgain = scanner.nextLine().trim().toLowerCase();
            round++;

        } while (playAgain.equals("y"));

        System.out.println("\nGame Over. You played " + (round - 1) + " rounds and scored " + totalScore + " points.");
        scanner.close();
    }
}
