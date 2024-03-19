package task6.CalculatorResult;

import task6.CalculatorRequest;

public final class BooleanCalculatorResult extends CalculatorResult {
    public BooleanCalculatorResult(final CalculatorRequest calculatorRequest){
        super(calculatorRequest);
    }

    public Object computeResult(){
        CalculatorRequest request = getRequest();
        Boolean left = (Boolean) request.getLeftOperand();
        Boolean right = (Boolean) request.getRightOperand();
        String operation = request.getOperation();

        return switch (operation){
            case "|" -> left||right;
            case "&" -> left&&right;
            default -> "Unexpected value";
        };
    }
}
