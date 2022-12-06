package com.crud.tasks.trello.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloConfigTest {

    @Autowired
    private TrelloConfig trelloConfig;

    @Test
    void getTrelloApiEndPoint() {
        //Given
        //When
        String apiEndPoint = trelloConfig.getTrelloApiEndPoint();

        //Then
        assertEquals("https://api.trello.com/1", apiEndPoint);
    }

    @Test
    void getTrelloApiUsername() {
        //Given
        //When
        String apiUsername = trelloConfig.getTrelloApiUsername();

        //Then
        assertEquals("/members/krzysiekzuczkowski/boards", apiUsername);
    }

    @Test
    void getTrelloAppKey() {
        //Given
        //When
        String trelloAppKey = trelloConfig.getTrelloAppKey();

        //Then
        assertTrue(trelloAppKey.contains("5c8136"));
    }

    @Test
    void getTrelloToken() {
        //Given
        //When
        String trelloToken = trelloConfig.getTrelloToken();

        //Then
        assertTrue(trelloToken.contains("93eaeba5"));
    }
}