package org.task2.calculatorResult;

import org.task2.CalculationRequest;

public interface CalculationResult {
    Object computeResult();
    CalculationRequest getRequest();
}
