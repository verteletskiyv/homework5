package ua.profitsoft.homework5.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MvcResult;
import ua.profitsoft.homework5.dto.BookDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ua.profitsoft.homework5.controller.utils.JsonParser.parseBookResponse;

@SpringBootTest
public class GetBookTest extends AbstractTest {
    @Test
    public void getBookByIdEqualZeroTest() throws Exception {
        mockMvc.perform(get("/api/books/0"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getBookByIdNotNumberTest() throws Exception {
        mockMvc.perform(get("/api/books/test"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getBookByIdNotExistTest() throws Exception {
        mockMvc.perform(get("/api/books/410"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getBookByIdTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/books/14"))
                .andExpect(status().isOk())
                .andReturn();
        BookDto response = parseBookResponse(mvcResult);
        assertEquals("In Cold Blood", response.getTitle());
    }

}
