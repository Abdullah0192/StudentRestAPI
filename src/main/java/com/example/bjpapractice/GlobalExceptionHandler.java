package com.example.bjpapractice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.Map;
import java.util.HashMap;
import org.springframework.http.ResponseEntity;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationException(MethodArgumentNotValidException ex){
//    public String handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> {
                    errors.put(error.getField(), error.getDefaultMessage());
//                    System.out.println("Field: "+ error.getField());
//                    System.out.println("Message: "+error.getDefaultMessage());
                });
        ValidationErrorResponse response = new ValidationErrorResponse();
    response.setStatus(400);
    response.setMessage("Validation failed");
    response.setErrors(errors);
//    response.setErrors(errors.put(error.getFiled(), error.getDefaultMessage()));
    return ResponseEntity.status(400).body(response);
//        return "Validation failed";        
    }
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ValidationErrorResponse> handleStudentNotFound(StudentNotFoundException ex){
        Map<String, String> errors = new HashMap<>();
        ValidationErrorResponse response = new ValidationErrorResponse();
        response.setStatus(404);
        response.setMessage(ex.getMessage());       
        response.setErrors(errors);
        return ResponseEntity.status(404).body(response);
    }
}
