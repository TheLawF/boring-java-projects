package com.github.thelawf.math;

public class TriangleDoNotExistException extends Exception {

    public TriangleDoNotExistException() {
        super();
    }

    public TriangleDoNotExistException(String message) {
        super(message);
    }

    public TriangleDoNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleDoNotExistException(Throwable cause) {
        super(cause);
    }

    public TriangleDoNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
