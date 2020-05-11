package com.assignment.genp.exceptions;

import com.assignment.genp.exceptions.BookNotFoundException;
import com.assignment.genp.exceptions.LibrarayNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/***

 Created by 
 @author dkammara on Sunday - 5/10/2020

 */
@RestControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRunTimeException(RuntimeException e) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Internal server error");
        body.put("status_code", 500);
        return  new ResponseEntity<>(body, INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler({BookNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(BookNotFoundException e) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Book not found");
        body.put("status_code", 404);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({LibrarayNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(LibrarayNotFoundException e) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Library not found");
        body.put("status_code", 404);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

}
