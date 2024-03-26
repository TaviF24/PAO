package task2.Exceptions.Checked;

import task2.CalculatorRequest;
import task2.Exceptions.Checked.CalculatorException;

public class InvalidOperationException extends CalculatorException {
    public InvalidOperationException(CalculatorRequest request) {
        super("Invalid operator for operation of type "+request.getRequestType()+": " + request);
    }

    public InvalidOperationException(String message, CalculatorRequest request) {
        super("Arithmetic error for operation "+ request +" : "+ message);
    }
}
