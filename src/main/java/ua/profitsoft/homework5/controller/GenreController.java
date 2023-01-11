package ua.profitsoft.hw5.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.profitsoft.hw5.dto.GenreDto;
import ua.profitsoft.hw5.service.GenreService;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/genres")
public class GenreController {
    private final GenreService genreService;

    @GetMapping
    public List<GenreDto> getGenres() {
        return genreService.getAll();
    }
}
