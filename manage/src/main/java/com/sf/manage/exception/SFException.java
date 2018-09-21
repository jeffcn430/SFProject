package com.sf.manage.exception;

public class SFException extends RuntimeException {
    public SFException() {
        super();
    }

    public SFException(String message) {
        super(message);
    }

    public SFException(String message, Throwable cause) {
        super(message, cause);
    }

    public SFException(Throwable cause) {
        super(cause);
    }
}
