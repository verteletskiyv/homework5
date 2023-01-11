package ua.profitsoft.homework5.controller.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MvcResult;
import ua.profitsoft.homework5.dto.BookDto;
import ua.profitsoft.homework5.dto.RestResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class JsonParser {
    public static RestResponse parseResponse(MvcResult mvcResult) {
        try {
            return new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), RestResponse.class);
        } catch (JsonProcessingException | UnsupportedEncodingException e) {
            throw new RuntimeException("JSON parsing error", e);
        }
    }

    public static List<BookDto> parseBookArrayResponse(MvcResult mvcResult) {
        try {
            return new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<>() {
            });
        } catch (UnsupportedEncodingException | JsonProcessingException e) {
            throw new RuntimeException("JSON parsing error", e);
        }
    }

    public static BookDto parseBookResponse(MvcResult mvcResult) {
        try {
            return new ObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), BookDto.class);
        } catch (UnsupportedEncodingException | JsonProcessingException e) {
            throw new RuntimeException("JSON parsing error", e);
        }
    }
}
