package tictactoe.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tictactoe.game.Game;
import tictactoe.service.GameService;

@Controller
public class GameController {

  private final GameService service;

  public GameController(GameService service) {
    this.service = service;
  }

  @GetMapping("/")
  public String index() { return "index"; }

  @PostMapping("starten")
  public String starten(RedirectAttributes attributes) {
    String id = service.createNewGame();
    attributes.addAttribute("gameId", id);
    attributes.addAttribute("player", "X");
    return "redirect:/game";
  }

  @GetMapping("beitreten")
  public String game(String gameId, RedirectAttributes attributes) {
    Game game = service.getGame(gameId);

    attributes.addAttribute("gameId", gameId);
    attributes.addAttribute("player", "O");
    return "redirect:/game";
  }


  @GetMapping("game")
  public String game(Model m, @ModelAttribute("gameId") String gameId,
                     @ModelAttribute("player") String player) {
    Game game = service.getGame(gameId);
    m.addAttribute("game", game);
    m.addAttribute("active", game.active(player));
    return game.ende() ? "ende" : "spiel";
  }

  @PostMapping("ziehen")
  public String game(String gameId, String player, int row, int column,
                     RedirectAttributes attributes) {
    attributes.addAttribute("gameId", gameId);
    attributes.addAttribute("player", player);
    service.makeAMove(gameId, row, column);
    return "redirect:/game";
  }


}
