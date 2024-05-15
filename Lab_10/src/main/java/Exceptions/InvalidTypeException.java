package Exceptions;

public class InvalidTypeException extends RuntimeException{
    public InvalidTypeException() {
        super("Invalid type for object");
    }
}
