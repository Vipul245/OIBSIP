import java.util.Random;
import java.util.Scanner;

public class NoGuess {
    public static void main(String[] args) {
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        String playAgain;
        do {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            System.out.println("Welcome to Guess the Number!");
            System.out.println("I have generated a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");
            
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    guessedCorrectly = true;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Oops! You couldn't guess the number. The correct number was: " + generatedNumber);
            }
            
            // Calculate score based on the number of attempts
            int roundScore = maxAttempts - attempts + 1;
            score += roundScore;
            System.out.println("Your score for this round: " + roundScore);
            System.out.println("Total score: " + score);
            
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next();
            System.out.println();
            
        } while (playAgain.equalsIgnoreCase("yes"));
        
        System.out.println("Thank you for playing Guess the Number!");
        scanner.close();
    }
}
