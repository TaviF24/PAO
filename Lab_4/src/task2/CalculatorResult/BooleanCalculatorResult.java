package task2.CalculatorResult;

import task2.CalculatorRequest;
import task2.Exceptions.Checked.InvalidOperationException;

public final class BooleanCalculatorResult extends CalculatorResult {
    public BooleanCalculatorResult(final CalculatorRequest calculatorRequest){
        super(calculatorRequest);
    }

    public Object computeResult() throws InvalidOperationException {
        CalculatorRequest request = getRequest();
        Boolean left = (Boolean) request.getLeftOperand();
        Boolean right = (Boolean) request.getRightOperand();
        String operation = request.getOperation();

        return switch (operation){
            case "|" -> left||right;
            case "&" -> left&&right;
            default -> throw new InvalidOperationException(request);
        };
    }
}
