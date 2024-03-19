package task6;

import java.util.ArrayList;
import java.util.List;

public final class SmarterCalculator {
    public static List<CalculatorResult> calculate(String[] args){
        List<CalculatorRequest> requests =  InputConverter.mapRequests(args);
        List<CalculatorResult> results = new ArrayList<CalculatorResult>();
        for(int i=0;i<requests.size();i++){
            CalculatorRequest currentRequest = requests.get(i);
            switch (currentRequest.getRequestType()){
                case "Integer" -> results.add(new IntegerCalculatorResult(currentRequest));
                case "Double" -> results.add(new DoubleCalculatorResult(currentRequest));
                case "Boolean" -> results.add(new BooleanCalculatorResult(currentRequest));
            }
        }
        return results;
    }
}
