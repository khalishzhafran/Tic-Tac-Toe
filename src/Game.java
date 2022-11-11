import java.util.Scanner; // java.util.Scanner for read input from console
import java.io.IOException; // java.io.IOException for clear console

public class Game {
  // Declare variables to store game status, board, players and current player
  private GameStatus gameStatus;
  private Player player1;
  private Player player2;
  private Player currentPlayer;

  public Board board = new Board(3);

  public Game(Player player1, Player player2) {
    // Set the players
    this.player1 = player1;
    this.player2 = player2;
  }

  public void playGame() {
    // Clear the console at the beginning of the game
    clearConsole();

    // Set the game status to InProgress
    gameStatus = GameStatus.InProgress;

    // Print the header
    System.out.println("Welcome to Tic Tac Toe Game");
    System.out.println("====================================\n");

    // Print the player information
    System.out.println("Player 1: " + player1.getSymbol());
    System.out.println("Player 2: " + player2.getSymbol() + "\n");

    // Print the initial board
    board.printBoard();

    // Set the current player to player 1
    currentPlayer = player1;

    // Start the reading input from console
    Scanner scanner = new Scanner(System.in);

    // Start the game loop
    while (gameStatus == GameStatus.InProgress) {
      // Print the current player information
      System.out.println("Player " + currentPlayer.getID() + " (" + currentPlayer.getSymbol() + ") turn:");

      // Read the row and column from console
      System.out.print("Enter row: ");
      int row = scanner.nextInt();
      System.out.print("Enter column: ");
      int col = scanner.nextInt();

      // Check if the move is valid
      if (board.markSymbol(row, col, currentPlayer.getSymbol())) {

        // Check if the current player wins
        if (board.isWinning(currentPlayer.getSymbol())) {
          // Set the game status to FirstPlayerWin or SecondPlayerWin
          if (currentPlayer.getID() == 1)
            gameStatus = GameStatus.FirstPlayerWin;
          else
            gameStatus = GameStatus.SecondPlayerWin;

          // Break the game loop
          break;
        }

        // Check if the board is full
        if (board.isBoardFull()) {
          // Set the game status to Draw
          gameStatus = GameStatus.Draw;

          // Break the game loop
          break;
        }

        // Change the current player
        if (currentPlayer == player1) {
          currentPlayer = player2;
        } else {
          currentPlayer = player1;
        }

        // Clear the console after each move
        clearConsole();

        // Print the last move
        System.out.println("Marked " + currentPlayer.getSymbol() + " at (" + row + ", " + col + ")\n");
      }

      // Print the board after each move
      board.printBoard();
    }

    // Stop reading input from console
    scanner.close();
  }

  public void clearConsole() {
    // Clear the console
    try {
      // Check if the operating system is Windows
      if (System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } catch (IOException | InterruptedException ex) {
    }
  }

  public GameStatus getGameStatus() {
    // Return the game status
    return gameStatus;
  }

  public void setGameStatus(GameStatus gameStatus) {
    // Set the game status
    this.gameStatus = gameStatus;
  }

  public Player getCurrentPlayer() {
    // Return the current player
    return currentPlayer;
  }
}
