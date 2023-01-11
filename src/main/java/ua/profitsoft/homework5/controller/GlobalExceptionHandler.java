package ua.profitsoft.hw5.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ua.profitsoft.hw5.exceptions.ValidationException;
import ua.profitsoft.hw5.exceptions.BookNotFoundException;
import ua.profitsoft.hw5.dto.RestResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    static void returnErrorsToClient(BindingResult bindingResult) {
        StringBuilder errorMessage = new StringBuilder();
        bindingResult.getFieldErrors().forEach(e -> errorMessage
                .append(e.getField())
                .append(" - ")
                .append(e.getDefaultMessage() == null ? e.getCode() : e.getDefaultMessage())
                .append("; "));

        throw new ValidationException(errorMessage.toString());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private RestResponse handleException(BookNotFoundException ignoredE) {
        return new RestResponse("Found no books to match provided parameters");
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private RestResponse handleException(ValidationException e) {
        return new RestResponse(e.getMessage());
    }
}
