package task2;

import task2.CalculatorResult.CalculatorResult;
import task2.Exceptions.Checked.InvalidOperationException;

import java.util.List;

public final class Printer {
    public void printOperations(List<CalculatorResult> calculationResults){
        for (CalculatorResult result : calculationResults) {
            try {
                CalculatorRequest request = result.getRequest();
                System.out.println("Operation " + request + " has result " + result.computeResult());
            }
            catch (InvalidOperationException e){
                System.err.println(e.getMessage());
            }
        }
    }
}
