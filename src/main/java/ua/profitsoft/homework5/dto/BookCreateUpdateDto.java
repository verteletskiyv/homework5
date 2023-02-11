package ua.profitsoft.homework5.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class BookCreateUpdateDto {
    @Size(min = 1, max = 100, message = "Title should be between 1 and 100 characters")
    @NotEmpty
    private String title;

    @Size(min = 1, max = 100, message = "Author's name should be between 1 and 100 characters")
    @NotEmpty
    private String author;

    @Pattern(regexp = "\\b(Fantasy|Horror|Thriller|Poetry|Drama|Historical|Romance|Western|Biography)\\b",
            message = "Unknown genre. Candidates are: Fantasy, Horror, Thriller, Poetry, Drama, Historical, Romance, Western, Biography")
    @NotEmpty
    private String genre;

    @Max(value = 2023, message = "Year written should be earlier than 2023")
    @Min(value = 0, message = "Year written should be after 0")
    private Integer yearWritten;
}
