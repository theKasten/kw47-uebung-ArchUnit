package tictactoe.game;

import annotations.AggregateRoot;

import java.util.Optional;
import java.util.UUID;

public class Game {

  private Board board;
  private final UUID id;

  public Game() {
    board = new Board();
    id = UUID.randomUUID();
  }

  public Player nextToMove() {
    int p = board.getNumberOfOccupiedFields() % 2;
    return Player.values()[p];
  }


  public boolean validMove(int row, int column) {
    return board.get(row, column).isEmpty();
  }


  /**
   * Führt den Spielzug für den Spieler durch, der gerade an der Reihe ist.
   * @param row
   * @param column
   * @throws ArrayIndexOutOfBoundsException wenn eine Position gewählt wurde, die nicht zwischen 0 und 2 liegt
   * @throws IllegalArgumentException wenn die Position schon belegt ist
   */
  public void makeMove(int row, int column) {
    if (!validMove(row, column)) throw new IllegalArgumentException("Ungültiger Zug.");
    board = board.place(nextToMove(), row, column);
  }

  public Optional<Player> winner() {
    return board.winner();
  }


  public String getSymbolAtPosition(int row, int column) {
    if (board.get(row, column).isEmpty()) return "--";
    return board.get(row, column).get().toString();
  }


  public String id() {
    return id.toString();
  }

  public boolean active(String player) {
    return Player.valueOf(player) == nextToMove();
  }


  public boolean ende() {
    return winner().isPresent() || board.isFull();
  }


}
