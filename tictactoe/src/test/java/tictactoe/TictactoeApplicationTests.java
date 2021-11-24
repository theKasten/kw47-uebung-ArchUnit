package tictactoe;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import tictactoe.web.GameController;

@SpringBootTest
class TictactoeApplicationTests {

  @Autowired
  GameController controller;

  @Test
  void contextLoads() {
    assertThat(controller).isNotNull();
  }

}
