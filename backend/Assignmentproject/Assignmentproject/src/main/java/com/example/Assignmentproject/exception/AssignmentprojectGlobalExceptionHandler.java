package com.example.Assignmentproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class AssignmentprojectGlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AssignmentprojectResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(AssignmentprojectResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({org.springframework.dao.DataAccessResourceFailureException.class, com.mongodb.MongoTimeoutException.class})
    public ResponseEntity<String> handleDataAccessErrors(Exception ex) {
        // Provide a user-friendly message while hiding internal details
        return new ResponseEntity<>("Database unavailable. Please try again later.", HttpStatus.SERVICE_UNAVAILABLE);
    }
}
