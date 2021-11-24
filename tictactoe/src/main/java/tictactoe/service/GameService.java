package tictactoe.service;

import java.security.SecureRandom;
import java.util.Optional;
import java.util.Random;
import org.springframework.stereotype.Service;
import tictactoe.game.Game;
import tictactoe.game.Player;

@Service
public class GameService {

  private final GameRepository gameRepository;
  private final Random random = new SecureRandom();

  public GameService(GameRepository gameRepository) {
    this.gameRepository = gameRepository;
  }

  public String createNewGame() {
    Game game = new Game();
    gameRepository.save(game);
    return game.id();
  }

  public void makeAMove(String gameId, int row, int column) {
    Game game = gameRepository.loadGame(gameId);
    game.makeMove(row, column);
    gameRepository.save(game);
  }

  public Game getGame(String key) {
    Game game = gameRepository.loadGame(key);
    if (game == null) throw new IllegalArgumentException("No such Game");
    return game;
  }
}
