package tictactoe.game;

import static java.util.stream.Collectors.groupingBy;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

class Board {

  private Position pos(int row, int column) {
    return new Position(row, column);
  }

  private static record Position(int row, int column) {
  }

  private Optional<Player> winner = Optional.empty();
  private Map<Position, Player> board = new HashMap<>();
  
  public void setBoard(String s){
    int counter = 0;
    for(int y = 0; y < 3; y++) {
      for (int x = 0; x < 3; x++) {
        Position pos = new Position(x, y);
        Player currentPlayer;

        if(s.charAt(counter)== '-'){

        }else{
          currentPlayer = Player.valueOf(String.valueOf(s.charAt(counter)));
          board.put(pos, currentPlayer);
        }
        counter++;
      }
    }
  }


  Board place(Player p, int row, int column) {
    Board result = cloneBoard();
    result.board.put(pos(row, column), p);
    result.winner = result.checkWinner();
    return result;
  }

  int getNumberOfOccupiedFields() {
    return board.values().size();
  }


  private Optional<Player> checkWinner() {
    return Stream.of(getRowWinner(), getColumnWinner(), getDiagonal1Winner(), getDiagonal2Winner())
        .filter(e -> e != null).findFirst();
  }

  private Player getRowWinner() {
    for (int row = 0; row < 3; row++) {
      Optional<Player> player = get(row, 0);
      if (player.isPresent()
          && player.equals(get(row, 1))
          && player.equals(get(row, 2))) {
        return player.get();
      }
    }
    return null;
  }


  private Player getColumnWinner() {
    for (int column = 0; column < 3; column++) {
      Optional<Player> player = get(0, column);
      if (player.isPresent()
          && player.equals(get(1, column))
          && player.equals(get(2, column))) {

        return player.get();
      }
    }
    return null;
  }

  private Player getDiagonal1Winner() {
    Optional<Player> player = get(0, 0);
    if (!player.isPresent() || !player.equals(get(1, 1)) || !player.equals(get(2, 2))) {
      return null;
    }
    return player.get();
  }

  private Player getDiagonal2Winner() {
    Optional<Player> player = get(0, 2);
    if (!player.isPresent() || !player.equals(get(1, 1)) || !player.equals(get(2, 0))) {
      return null;
    }
    return player.get();
  }

  boolean isFull() {
    return board.size() == 9;
  }

  Optional<Player> get(int row, int column) {
    return Optional.ofNullable(board.get(pos(row, column)));
  }

  Optional<Player> winner() {
    return winner;
  }

  private Board cloneBoard() {
    Board result = new Board();
    result.board = new HashMap<>(this.board);
    return result;
  }


}
