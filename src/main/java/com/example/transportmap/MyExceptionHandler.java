package com.example.transportmap;

import lombok.Data;
import org.hibernate.PersistentObjectException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityExistsException;
import java.util.Optional;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleEntityExistException(EntityExistsException e) {
        ErrorMessage errorMessage = new ErrorMessage(01, e.getMessage());
        return ResponseEntity.of(Optional.of(errorMessage));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> persistentObjectException(PersistentObjectException e) {
        ErrorMessage errorMessage = new ErrorMessage(02, e.getMessage());
        return ResponseEntity.of(Optional.of(errorMessage));
    }
}

@Data
class ErrorMessage {
    private final int code;
    private final String message;
}
