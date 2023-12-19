package com.robert.kigaliBikes.exception;

public class StationNotFoundException extends RuntimeException {

    public StationNotFoundException(String message) {
        super(message);
    }

    public StationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
