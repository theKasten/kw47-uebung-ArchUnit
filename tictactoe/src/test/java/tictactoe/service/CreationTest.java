package tictactoe.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tictactoe.game.Game;

;

public class CreationTest {


  @Test
  @DisplayName("Neues Spiel anlegen speichert ein Spiel in der Datenbank")
  void test_2() {
    GameRepository gameRepository = mock(GameRepository.class);
    GameService service = new GameService(gameRepository);
    String id = service.createNewGame();
    // Wir wissen nicht, welches Spiel, da wir darüber keine Kontrolle haben
    // Müssen wir in einem Integrationstest checken
    verify(gameRepository).save(any());
  }


  @Test
  @DisplayName("Der Service lädt Game Objekte aus dem Repository")
  void test_load1() {
    GameRepository gameRepository = mock(GameRepository.class);
    when(gameRepository.loadGame(any())).thenReturn(new Game());
    GameService service = new GameService(gameRepository);
    service.getGame("kBrtJywhan8uZKvNbxrqvYTf98VpXiJVu");
    verify(gameRepository).loadGame("kBrtJywhan8uZKvNbxrqvYTf98VpXiJVu");
  }

  @Test
  @DisplayName("Wenn ein Spiel im Repository nicht vorhanden ist, wird eine IllegalArgumentException geworfen")
  void test_load2() {
    GameRepository gameRepository = mock(GameRepository.class);
    GameService service = new GameService(gameRepository);
    IllegalArgumentException ex =
        assertThrows(IllegalArgumentException.class,
            () -> service.getGame("ajWqgWLzpKCGbA44QKdWjycJhJ4xHgFPa"));
    assertThat(ex.getMessage()).isEqualTo("No such Game");
  }


}
