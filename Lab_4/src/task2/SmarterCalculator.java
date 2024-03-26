package task2;

import task2.CalculatorResult.BooleanCalculatorResult;
import task2.CalculatorResult.CalculatorResult;
import task2.CalculatorResult.DoubleCalculatorResult;
import task2.CalculatorResult.IntegerCalculatorResult;
import task2.Exceptions.Checked.UnknownOperandTypeException;

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

    public void CalculateAndShowResults(String[] args){
        List<CalculatorResult> calculationResults = calculate(args);
        printer.printOperations(calculationResults);
    }

}
