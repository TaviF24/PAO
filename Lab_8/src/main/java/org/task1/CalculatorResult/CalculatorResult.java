package org.task1.CalculatorResult;

import org.task1.CalculatorRequest;
import org.task1.Exceptions.Checked.InvalidOperationException;

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
