package org.task1;

import org.task1.CalculatorResult.CalculatorResult;
import org.task1.Exceptions.Checked.InvalidOperationException;

import java.util.ArrayList;
import java.util.List;

public final class Printer {
    public  List<List<String>> printOperations(List<CalculatorResult> calculationResults){

        List<List<String>>operations = new ArrayList<>();

        for (CalculatorResult result : calculationResults) {
            try {
                CalculatorRequest request = result.getRequest();
                Object operationResult = result.computeResult();
                System.out.println("Operation " + request + " has result " + operationResult + " " + request.getRequestType());

                operations.add(new ArrayList<>(){{
                    add(request.getRequestType());
                    add(""+request.getLeftOperand());
                    add(""+request.getRightOperand());
                    add(request.getOperation());
                    add(""+operationResult);
                }});
            }
            catch (InvalidOperationException e){
                System.err.println(e.getMessage());
            }
        }
        return operations;
    }
}
