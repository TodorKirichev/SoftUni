package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
public class BookImportDto {

    @Expose
    @NotNull
    @Size(min = 3, max = 40)
    private String author;

    @Expose
    @NotNull
    private boolean available;

    @Expose
    @NotNull
    @Size(min = 5)
    private String description;

    @Expose
    @NotNull
    private String genre;

    @Expose
    @NotNull
    @Size(min = 3, max = 40)
    private String title;

    @Expose
    @NotNull
    @Positive
    private Double rating;
}
