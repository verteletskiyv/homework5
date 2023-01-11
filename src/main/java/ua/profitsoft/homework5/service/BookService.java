package ua.profitsoft.hw5.service;

import ua.profitsoft.hw5.dto.BookDto;
import ua.profitsoft.hw5.dto.AuthorGenreQueryDto;
import java.util.List;

public interface BookService {
    BookDto getOne(long id);

    List<BookDto> getAll();

    long create(BookDto bookDto);

    void update(long id, BookDto dto);

    List<BookDto> search(AuthorGenreQueryDto query);

    void delete(long id);
}
