package com.nsdev.walletapp.exception;

import com.nsdev.walletapp.util.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WalletNotFoundException.class)
    public ResponseEntity<ResponseStructure<Void>> handleWalletNotFound(WalletNotFoundException ex) {
        ResponseStructure<Void> response = new ResponseStructure<>();
        response.setSuccess(false);
        response.setMessage(ex.getMessage());
        response.setData(null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<ResponseStructure<Void>> handleInsufficientFunds(InsufficientFundsException ex) {
        ResponseStructure<Void> response = new ResponseStructure<>();
        response.setSuccess(false);
        response.setMessage(ex.getMessage());
        response.setData(null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
 
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseStructure<Void>> handleInvalidJson(HttpMessageNotReadableException ex) {
        ResponseStructure<Void> response = new ResponseStructure<>();
        response.setSuccess(false);
        response.setMessage("Invalid JSON format. Please check your request body.");
        response.setData(null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}