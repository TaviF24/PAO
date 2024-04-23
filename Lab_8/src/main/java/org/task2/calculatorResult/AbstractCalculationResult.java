package org.task2.calculatorResult;

import org.task2.CalculationRequest;

public abstract class AbstractCalculationResult implements CalculationResult {
    private final CalculationRequest request;

    public AbstractCalculationResult(CalculationRequest request) {
        this.request = request;
    }

    @Override
    public CalculationRequest getRequest() {
        return request;
    }
}
