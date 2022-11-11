import java.util.Scanner;
import java.io.IOException;

public class Game {
  public static void main(String[] args) {
    Board board = new Board(3);
    Player player1 = new Player(Symbol.Cross, 1);
    Player player2 = new Player(Symbol.Circle, 2);
    Player currentPlayer = player1;
    Scanner scanner = new Scanner(System.in);

    clearConsole();

    board.printBoard();
    while (true) {
      System.out.println("Player " + currentPlayer.getID() + " (" + currentPlayer.getSymbol() + ") turn:");
      System.out.print("Enter row: ");
      int row = scanner.nextInt();
      System.out.print("Enter column: ");
      int col = scanner.nextInt();
      if (board.markSymbol(row, col, currentPlayer.getSymbol())) {
        if (board.isWinning(currentPlayer.getSymbol())) {
          System.out.println("Player " + currentPlayer.getID() + " (" + currentPlayer.getSymbol() + ") wins!");
          break;
        }
        if (board.isBoardFull()) {
          System.out.println("Draw!");
          break;
        }
        if (currentPlayer == player1) {
          currentPlayer = player2;
          clearConsole();
        } else {
          currentPlayer = player1;
          clearConsole();
        }
      } else {
        System.out.println("Invalid move!");
      }
      board.printBoard();
    }

    scanner.close();
  }

  public static void clearConsole() {
    try {
      if (System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      else
        Runtime.getRuntime().exec("clear");
    } catch (IOException | InterruptedException ex) {
    }
  }

  public void playGame() {
  }
}