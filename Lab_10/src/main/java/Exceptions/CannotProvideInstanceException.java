package Exceptions;

public class CannotProvideInstanceException extends RuntimeException{
    public CannotProvideInstanceException() {
        super("Cannot provide instance");
    }
}
