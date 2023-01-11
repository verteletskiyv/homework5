package ua.profitsoft.hw5.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.profitsoft.hw5.model.Book;
import ua.profitsoft.hw5.model.Genre;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByAuthorLikeAndGenreOrderById(String author, Genre genre, Pageable pageable);
}
