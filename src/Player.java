public class Player implements IPlayer {
  public Symbol symbol;
  public int id;

  public Player(Symbol symbol, int id) {
    this.symbol = symbol;
    this.id = id;
  }

  @Override
  public Symbol getSymbol() {
    return symbol;
  }

  @Override
  public int getID() {
    return id;
  }
}
