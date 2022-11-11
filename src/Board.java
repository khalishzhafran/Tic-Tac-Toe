public class Board {
  public Symbol[][] square;
  public int dimension;

  public Board(int dimension) {
    // Set the dimension of the board and initialize the square array
    this.dimension = dimension;
    square = new Symbol[dimension][dimension];
  }

  public void initialBoard() {
    // Initialize the board with empty symbols
    for (int row = 0; row < dimension; row++) {
      for (int col = 0; col < dimension; col++) {
        square[row][col] = Symbol.Empty;
      }
    }
  }

  public void printBoard() {
    // Print the board
    for (int row = 0; row < dimension; row++) {
      for (int col = 0; col < dimension; col++) {
        System.out.print(square[row][col] + " | ");
      }
      System.out.println();
    }

    System.out.println();
  }

  public boolean wasMarked(int row, int col) {
    // Check if the square was marked

    // It will return true if the square was marked
    return square[row][col] == Symbol.Empty;
  }

  public boolean isBoardFull() {
    boolean isFull = true;
    // Check if the board is full
    for (int row = 0; row < dimension; row++) {
      for (int col = 0; col < dimension; col++) {
        // Check if the square is empty
        if (!wasMarked(row, col)) {
          // If the square wasn't marked, return false
          isFull = false;
        }
      }
    }

    // Return true if the board is full
    return isFull;
  }

  public boolean isWinning(Symbol symbol) {
    // Check the winning condition

    // Check the rows
    // Loop the rows
    for (int row = 0; row < dimension; row++) {

      // Make a variable to store the status of the row
      boolean isWinning = true;

      // Loop the columns
      for (int col = 0; col < dimension; col++) {
        // Check if every square in the row was marked with the same symbol
        if (square[row][col] != symbol) {
          isWinning = false;

          // Break the column loop if the square wasn't marked with the same symbol
          break;
        }
      }

      // Return true if the row was marked with the same symbol
      if (isWinning) {
        return true;
      }
    }

    // Check columns
    // Loop the columns
    for (int col = 0; col < dimension; col++) {

      // Make a variable to store the status of the column
      boolean isWinning = true;

      // Loop the rows
      for (int row = 0; row < dimension; row++) {

        // Check if every square in the column was marked with the same symbol
        if (square[row][col] != symbol) {
          isWinning = false;

          // Break the row loop if the square wasn't marked with the same symbol
          break;
        }
      }

      // Return true if the column was marked with the same symbol
      if (isWinning) {
        return true;
      }
    }

    // Check diagonals
    // Make a variable to store the status of the diagonal
    boolean isWinning = true;

    // Loop the rows
    for (int row = 0; row < dimension; row++) {

      // Check if every square in the diagonal was marked with the same symbol
      // Check from top left to bottom right
      if (square[row][row] != symbol) {
        isWinning = false;

        // Break the row loop if the square wasn't marked with the same symbol
        break;
      }
    }

    // Return true if the diagonal was marked with the same symbol
    if (isWinning) {
      return true;
    }

    isWinning = true;

    // Loop the rows
    for (int row = 0; row < dimension; row++) {

      // Check if every square in the diagonal was marked with the same symbol
      // Check from top right to bottom left
      if (square[row][dimension - row - 1] != symbol) {
        isWinning = false;

        // Break the row loop if the square wasn't marked with the same symbol
        break;
      }
    }

    // Return true if the diagonal was marked with the same symbol
    if (isWinning) {
      return true;
    }

    // Return false if the board wasn't marked with the same symbol
    return false;
  }

  public boolean markSymbol(int row, int col, Symbol symbol) {
    // Check if the square was marked
    if (!wasMarked(row, col)) {
      square[row][col] = symbol;

      // Return true if the square was marked
      return true;
    }

    // Return false if the square wasn't marked
    return false;
  }
}