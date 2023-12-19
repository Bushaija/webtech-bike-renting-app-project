package com.robert.kigaliBikes.exception;

public class BikeNotFoundException extends RuntimeException {

    public BikeNotFoundException(String message) {
        super(message);
    }

    public BikeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
