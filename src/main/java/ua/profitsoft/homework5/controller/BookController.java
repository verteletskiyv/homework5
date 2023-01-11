package ua.profitsoft.hw5.controller;

import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.validation.BindingResult;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import ua.profitsoft.hw5.dto.BookDto;
import ua.profitsoft.hw5.dto.AuthorGenreQueryDto;
import ua.profitsoft.hw5.dto.RestResponse;
import ua.profitsoft.hw5.service.BookService;
import static ua.profitsoft.hw5.controller.GlobalExceptionHandler.returnErrorsToClient;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public BookDto getBook(@PathVariable long id) {
        return bookService.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestResponse addBook(@Valid @RequestBody BookDto bookDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            returnErrorsToClient(bindingResult);

        long createdId = bookService.create(bookDto);
        return new RestResponse("Created a new book with id %d".formatted(createdId));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RestResponse updateBook(@PathVariable long id, @Valid @RequestBody BookDto dto,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            returnErrorsToClient(bindingResult);

        bookService.update(id, dto);
        return new RestResponse("Book with id %d was successfully updated".formatted(id));
    }

    @PostMapping("_search")
    public List<BookDto> search(@Valid @RequestBody AuthorGenreQueryDto query, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            returnErrorsToClient(bindingResult);

        return bookService.search(query);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RestResponse deleteBook(@PathVariable long id) {
        bookService.delete(id);
        return new RestResponse("Book with id %d is deleted".formatted(id));
    }
}
