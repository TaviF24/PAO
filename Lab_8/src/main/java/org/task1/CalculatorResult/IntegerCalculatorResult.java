package org.task1.CalculatorResult;

import org.task1.CalculatorRequest;
import org.task1.Exceptions.Checked.InvalidOperationException;

public final class IntegerCalculatorResult extends CalculatorResult {
    public IntegerCalculatorResult(final CalculatorRequest calculatorRequest){
        super(calculatorRequest);
    }

    public Object computeResult() throws InvalidOperationException {
        CalculatorRequest request = getRequest();
        Integer left = (Integer) request.getLeftOperand();
        Integer right = (Integer) request.getRightOperand();
        String operation = request.getOperation();

        return switch (operation){
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            default -> throw new InvalidOperationException(request);
        };
    }
}
