public class NumberGuessingChallengeSolution {
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
      System.out.println(String.format("Attempts remaining: %s", maxGuesses - totalGuesses));
      System.out.print("Guess the secret number: ");
      int input = WaitForInput();
      totalGuesses++;

      if (secretNumber == input) {
        System.out.println("Your guess is correct. You win!");
        if (!PlayAgain()) break;
      } else {
        System.out.print("\033\143"); // Clears console.
        System.out.println(String.format("Secret number is %s than %s", Math.min(secretNumber, input) == secretNumber ? "lower" : "higher", input));
      }

      if (totalGuesses == maxGuesses) {
        System.out.println(String.format("You have ran out of guesses. The secret number was %s.", secretNumber));
        if (!PlayAgain()) break;
      }
    }
    sc.close();
  }

  private boolean PlayAgain() {
    System.out.print("Play again? (y/n) ");
    String ans = sc.next();
    if (ans.toLowerCase().equals("y")) {
      totalGuesses = 0;
      secretNumber = GenerateRandomNumber(maxGuessingRange);
      return true;
    }
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