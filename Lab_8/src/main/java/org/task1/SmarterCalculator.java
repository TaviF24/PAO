package org.task1;

import org.task1.CalculatorResult.BooleanCalculatorResult;
import org.task1.CalculatorResult.CalculatorResult;
import org.task1.CalculatorResult.DoubleCalculatorResult;
import org.task1.CalculatorResult.IntegerCalculatorResult;
import org.task1.Exceptions.Checked.UnknownOperandTypeException;

import java.util.ArrayList;
import java.util.List;

public final class SmarterCalculator {

    private final Printer printer = new Printer();
    public static List<CalculatorResult> calculate(String[] args){
        List<CalculatorResult> results = new ArrayList<CalculatorResult>();
        try{
            List<CalculatorRequest> requests =  InputConverter.mapRequests(args);
            for(int i=0;i<requests.size();i++){
                CalculatorRequest currentRequest = requests.get(i);
                switch (currentRequest.getRequestType()){
                    case "Integer" -> results.add(new IntegerCalculatorResult(currentRequest));
                    case "Double" -> results.add(new DoubleCalculatorResult(currentRequest));
                    case "Boolean" -> results.add(new BooleanCalculatorResult(currentRequest));
                }
            }
        }
        catch (UnknownOperandTypeException e){
            System.err.println(e.getMessage());
        }
        return results;
    }

    public List<List<String>> CalculateAndShowResults(String[] args){
        List<CalculatorResult> calculationResults = calculate(args);
        return printer.printOperations(calculationResults);
    }

}
