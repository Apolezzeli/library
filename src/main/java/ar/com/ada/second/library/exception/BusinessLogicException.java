package ar.com.ada.second.library.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Setter
@Getter
public class BusinessLogicException extends RuntimeException {

    private String message;
    private HttpStatus httpStatus;
    private List<EntityError> entityErrors = new ArrayList<>();

    public BusinessLogicException(String message, HttpStatus httpStatus, ar.com.ada.second.library.exception.EntityError entityError) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.entityErrors.add(entityError);
    }
}