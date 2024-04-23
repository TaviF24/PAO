package org.task1.Exceptions.Unchecked;

import org.task1.Exceptions.Unchecked.CalculatorRuntimeException;

public class InvalidArgumentsLengthException extends CalculatorRuntimeException {
    public InvalidArgumentsLengthException(String[] args){
        super("Invalid number of parameters");
    }
}
