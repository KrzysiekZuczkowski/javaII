package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloValidatorTest {

    @Autowired
    private TrelloValidator trelloValidator;

    @Test
    void validateTrelloBoards() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("test id", "test", new ArrayList<>()));

        //When
        List<TrelloBoard> validateTrelloBoards = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        assertEquals(0, validateTrelloBoards.size());
    }
}