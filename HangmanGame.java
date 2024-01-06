import java.util.Scanner;

public class HangmanGame {
    private static String[] words = {"programming", "java", "hangman", "computer", "algorithm", "developer"};
    private static String selectedWord;
    private static char[] guessedWord;
    private static int attemptsLeft;

    public static void main(String[] args) {
        startGame();

        while (attemptsLeft > 0 && !isWordGuessed()) {
            displayGameState();
            char guessedLetter = getGuessFromUser();
            checkLetter(guessedLetter);
        }

        endGame();
    }

    private static void startGame() {
        // Select a random word from the list
        selectedWord = words[(int) (Math.random() * words.length)];

        // Initialize guessedWord with underscores
        guessedWord = new char[selectedWord.length()];
        for (int i = 0; i < selectedWord.length(); i++) {
            guessedWord[i] = '_';
        }

        attemptsLeft = 6; // Number of attempts allowed
    }

    private static void displayGameState() {
        System.out.println("Word: " + String.valueOf(guessedWord));
        System.out.println("Attempts left: " + attemptsLeft);
    }

    private static char getGuessFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Guess a letter: ");
        return scanner.next().charAt(0);
    }

    private static void checkLetter(char guessedLetter) {
        boolean letterGuessed = false;

        for (int i = 0; i < selectedWord.length(); i++) {
            if (selectedWord.charAt(i) == guessedLetter) {
                guessedWord[i] = guessedLetter;
                letterGuessed = true;
            }
        }

        if (!letterGuessed) {
            attemptsLeft--;
            System.out.println("Incorrect guess. Try again!");
        } else {
            System.out.println("Good guess!");
        }
    }

    private static boolean isWordGuessed() {
        return String.valueOf(guessedWord).equals(selectedWord);
    }

    private static void endGame() {
        if (isWordGuessed()) {
            System.out.println("Congratulations! You guessed the word: " + selectedWord);
        } else {
            System.out.println("Sorry, you ran out of attempts. The word was: " + selectedWord);
        }
    }
}
