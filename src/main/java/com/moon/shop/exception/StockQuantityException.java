package com.moon.shop.exception;

public class StockQuantityException extends RuntimeException{
    public StockQuantityException() {
    }

    public StockQuantityException(String message) {
        super(message);
    }

    public StockQuantityException(String message, Throwable cause) {
        super(message, cause);
    }

    public StockQuantityException(Throwable cause) {
        super(cause);
    }

    public StockQuantityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
