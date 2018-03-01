import java.util.Scanner;

/**
 * Driver file for RandomGame. This class handles processing which game the
 * user wants to play, creating the RandomGame objects to process gameplay,
 * and keeping track of the user's score.
 */
public class GameDriver {

    // These are the RandomGame static variables given to you.
    private static RandomGame coinGame;
    private static RandomGame cardSuitGame;
    private static RandomGame cardRankGame;
    private static RandomGame diceGame;
    // This variable should default to be 128.
    private static int bufferSize;

    // Score variable goes here!. Should be a static int.
    private static int score;

    private static String game;
    private static int suitConv;
    private static String again;
    private static String suitOutput;
    /**
     * Main method. The main method should take in an argument from the command
     * line to be the random values array size, or 128 if an argument is not
     * given. The main method should then loop as long as the user is willing to
     * play the game and ask the user which game to play. Based on what the user
     * says, the RandomGame should either call the do___Game() method or
     * tell the user the input is invalid and ask if they want to play again.
     * Once the user has finished playing the total score should be printed.
     * @param args The size of the array buffer of random values.
     */
    public static void main(String[] args) {
        Scanner inScanner = new Scanner(System.in);
        // YOUR CODE HERE : Initialize the buffer size
        if (args.length == 0) {
            bufferSize = 128;
        } else {
            bufferSize = Integer.parseInt(args[0]);
        }
        // Initialize the provided games. DO NOT MODIFY!
        cardRankGame = new RandomGame(13, bufferSize);
        cardSuitGame = new RandomGame(4, bufferSize);
        coinGame = new RandomGame(2, bufferSize);
        // YOUR CODE HERE : Process which game to play.s
        System.out.println("Enter the game you would like to play"
            + "(coins, dice, cards): ");
        game = inScanner.nextLine();
        if (game.equals("coins")) {
            playCoinGame(inScanner);
        } else if (game.equals("dice")) {
            playDiceGame(inScanner);
        } else if (game.equals("cards")) {
            playCardGame(inScanner);
        } else {
            System.out.println("Your input is invalid!");
        }
        System.out.println("Would you like to play again? (y/n): ");
        again = inScanner.next();
        if (again.equals("y")) {
            main(args);
        } else {
            System.out.println("Your score is: " + score);
        }

    }

    /**
     * Do a coin game with the given input scanner.
     * This method asks the user for input using the given scanner, checks
     * if it is correct and prints the results.
     * Do not modify this method! This is a sample method for how
     * RandomGame is used.
     *@param inScanner The scanner to scan input from.
     */
    public static void playCoinGame(Scanner inScanner) {
        System.out.print("Enter your guess (h/t): ");
        int guess = (inScanner.next().charAt(0) == 'h') ? 1 : 2;
        boolean right = coinGame.checkGuess(guess);
        int correct = coinGame.getLastEvent();
        if (!right) {
            System.out.print("Nope!");
        } else {
            System.out.print("Yep!");
            score++;
        }
        System.out.printf(" Your guess: %s; Correct: %s",
                ((guess == 1) ? "h" : "t"), ((correct == 1) ? "h" : "t")
                + "\n");
    }

    /**
     * Do a dice game with the given input scanner. This method
     * first should ask the user how many faces they want on their die, then
     * should ask the user for their guess. Using a RandomGame
     * instance, the user's guess should be checked and the results should
     * be printed.
     * @param inScanner The scanner to scan input from.
     */
    public static void playDiceGame(Scanner inScanner) {
        System.out.print("Enter the number of faces you want on your dice: ");
        int faces = inScanner.nextInt();
        System.out.print("Enter your guess (1 - # of faces): ");
        int guess = inScanner.nextInt();
        diceGame = new RandomGame(faces, bufferSize);
        boolean right = diceGame.checkGuess(guess);
        int correct = diceGame.getLastEvent();
        if (!right) {
            System.out.print("Nope!");
        } else {
            System.out.print("Yep!");
            score += (faces / 2);
        }
        System.out.printf(" Your guess: %s; Correct: %s", guess, correct
            + "\n");
    }

    /**
     * Do a card game with the given input scanner. This takes a guess from
     * the user about the suit and rank and scores them separately. The user
     * should be able to enter the suit as a String and the rank as an int,
     * but this method should use the provided RandomGame Objects
     * for suit and rank (as in coin game). The user should then print the
     * results.
     * @param inScanner The scanner to scan input from.
     */
    public static void playCardGame(Scanner inScanner) {
        System.out.print("Guess the suit (spades, clubs, diamonds, hearts): ");
        String suit = inScanner.nextLine();
        if (suit.equals("spades")) {
            suitConv = 1;
        } else if (suit.equals("clubs")) {
            suitConv = 2;
        } else if (suit.equals("diamonds")) {
            suitConv = 3;
        } else {
            suitConv = 4;
        }
        boolean rightSuit = cardSuitGame.checkGuess(suitConv);
        int correctSuit = cardSuitGame.getLastEvent();
        System.out.print("Guess the rank as an int (ace is 1; king is 13):");
        int rank = inScanner.nextInt();
        boolean rightRank = cardRankGame.checkGuess(rank);
        int correctRank = cardRankGame.getLastEvent();
        if (!rightRank) {
            System.out.print("Nope!");
        } else {
            System.out.print("Yep!");
            score += 2;
        }
        System.out.printf(" Your rank guess: %s; Correct rank : %s"
            , rank, correctRank);
        if (!rightSuit) {
            System.out.print("Nope!");
        } else {
            System.out.print("Yep!");
            score += 6;
        }
        if (correctSuit == 1) {
            suitOutput = "spades";
        } else if (correctSuit == 2) {
            suitOutput = "clubs";
        } else if (correctSuit == 3) {
            suitOutput = "diamonds";
        } else if (correctSuit == 3) {
            suitOutput = "hearts";
        }
        System.out.printf(" Your suit guess: %s; Correct suit: %s"
            , suit, suitOutput + "\n");
    }

    /**
     * Get the size of the random values buffer in RandomGame.
     * @return See above.
     */
    public static int getBufferSize() {
        return bufferSize;
    }

}
