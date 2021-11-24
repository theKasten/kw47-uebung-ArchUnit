package tictactoe.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidityCheckTest {

  @Test
  @DisplayName("Wenn versucht wird ein Feld doppelt zu belegen, wird eine Exception geworfen")
  void test_1() {
    Game game = new Game();
    game.makeMove(1,1);
    Assertions.assertThrows(IllegalArgumentException.class, () -> game.makeMove(1,1));
  }

}
