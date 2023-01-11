package ua.profitsoft.homework5.dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter @Setter
public class AuthorGenreQueryDto {
    @Size(min = 1, max = 100, message = "Author's name should be between 1 and 100 characters")
    private String author;

    @Pattern(regexp = "\\b(Fantasy|Horror|Thriller|Poetry|Drama|Historical|Romance|Western|Biography)\\b",
            message = "Unknown genre. Candidates are: Fantasy, Horror, Thriller, Poetry, Drama, Historical, Romance, Western, Biography")
    private String genre;

    @Min(value = 0, message = "Can't be less than zero")
    private int pageNumber;
    @Min(value = 1, message = "Can't be less than 1")
    private int pageSize;
}
