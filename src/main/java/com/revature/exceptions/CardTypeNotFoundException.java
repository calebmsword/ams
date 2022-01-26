package com.revature.exceptions;

public class CardTypeNotFoundException extends Exception {
    public CardTypeNotFoundException() {
    }

    public CardTypeNotFoundException(String message) {
        super(message);
    }

    public CardTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CardTypeNotFoundException(Throwable cause) {
        super(cause);
    }
}
