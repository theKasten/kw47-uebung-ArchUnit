package tictactoe.game;

import static org.assertj.core.api.Assertions.assertThat;
import static tictactoe.game.Player.O;
import static tictactoe.game.Player.X;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EndSzenarien {

  Game g = new Game();

  @Test
  @DisplayName("Am Anfang gibt es keinen Gewinner")
  void test_0(){
   assertThat(g.winner().isEmpty());
  }
  
  @Test
  @DisplayName("Wenn das Board voll ist, kann das Spiel unentschieden enden")
    /*
    XOX
    OOX
    0XO
   */
  void test_unentschieden(){
    g.makeMove(0,0);
    g.makeMove(1,1);
    g.makeMove(0,2);
    g.makeMove(0,1);
    g.makeMove(2,1);
    g.makeMove(1,0);
    g.makeMove(1,2);
    g.makeMove(2,2);
    g.makeMove(2,0);
   assertThat(g.ende()).isTrue();
   assertThat(g.winner()).isEmpty();
  }
  


  @Test
  @DisplayName("Gewinnszenario: X gewinnt in Zeile 2")
  /*
    OO-
    XXX
    ---
   */
  void test_zeile(){
    g.makeMove(1,0);
    g.makeMove(0,0);
    g.makeMove(1,1);
    g.makeMove(0,1);
    g.makeMove(1,2);
    assertThat(g.ende()).isTrue();
    assertThat(g.winner()).contains(X);
  }

  @Test
  @DisplayName("Gewinnszenario: O gewinnt in Spalte 3")
    /*
    X-O
    XXO
    --O
   */
  void test_spalte(){
    g.makeMove(0,0);
    g.makeMove(0,2);
    g.makeMove(1,1);
    g.makeMove(2,2);
    g.makeMove(1,0);
    g.makeMove(1,2);
    assertThat(g.ende()).isTrue();
    assertThat(g.winner()).contains(O);
  }

  @Test
  @DisplayName("Gewinnszenario: X gewinnt auf der Haupdiagonalen")
    /*
    -OO
    -X-
    --X
   */
  void test_diagonale1(){
    g.makeMove(1,1);
    g.makeMove(0,2);
    g.makeMove(2,2);
    g.makeMove(0,1);
    g.makeMove(0,0);
    assertThat(g.ende()).isTrue();
    assertThat(g.winner()).contains(X);
  }

  @Test
  @DisplayName("Gewinnszenario: X gewinnt auf der Gegendiagonalen")
    /*
    O-X
    OX-
    X--
   */
  void test_diagonale2(){
    g.makeMove(1,1);
    g.makeMove(0,0);
    g.makeMove(0,2);
    g.makeMove(1,0);
    g.makeMove(2,0);
    assertThat(g.ende()).isTrue();
    assertThat(g.winner()).contains(X);
  }





}
