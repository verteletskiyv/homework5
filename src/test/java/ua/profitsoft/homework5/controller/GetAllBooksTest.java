package ua.profitsoft.hw5.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ua.profitsoft.hw5.controller.utils.JsonParser.parseBookArrayResponse;

@SpringBootTest
public class GetAllBooksTest extends AbstractTest {
    @Test
    public void getAllBooks() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/books/"))
                .andExpect(status().isOk())
                .andReturn();
        Assertions.assertFalse(parseBookArrayResponse(mvcResult).isEmpty());
        Assertions.assertEquals(61, parseBookArrayResponse(mvcResult).size());
    }

}
