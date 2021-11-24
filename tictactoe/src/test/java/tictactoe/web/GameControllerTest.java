package tictactoe.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import tictactoe.service.GameService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class GameControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    GameService service;

    @Test
    @DisplayName("Status of index is Ok")
    void test_1() throws Exception {
        mvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Funktoiniert /starten")
    void test_2() throws Exception {
        when(service.createNewGame()).thenReturn("sfhjkdaklfhjsd893hiusfd9834z");

        mvc.perform(post("/starten"))
                .andExpect(model()
                .attribute("gameId", "sfhjkdaklfhjsd893hiusfd9834z"))
                .andExpect(model().attribute("player", "X"));
    }


}