package tictactoe.database;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import tictactoe.game.Game;

import static org.assertj.core.api.Assertions.assertThat;

@JdbcTest
@ActiveProfiles("test")
public class GameRepositoryTest {

    @Autowired
    JdbcTemplate db;

    @Disabled("Noch in der Entwicklung")
    @Test
    @Sql({"classpath:db/migration/V1__init.sql",
            "classpath:loadtest.sql"})
    @DisplayName("")
    void test_1() {
        //arrange
        GameRepositoryImpl gameRepository = new GameRepositoryImpl(db);
        //act
        Game game = gameRepository.loadGame("ee10c6f6-ae99-4873-9e52-440df96f647f");
        //assert
        assertThat(game).isNotNull();
    }

}
