package ua.profitsoft.homework5.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Builder
@Getter @Setter
public class GenreDto {
    String name;
    List<String> books;
}
