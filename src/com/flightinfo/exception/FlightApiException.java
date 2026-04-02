package com.flightinfo.exception;

public class FlightApiException extends RuntimeException {
    public FlightApiException(String message)
    {
        super(message);
    }

    public FlightApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
