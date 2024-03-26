package task2.CalculatorResult;

import task2.CalculatorRequest;
import task2.Exceptions.Checked.InvalidOperationException;

public abstract class CalculatorResult {

    private final CalculatorRequest calculatorRequest;
    protected CalculatorResult(final CalculatorRequest calculatorRequest){
        this.calculatorRequest = calculatorRequest;
    }
    public final CalculatorRequest getRequest(){
        return calculatorRequest;
    }

    public abstract Object computeResult() throws InvalidOperationException;

}
