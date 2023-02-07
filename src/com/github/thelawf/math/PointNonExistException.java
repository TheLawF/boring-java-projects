package com.github.thelawf.math;

public class PointNonExistException extends Exception{
    public PointNonExistException() {
    }

    public PointNonExistException(String message) {
        super(message);
    }

    public PointNonExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
