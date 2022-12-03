package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    void mapToList() {
        //Given
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto(
                "Test List id", "Test List name", false));

        //When
        List<TrelloList> trelloList = trelloMapper.mapToList(trelloListDtos);

        //Then
        assertEquals(1, trelloList.size());
        assertThat(trelloList).isNotNull();
        assertThat(trelloList.get(0).getName()).isEqualTo("Test List name");
        assertThat(trelloList.get(0).isClosed()).isFalse();
    }

    @Test
    void mapToBoards() {
        //Given
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(new TrelloBoardDto(
                "Test Board id", "Test Board name", new ArrayList<>()));

        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtos);

        //Then
        assertEquals(1, trelloBoards.size());
        assertEquals(0, trelloBoards.get(0).getLists().size());
        assertThat(trelloBoards).isNotNull();
        assertThat(trelloBoards.get(0).getName()).isEqualTo("Test Board name");
    }

    @Test
    void mapToListDto() {
        //Given
        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList());

        //When
        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(trelloList);

        //Then
        assertEquals(1, trelloListDtos.size());
        assertThat(trelloListDtos).isNotNull();
        assertThat(trelloListDtos.get(0).getName()).isNull();
        assertThat(trelloListDtos.get(0).isClosed()).isFalse();
    }


    @Test
    void mapToBoardsDto() {
        //Given
        List<TrelloBoard> trelloBoard = new ArrayList<>();
        trelloBoard.add(new TrelloBoard("Test Board id", "Test Board name",
                        List.of(new TrelloList("1", "test name", false)))
        );

        //When
        List<TrelloBoardDto> trelloBoardDtos = trelloMapper.mapToBoardsDto(trelloBoard);

        //Then
        assertEquals(1, trelloBoardDtos.size());
        assertEquals(1, trelloBoardDtos.get(0).getLists().size());
        assertThat(trelloBoardDtos).isNotNull();
        assertThat(trelloBoardDtos.get(0).getName()).isEqualTo("Test Board name");
        assertThat(trelloBoardDtos.get(0).getLists().get(0).getName()).isNotNull();
        assertThat(trelloBoardDtos.get(0).getLists().get(0).getName()).isEqualTo("test name");
    }

    @Test
    void mapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Test card name",
                "Test card description",
                "Test pos", "Test listId");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertThat(trelloCardDto).isNotNull();
        assertThat(trelloCardDto.getName()).isEqualTo("Test card name");
        assertThat(trelloCardDto.getDescription()).isEqualTo("Test card description");
    }

    @Test
    void mapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Test cardDto name",
                "Test cardDto description",
                "Test pos", "Test listId");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertThat(trelloCard).isNotNull();
        assertThat(trelloCard.getName()).isEqualTo("Test cardDto name");
        assertThat(trelloCard.getDescription()).isEqualTo("Test cardDto description");
    }
}