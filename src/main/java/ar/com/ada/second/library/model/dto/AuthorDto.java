package ar.com.ada.second.library.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class AuthorDto implements Serializable {

    private Long id;

    @NotBlank(message = "Is required")
    @Pattern(regexp = "^[zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "Author´s name contains invalid characters")
    private String name;

    @NotBlank(message = "Is required")
    @Pattern(regexp = "^[zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "Author´s last name contains invalid characters")
    private String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Is required")
    @PastOrPresent(message = "the year must be past or present")
    private Date birth;

    @NotBlank(message = "Is required")
    @Pattern(regexp = "^[zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "Author´s last birth place contains invalid characters")
    private String birthPlace;

    @NotBlank(message = "Is required")
    @Pattern(regexp = "^[0-9a-zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "Author´s biography contains invalid characters")
    private String biography;

    public Boolean hasNullOrEmptyAttributes() {
        return name == null || name.trim().isEmpty()
                ||lastName == null || lastName.trim().isEmpty()
                || birth == null
                || birthPlace == null || birthPlace.trim().isEmpty()
                || biography == null || biography.trim().isEmpty();

    }









}
