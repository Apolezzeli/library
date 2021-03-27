package ar.com.ada.second.library.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.Year;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class BookDto implements Serializable {

    private Long id;

    @NotBlank(message = "Is required")
    @Pattern(regexp = "^[0-9a-zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "Book´s title contains invalid characters")
    private String title;

    @NotBlank(message = "Is required")
    @Pattern(regexp = "^[zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "Book´s editorial name contains invalid characters")
    private String editorial;

    @NotBlank(message = "Is required")
    @Pattern(regexp = "^[zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "Book´s last edition place contains invalid characters")
    private String editionPlace;

    @JsonFormat(pattern = "yyyy")
    @NotNull(message = "Is required")
    @PastOrPresent(message = "the year must be past or present")
    private Year editionYear;

    @NotBlank(message = "Is required")
    @Pattern(regexp = "^[0-9\\s]*$", message = "Book´s copies contains invalid characters")
    private Integer libraryCopies;

    @NotBlank(message = "Is required")
    @Pattern(regexp = "^[zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "Book´s condition contains invalid characters")
    private String bookCondition;

    public Boolean hasNullOrEmptyAttributes() {
        return title == null || title.trim().isEmpty()
                ||editorial == null || editorial.trim().isEmpty()
                ||editionPlace == null || editionPlace.trim().isEmpty()
                || editionYear == null
                || libraryCopies == null
                || bookCondition == null || bookCondition.trim().isEmpty();

    }
}
