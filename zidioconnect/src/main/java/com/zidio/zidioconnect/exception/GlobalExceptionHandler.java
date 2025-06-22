package com.zidio.zidioconnect.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

  /*  @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }*/
	
	 @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handleOthers(Exception ex) {
	        return new ResponseEntity<>("Internal Server Error: " + ex.getMessage(),
	                HttpStatus.INTERNAL_SERVER_ERROR);
	        
	    }
	    
	    
	    
	    static class ErrorResponse {
	        private String message;
	        private LocalDateTime timestamp;

	        ErrorResponse(String message, LocalDateTime timestamp) {
	            this.message = message;
	            this.timestamp = timestamp;
	        }

	        // getters
	        public String getMessage() { return message; }
	        public LocalDateTime getTimestamp() {
	        	return timestamp;
	        	}
	        }
	    
	    
	    
	    
	    
	    
	    
	    
}