/**
 * <p>{@link #GenerateRandomNumber()} and {@link #WaitForInput()} functions have been included to be used in the game.</p>
 * 
 * <b>Task:</b>
 * <ol>
  * <li>Show the user the remaining attempts.</li>
  * <li>Add logic to check if the guess is correct.</li>
  * <li>Show the user if the guess is higher/lower than the secret number.</li>
  * <li>Show message to the user if they win or lose (by running out of guesses).</li>
 * </ol>
 */
public class NumberGuessingGame {
  public static void main(String[] args) {
    new NumberGuessingChallenge(5, 100);
  }
}

class NumberGuessingChallenge {
  private int secretNumber;
  private int maxGuesses = 5;
  private int totalGuesses = 0;
  private int maxGuessingRange = 100;
  private static java.util.Scanner sc = new java.util.Scanner(System.in);

  public NumberGuessingChallenge(int maxGuesses, int guessingRange) {
    this.maxGuesses = maxGuesses;
    this.maxGuessingRange = guessingRange;
    GameLoop();
  }

  void GameLoop() {
    secretNumber = GenerateRandomNumber(maxGuessingRange);
    while (true) {
      System.out.print("Guess the secret number: ");
      // TODO: Add game logic.
    }
    sc.close();
  }
  /**
   * Asks for user input to check if player wants to play again.
   * @return True|False if player provides yes or no answer.
   */
  boolean PlayAgain() {
    System.out.print("Play again? (y/n) ");
    // TODO: Add play again logic, reset variables and generate a new secret number.
    return false;
  }



  // ------------------------ Functions ------------------------------ //
  //         These functions can be used in your game loop.            //
  //       You don't need to worry about the contents of them.         //
  // ----------------------------------------------------------------- //

  /**
   * Waits for user input and validates if it's a number.
   * @return (Int) number from user input.
   */
  static int WaitForInput() {
    try {
      return sc.nextInt();
    } catch (Exception ex) {
      System.err.print("Invalid input, please enter a number: ");
      sc.nextLine();
      return WaitForInput();
    }
  }

  /**
   * Generates a random number within range.
   * @param maxRange Maximum range value of the generator (inclusive).
   * @return (Int) random number.
   */
  static int GenerateRandomNumber(int maxRange) {
    final java.util.Random r = new java.util.Random();
    return r.nextInt(maxRange) + 1;
  }
}