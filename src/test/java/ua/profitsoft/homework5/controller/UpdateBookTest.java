package ua.profitsoft.hw5.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import ua.profitsoft.hw5.controller.utils.TestsHelper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ua.profitsoft.hw5.controller.utils.JsonParser.parseResponse;

@SpringBootTest
public class UpdateBookTest extends AbstractTest {
    @Test
    public void updateBookIdZeroTest() throws Exception {
        mockMvc.perform(put("/api/books/0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.NORMAL_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateBookNotExistTest() throws Exception {
        mockMvc.perform(put("/api/books/415")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.NORMAL_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateBookInvalidTitleTest() throws Exception {
        mockMvc.perform(put("/api/books/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.EMPTY_TITLE_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void updateBookInvalidAuthorTest() throws Exception {
        mockMvc.perform(put("/api/books/5")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.EMPTY_AUTHOR_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void updateBookInvalidGenreTest() throws Exception {
        mockMvc.perform(put("/api/books/3")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.INVALID_GENRE_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void updateBookInvalidYearWrittenTest() throws Exception {
        mockMvc.perform(put("/api/books/10")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.YEAR_TOO_BIG_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void updateBookInvalidYearWritten2Test() throws Exception {
        mockMvc.perform(put("/api/books/10")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestsHelper.YEAR_NEGATIVE_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void updatePlayerEmptyBodyTest() throws Exception {
        mockMvc.perform(put("/api/books/17")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void updateBookTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(put("/api/books/4")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.format(TestsHelper.NORMAL_JSON)))
                .andExpect(status().isOk())
                .andReturn();
        assertEquals("Book with id 4 was successfully updated", parseResponse(mvcResult).getResult());
    }
}
