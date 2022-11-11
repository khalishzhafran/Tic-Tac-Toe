public class App {
  public static void main(String[] args) {
    // Instantiate players
    Player player1 = new Player(Symbol.Cross, 1);
    Player player2 = new Player(Symbol.Circle, 2);

    // Instantiate game
    Game game = new Game(player1, player2);

    // Play game
    game.playGame();

    // Check if the game is over
    if (game.getGameStatus() == GameStatus.FirstPlayerWin || game.getGameStatus() == GameStatus.SecondPlayerWin) {
      System.out.println();
      game.board.printBoard();
      System.out.println(
          "Player " + game.getCurrentPlayer().getID() + " (" + game.getCurrentPlayer().getSymbol() + ") wins!");
    }

    if (game.getGameStatus() == GameStatus.Draw) {
      System.out.println();
      game.board.printBoard();
      System.out.println("Draw!");
    }
  }
}
