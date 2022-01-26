package com.revature.exceptions;

public class BankAccountNotFoundException extends Exception {
    public BankAccountNotFoundException() {
    }

    public BankAccountNotFoundException(String message) {
        super(message);
    }

    public BankAccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BankAccountNotFoundException(Throwable cause) {
        super(cause);
    }
}
