package org.task1;

import org.task1.CalculatorResult.CalculatorResult;

import java.util.List;

public class Main {
    static public void main(String[] args){

        String[] test1 = {
                "a", "f", "5",
                "1", "+", "2",
                "2", "*", "5",
                "1", "+", "5.0",
                "1.0", "-", "2",
                "10.0", "/", "1",
                "True", "|", "False",
                "True", "+", "False",
                "-3", "-", "True",
                "a", "f", "6"
        };

        String[] test2 = {
                "a", "+", "5"
        };

        String[] test3 = {
                "a", "f"
        };

        String[] test4 = {
                "1", "+", "5", "5"
        };

        String[] test5 = {
                "1", "+", "2",
                "2", "*", "5",
                "1", "+", "5.0",
                "1.0", "-", "2",
                "10.0", "/", "1",
        };

        try {
            SmarterCalculator smarterCalculator = new SmarterCalculator();
            List<List<String>> operations =  smarterCalculator.CalculateAndShowResults(test5);

            String path = "jdbc:mysql://localhost:3306/laborator";
            String user = "root";
            String pwd = "parola123";

            DBWrapper dbWrapper = new DBWrapper(path, user, pwd);
            dbWrapper.createTable();
            dbWrapper.insertIntoDB(operations);
            dbWrapper.printFromDB();

        }
        catch (RuntimeException e){
            System.err.println(e.getMessage());
        }

    }
}
