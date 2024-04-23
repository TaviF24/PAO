package org.task1.CalculatorResult;

import org.task1.CalculatorRequest;
import org.task1.Exceptions.Checked.InvalidOperationException;

public final class DoubleCalculatorResult extends CalculatorResult {
    public DoubleCalculatorResult(final CalculatorRequest calculatorRequest){
        super(calculatorRequest);
    }

    public Object computeResult() throws InvalidOperationException {
        CalculatorRequest request = getRequest();
        Double left = (Double) request.getLeftOperand();
        Double right = (Double) request.getRightOperand();
        String operation = request.getOperation();

        int flag = 0;
        if(right == 0.0)
            flag = 1;

        return switch (operation){
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            case "/" ->
                    switch (flag){
                        case 0 -> left/right;
                        default -> throw new InvalidOperationException("Division by zero", request);
                    };
            default -> throw new InvalidOperationException(request);
        };
    }
}
