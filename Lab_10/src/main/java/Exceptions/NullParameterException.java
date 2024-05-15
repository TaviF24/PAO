package Exceptions;

public class NullParameterException extends RuntimeException{
    public NullParameterException() {
        super("Null is not allowed as a parameter");
    }
}
