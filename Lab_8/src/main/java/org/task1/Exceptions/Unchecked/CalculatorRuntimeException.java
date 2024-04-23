package org.task1.Exceptions.Unchecked;

public abstract class CalculatorRuntimeException extends RuntimeException{
    public CalculatorRuntimeException() {
    }

    public CalculatorRuntimeException(String message) {
        super(message);
    }

    public CalculatorRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalculatorRuntimeException(Throwable cause) {
        super(cause);
    }

    public CalculatorRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
