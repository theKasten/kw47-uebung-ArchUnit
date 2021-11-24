package tictactoe.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tictactoe.game.Game;

public class MoveTest {

  private GameRepository gameRepository = mock(GameRepository.class);
  private GameService service = new GameService(gameRepository);

  private Game game = mock(Game.class);

  @BeforeEach
  void setup() {
    when(game.id()).thenReturn("foo");
    when(gameRepository.loadGame("foo")).thenReturn(game);
  }

  @Test
  @DisplayName("Durchführen eines Zuges lädt das Spiel aus der Datenbank")
  void test_1() {
    service.makeAMove("foo", 1, 1);
    verify(gameRepository).loadGame("foo");
  }

  @Test
  @DisplayName("Durchführen eines Zuges speichert das Spiel in der Datenbank")
  void test_2() {
    service.makeAMove("foo", 1, 1);
    verify(gameRepository).save(game);
  }

  @Test
  @DisplayName("Durchführen eines Zuges ruft den Zug in Game auf")
  void test_3() {
    service.makeAMove("foo", 1, 1);
    verify(game).makeMove(1, 1);
  }


}
