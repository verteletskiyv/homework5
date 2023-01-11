package ua.profitsoft.hw5.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MvcResult;
import ua.profitsoft.hw5.dto.RestResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ua.profitsoft.hw5.controller.utils.JsonParser.parseResponse;

@SpringBootTest
public class DeleteBookTest extends AbstractTest {
    @Test
    public void deleteBookByIdZeroTest() throws Exception {
        mockMvc.perform(delete("/api/books/0"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteBookByIdNotNumberTest() throws Exception {
        mockMvc.perform(delete("/api/books/test"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void deleteBookByIdNotExistTest() throws Exception {
        mockMvc.perform(delete("/api/books/426"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteBookByIdTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(delete("/api/books/1"))
                .andExpect(status().isOk())
                .andReturn();
        RestResponse response = parseResponse(mvcResult);
        assertEquals("Book with id 1 is deleted", response.getResult());

        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isNotFound());
    }
}
