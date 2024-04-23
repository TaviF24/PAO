package org.task1.Exceptions.Checked;

import org.task1.Exceptions.Checked.CalculatorException;

public class UnknownOperandTypeException extends CalculatorException {
    public UnknownOperandTypeException(String operation) {
       super("Unknown operand type for operation: " + operation);
    }
}
