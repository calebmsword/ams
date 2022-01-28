package com.revature.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = RoleNotFoundException.class)
    public ResponseEntity<ErrorMessage> RoleExceptionHandler(RoleNotFoundException roleNotFoundException) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String message = roleNotFoundException.getMessage();
        ErrorMessage errorMessage = new ErrorMessage(status, message);
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> UserExceptionHandler(UserNotFoundException userNotFoundException) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String message = userNotFoundException.getMessage();
        ErrorMessage errorMessage = new ErrorMessage(status, message);
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = CustomerNotFoundException.class)
    public ResponseEntity<ErrorMessage> UserExceptionHandler(CustomerNotFoundException customerNotFoundException) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String message = customerNotFoundException.getMessage();
        ErrorMessage errorMessage = new ErrorMessage(status, message);
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = TransactionNotFoundException.class)
    public ResponseEntity<ErrorMessage> UserExceptionHandler(TransactionNotFoundException transactionNotFoundException) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String message = transactionNotFoundException.getMessage();
        ErrorMessage errorMessage = new ErrorMessage(status, message);
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BankAccountNotFoundException.class)
    public ResponseEntity<ErrorMessage> UserExceptionHandler(BankAccountNotFoundException bankAccountNotFoundException) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String message = bankAccountNotFoundException.getMessage();
        ErrorMessage errorMessage = new ErrorMessage(status, message);
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = TransactionTypeNotFoundException.class)
    public ResponseEntity<ErrorMessage> UserExceptionHandler(TransactionTypeNotFoundException transactionTypeNotFoundException) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String message = transactionTypeNotFoundException.getMessage();
        ErrorMessage errorMessage = new ErrorMessage(status, message);
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = CardTypeNotFoundException.class)
    public ResponseEntity<ErrorMessage> UserExceptionHandler(CardTypeNotFoundException cardTypeNotFoundException) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String message = cardTypeNotFoundException.getMessage();
        ErrorMessage errorMessage = new ErrorMessage(status, message);
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = AddressNotFoundException.class)
    public ResponseEntity<ErrorMessage> UserExceptionHandler(AddressNotFoundException addressNotFoundException) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String message = addressNotFoundException.getMessage();
        ErrorMessage errorMessage = new ErrorMessage(status, message);
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
