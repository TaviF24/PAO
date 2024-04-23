package org.task1.Exceptions.Checked;

import org.task1.CalculatorRequest;
import org.task1.Exceptions.Checked.CalculatorException;

public class InvalidOperationException extends CalculatorException {
    public InvalidOperationException(CalculatorRequest request) {
        super("Invalid operator for operation of type "+request.getRequestType()+": " + request);
    }

    public InvalidOperationException(String message, CalculatorRequest request) {
        super("Arithmetic error for operation "+ request +" : "+ message);
    }
}
