package task6;

public abstract class CalculatorResult {

    private final CalculatorRequest calculatorRequest;
    protected CalculatorResult(final CalculatorRequest calculatorRequest){
        this.calculatorRequest = calculatorRequest;
    }
    public final CalculatorRequest getRequest(){
        return calculatorRequest;
    }

    public abstract Object computeResult();

}
