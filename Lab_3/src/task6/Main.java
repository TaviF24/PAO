package task6;

import java.util.*;

public class Main {
    static public void main(String[] args){

        String[] a = {
                "1", "+", "2",
                "2", "*", "5",
                "1", "+", "5.0",
                "1.0", "-", "2",
                "10.0", "/", "1",
                "True", "|", "False",
                "True", "&", "False",
                "3", "/", "3"
        };

        List<CalculatorResult> calculationResults =  SmarterCalculator.calculate(a);

        for (CalculatorResult result : calculationResults) {
            CalculatorRequest request = result.getRequest();
            System.out.println("Operation " + request + " has result " + result.computeResult());
        }
    }
}