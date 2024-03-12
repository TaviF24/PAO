package lab2.task8;

public abstract class CalculatorResult {

    private CalculatorRequest calculatorRequest;
    protected CalculatorResult(CalculatorRequest calculatorRequest){
        this.calculatorRequest = calculatorRequest;
    }
    public CalculatorRequest getRequest(){
        return calculatorRequest;
    }

    public abstract Object computeResult();

}
