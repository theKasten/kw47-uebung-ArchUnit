package tictactoe.game;


import static org.assertj.core.api.Assertions.assertThat;
import static tictactoe.game.Player.X;


import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class GameTest {

  Game g = new Game();

  @Test
  @DisplayName("X fängt an")
  void test_1() {
    assertThat(g.active("X")).isTrue();
  }

  @Test
  @DisplayName("X könnte am Anfang einen beliebigen Zug machen, zum Beispiel 0,2")
  void test_2() {
    assertThat(g.validMove(0, 2)).isTrue();
  }

  @Test
  @DisplayName("Am Anfang ist jede Position leer, z.B. 1,1")
  void test_3() {
    assertThat(g.getSymbolAtPosition(1, 1)).isEqualTo("--");
  }

  @Test
  @DisplayName("Nachdem X einen Zug auf 1,2 gemacht hat, ist er dort vermerkt")
  void test_4() {
    g.makeMove(1, 2);
    assertThat(g.getSymbolAtPosition(1, 2)).isEqualTo("X");
  }

  @Test
  @DisplayName("Nachdem X einen Zug auf 2,2 gemacht hat, kann die Position nicht mehr belegt werden")
  void test_5() {
    g.makeMove(1, 2);
    assertThat(g.validMove(1, 2)).isFalse();
  }

  @Test
  @DisplayName("Es gibt keinen Sieger nach 3 Zügen")
  /*
  O-X
  -X-
  ---
   */
  void test_6() {
    g.makeMove(1,1);
    g.makeMove(0,0);
    g.makeMove(0,2);
    assertThat(g.winner()).isEmpty();
  }


  @Test
  @RepeatedTest(100)
  @DisplayName("Nach je 2 Zügen für X und O, gibt es keinen Sieger")
  void test_randomized() {
    for (int i = 0; i < 4; i++) {
      makeRandomValidMove(g);
    }
    assertThat(g.winner()).isEmpty();
  }

  private void makeRandomValidMove(Game g) {
    int row, column;
    do {
      int[] randomPosition = randomPosition();
      row = randomPosition[0];
      column = randomPosition[1];
    } while (!g.validMove(row, column));
    g.makeMove(row, column);
  }

  private int[] randomPosition() {
    Random r = new Random();
    int row = r.nextInt(3);
    int column = r.nextInt(3);
    return new int[] {row, column};
  }


}