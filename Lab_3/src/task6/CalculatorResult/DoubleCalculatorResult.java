package task6.CalculatorResult;

import task6.CalculatorRequest;

public final class DoubleCalculatorResult extends CalculatorResult {
    public DoubleCalculatorResult(final CalculatorRequest calculatorRequest){
        super(calculatorRequest);
    }

    public Object computeResult(){
        CalculatorRequest request = getRequest();
        Double left = (Double) request.getLeftOperand();
        Double right = (Double) request.getRightOperand();
        String operation = request.getOperation();

        return switch (operation){
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            case "/" -> left / right;
            default -> "Unexpected value";
        };
    }
}
