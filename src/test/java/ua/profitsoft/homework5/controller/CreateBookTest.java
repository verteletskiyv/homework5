package ua.profitsoft.homework5.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import ua.profitsoft.homework5.controller.utils.TestsHelper;
import ua.profitsoft.homework5.dto.RestResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ua.profitsoft.homework5.controller.utils.JsonParser.parseResponse;

@SpringBootTest
public class CreateBookTest extends AbstractTest {
    @Test
    public void createBookEmptyBodyTest() throws Exception {
        mockMvc.perform(post("/api/books/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createBookEmptyTitleTest() throws Exception {
        mockMvc.perform(post("/api/books/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.EMPTY_TITLE_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createBookEmptyAuthorTest() throws Exception {
        mockMvc.perform(post("/api/books/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.EMPTY_AUTHOR_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createBookYearTooBigTest() throws Exception {
        mockMvc.perform(post("/api/books/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.YEAR_TOO_BIG_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createBookYearNegativeTest() throws Exception {
        mockMvc.perform(post("/api/books/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.YEAR_NEGATIVE_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createBookInvalidGenreTest() throws Exception {
        mockMvc.perform(post("/api/books/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.INVALID_GENRE_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createBookTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/api/books/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.NORMAL_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        RestResponse response = parseResponse(mvcResult);
        assertEquals("Created a new book with id 62", response.getResult());
    }
}
