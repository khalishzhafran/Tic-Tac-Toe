public class Board {
  public Symbol[][] square;
  public int dimension;

  public Board(int dimension) {
    this.dimension = dimension;
    square = new Symbol[dimension][dimension];
  }

  public void initialBoard() {
    for (int row = 0; row < dimension; row++) {
      for (int col = 0; col < dimension; col++) {
        square[row][col] = Symbol.Empty;
      }
    }
  }

  public void printBoard() {
    for (int row = 0; row < dimension; row++) {
      for (int col = 0; col < dimension; col++) {
        System.out.print(square[row][col] + " | ");
      }
      System.out.println();
    }
  }

  public boolean isSquareEmpty(int row, int col) {
    return square[row][col] != Symbol.Empty;
  }

  public boolean isBoardFull() {
    for (int row = 0; row < dimension; row++) {
      for (int col = 0; col < dimension; col++) {
        if (square[row][col] != Symbol.Empty) {
          return false;
        }
      }
    }

    return true;
  }

  public boolean isWinning(Symbol symbol) {
    // Check rows
    for (int row = 0; row < dimension; row++) {
      boolean isWinning = true;
      for (int col = 0; col < dimension; col++) {
        if (square[row][col] != symbol) {
          isWinning = false;
          break;
        }
      }
      if (isWinning) {
        return true;
      }
    }

    // Check columns
    for (int col = 0; col < dimension; col++) {
      boolean isWinning = true;
      for (int row = 0; row < dimension; row++) {
        if (square[row][col] != symbol) {
          isWinning = false;
          break;
        }
      }
      if (isWinning) {
        return true;
      }
    }

    // Check diagonals
    boolean isWinning = true;
    for (int row = 0; row < dimension; row++) {
      if (square[row][row] != symbol) {
        isWinning = false;
        break;
      }
    }
    if (isWinning) {
      return true;
    }

    isWinning = true;
    for (int row = 0; row < dimension; row++) {
      if (square[row][dimension - row - 1] != symbol) {
        isWinning = false;
        break;
      }
    }
    if (isWinning) {
      return true;
    }

    return false;
  }

  public boolean markSymbol(int row, int col, Symbol symbol) {
    if (isSquareEmpty(row, col)) {
      square[row][col] = symbol;
      return true;
    }

    return false;
  }
}