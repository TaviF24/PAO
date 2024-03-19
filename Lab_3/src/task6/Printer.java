package task6;

import task6.CalculatorResult.CalculatorResult;

import java.util.List;

public final class Printer {
    public void printOperations(List<CalculatorResult> calculationResults){
        for (CalculatorResult result : calculationResults) {
            CalculatorRequest request = result.getRequest();
            System.out.println("Operation " + request + " has result " + result.computeResult());
        }
    }
}
