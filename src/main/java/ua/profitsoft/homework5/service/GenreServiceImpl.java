package ua.profitsoft.hw5.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.profitsoft.hw5.dto.GenreDto;
import ua.profitsoft.hw5.repo.GenreRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    public List<GenreDto> getAll() {
        return genreRepository.findAll().stream()
                .map(genre -> GenreDto.builder()
                        .name(genre.getName())
                        .books(genre.getBooks().stream()
                                .map(b -> b.getTitle() + ", " + b.getYearWritten())
                                .toList()).build())
                .toList();
    }
}
