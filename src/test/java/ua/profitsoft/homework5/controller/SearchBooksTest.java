package ua.profitsoft.homework5.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import ua.profitsoft.homework5.controller.utils.TestsHelper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ua.profitsoft.homework5.controller.utils.JsonParser.parseBookArrayResponse;

@SpringBootTest
public class SearchBooksTest extends AbstractTest {
    @Test
    public void searchWithEmptyAuthorTest() throws Exception {
        mockMvc.perform(post("/api/books/_search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.EMPTY_AUTHOR_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void searchWithEmptyGenreTest() throws Exception {
        mockMvc.perform(post("/api/books/_search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.EMPTY_GENRE_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void searchWithInvalidGenreTest() throws Exception {
        mockMvc.perform(post("/api/books/_search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.INVALID_GENRE_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void searchWithZeroOrNegativePageSizeTest() throws Exception {
        mockMvc.perform(post("/api/books/_search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.ZERO_PAGE_SIZE_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void searchWithNegativePageNumberTest() throws Exception {
        mockMvc.perform(post("/api/books/_search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.NEGATIVE_PAGE_NUMBER_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void search1Test() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/api/books/_search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.SEARCH_1_JSON))
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(3, parseBookArrayResponse(mvcResult).size());
    }

    @Test
    public void search2Test() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/api/books/_search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.SEARCH_2_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(2, parseBookArrayResponse(mvcResult).size());
    }
}
