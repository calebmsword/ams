package com.revature.exceptions;

public class TransactionTypeNotFoundException extends Exception {
    public TransactionTypeNotFoundException() {
    }

    public TransactionTypeNotFoundException(String message) {
        super(message);
    }

    public TransactionTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransactionTypeNotFoundException(Throwable cause) {
        super(cause);
    }
}
