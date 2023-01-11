package ua.profitsoft.homework5.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.profitsoft.homework5.dto.BookDto;
import ua.profitsoft.homework5.dto.AuthorGenreQueryDto;
import ua.profitsoft.homework5.model.Book;
import ua.profitsoft.homework5.repo.BookRepository;
import ua.profitsoft.homework5.repo.GenreRepository;
import ua.profitsoft.homework5.exceptions.BookNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;
    private final ModelMapper modelMapper;

    public BookDto getOne(long id) {
        return convertToBookDto(bookRepository.findById(id).orElseThrow(BookNotFoundException::new));
    }

    public List<BookDto> getAll() {
        return bookRepository.findAll().stream()
                .map(this::convertToBookDto)
                .toList();
    }

    @Transactional
    public long create(BookDto bookDto) {
        Book book = bookRepository.saveAndFlush(convertToBook(bookDto));
        return book.getId();
    }

    @Transactional
    public void update(long id, BookDto dto) {
        Book book = bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setYearWritten(dto.getYearWritten());
        book.setGenre(genreRepository.findGenreByName(dto.getGenre()));
        bookRepository.saveAndFlush(book);
    }

    public List<BookDto> search(AuthorGenreQueryDto query) {
        List<Book> allByAuthorAndGenre = bookRepository.findAllByAuthorLikeAndGenreOrderById(
                query.getAuthor(),
                genreRepository.findGenreByName(query.getGenre()),
                PageRequest.of(query.getPageNumber(), query.getPageSize()));
        if (allByAuthorAndGenre.isEmpty())
            throw new BookNotFoundException();

        return allByAuthorAndGenre.stream().map(this::convertToBookDto).toList();
    }

    @Transactional
    public void delete(long id) {
        Book book = bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        bookRepository.delete(book);
        bookRepository.flush();
    }


    private BookDto convertToBookDto(Book book) {
        BookDto dto = modelMapper.map(book, BookDto.class);
        if (book.getGenre() != null)
            dto.setGenre(book.getGenre().getName());
        return dto;
    }

    private Book convertToBook(BookDto dto) {
        Book book = modelMapper.map(dto, Book.class);
        book.setGenre(genreRepository.findGenreByName(dto.getGenre()));
        return book;
    }
}