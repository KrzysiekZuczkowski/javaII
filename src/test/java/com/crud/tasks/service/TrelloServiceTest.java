package com.crud.tasks.service;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TrelloServiceTest {

//    @InjectMocks
//    private TrelloService trelloService;
//
//    @Mock
//    private TrelloClient trelloClient;
//
//    @Mock
//    private RestTemplate restTemplate;
//
//    @Mock
//    private TrelloConfig trelloConfig;
//
//
//    @Test
//    void fetchTrelloBoards() throws URISyntaxException {
//        // Given
//        when(trelloConfig.getTrelloApiEndPoint()).thenReturn("http://test.com");
//        when(trelloConfig.getTrelloAppKey()).thenReturn("test");
//        when(trelloConfig.getTrelloToken()).thenReturn("test");
//        when(trelloConfig.getTrelloApiUsername()).thenReturn("/members/test/boards");
//
//        TrelloBoardDto[] trelloBoards = new TrelloBoardDto[1];
//        trelloBoards[0] = new TrelloBoardDto("test_id", "Kodilla", new ArrayList<>());
//
//        URI uri = new URI("http://test.com/members/test/boards?key=test&token=test&fields=name,id&lists=all");
//
//        when(restTemplate.getForObject(uri, TrelloBoardDto[].class)).thenReturn(trelloBoards);
//        // When
//        List<TrelloBoardDto> fetchedTrelloBoards = trelloService.fetchTrelloBoards(); //trelloClient.getTrelloBoards();
//        // Then
//        assertEquals(0, fetchedTrelloBoards.size());
//        assertEquals("test_id", fetchedTrelloBoards.get(0).getId());
//        assertEquals("Kodilla", fetchedTrelloBoards.get(0).getName());
//        assertEquals(new ArrayList<>(), fetchedTrelloBoards.get(0).getLists());

//        //Given
//        //When
//        List<TrelloBoardDto> trelloBoardDtos =  trelloService.fetchTrelloBoards();
//
//        //Then
//        assertEquals(1, trelloBoardDtos.size());
//        assertEquals("Kodilla Application", trelloBoardDtos.get(0).getName());
}