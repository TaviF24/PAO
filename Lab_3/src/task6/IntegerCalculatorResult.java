package task6;

public final class IntegerCalculatorResult extends CalculatorResult{
    IntegerCalculatorResult(final CalculatorRequest calculatorRequest){
        super(calculatorRequest);
    }

    public Object computeResult(){
        CalculatorRequest request = getRequest();
        Integer left = (Integer) request.getLeftOperand();
        Integer right = (Integer) request.getRightOperand();
        String operation = request.getOperation();

        return switch (operation){
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            default -> "Unexpected value";
        };
    }
}
