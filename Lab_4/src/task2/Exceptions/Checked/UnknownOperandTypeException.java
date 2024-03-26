package task2.Exceptions.Checked;

import task2.Exceptions.Checked.CalculatorException;

public class UnknownOperandTypeException extends CalculatorException {
    public UnknownOperandTypeException(String operation) {
       super("Unknown operand type for operation: " + operation);
    }
}
