package lab2.task8;

public class DoubleCalculatorResult extends CalculatorResult{
    DoubleCalculatorResult(CalculatorRequest calculatorRequest){
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
