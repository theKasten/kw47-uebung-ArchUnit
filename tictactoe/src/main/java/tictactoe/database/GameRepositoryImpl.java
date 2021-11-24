package tictactoe.database;

import java.util.HashMap;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tictactoe.game.Game;
import tictactoe.service.GameRepository;

@Repository
public class GameRepositoryImpl implements GameRepository {

  private final JdbcTemplate db;

  private final Map<String, Game> dummy = new HashMap<>();

  public GameRepositoryImpl(JdbcTemplate db) {
    this.db = db;
  }

  @Override
  public Game loadGame(String gameId) {

    return dummy.get(gameId);
  }

  @Override
  public void save(Game game) {
    dummy.put(game.id(), game);
  }


}
