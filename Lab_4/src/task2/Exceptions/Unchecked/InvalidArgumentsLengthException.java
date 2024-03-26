package task2.Exceptions.Unchecked;

import task2.Exceptions.Unchecked.CalculatorRuntimeException;

public class InvalidArgumentsLengthException extends CalculatorRuntimeException {
    public InvalidArgumentsLengthException(String[] args){
        super("Invalid number of parameters");
    }
}
