package Exceptions;

public class NameAlreadyAddedException extends RuntimeException{
    public NameAlreadyAddedException() {
        super("Instances cannot be redeclared");
    }
}
