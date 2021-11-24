package tictactoe.service;


import tictactoe.game.Game;

public interface GameRepository {
  Game loadGame(String gameId);

  void save(Game game);
}
