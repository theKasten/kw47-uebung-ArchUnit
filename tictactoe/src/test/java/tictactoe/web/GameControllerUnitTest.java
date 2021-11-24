package tictactoe.web;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import tictactoe.game.Game;
import tictactoe.service.GameService;

public class GameControllerUnitTest {
  
  @Test
  @DisplayName("Wenn das Spiel beendet ist, dann wird die Ende-Seite angezeigt")
  void test_0(){
    Game game = mock(Game.class);
    when(game.ende()).thenReturn(true);
    GameService service = mock(GameService.class);
    when(service.getGame(any())).thenReturn(game);

    GameController controller = new GameController(service);
    String page = controller.game(mock(Model.class), "", "");
    assertThat(page).isEqualTo("ende");
  }

  @Test
  @DisplayName("Wenn das Spiel nicht beendet ist, dann wird die Spiel-Seite angezeigt")
  void test_1(){
    Game game = mock(Game.class);
    when(game.ende()).thenReturn(false);
    GameService service = mock(GameService.class);
    when(service.getGame(any())).thenReturn(game);

    GameController controller = new GameController(service);
    String page = controller.game(mock(Model.class), "", "");
    assertThat(page).isEqualTo("spiel");
  }
  


  
}
