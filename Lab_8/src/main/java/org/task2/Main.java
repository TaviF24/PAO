package org.task2;

import org.task2.calculatorResult.PrintingCalculationResult;

public class Main {
    public static void main(String[] args) {
        args = new String[]{
                "1", "+", "2",
                "2", "*", "5",
                "1", "+", "5.0",
                "1.0", "-", "2",
                "10.0", "/", "1",
        };

        String path = "jdbc:mysql://localhost:3306/laborator";
        String user = "root";
        String pwd = "parola123";

        DBWrapper dbWrapper = new DBWrapper(path, user, pwd);
        String[] args2 = dbWrapper.printFromDB();


        /*----------------------------------TASK 2----------------------------------*/
        System.out.println("\n----------------------TASK 2----------------------");
        System.out.println("\nAfter creating the objects:\n");
        runSmarterCalculator(args2);


        /*----------------------------------TASK 3----------------------------------*/
        System.out.println("\n----------------------TASK 3----------------------");
        dbWrapper.deleteAfterType("IntegER");
        dbWrapper.printFromDB();

        /*----------------------------------TASK 4----------------------------------*/
        System.out.println("\n----------------------TASK 4----------------------");
        dbWrapper.deleteDuplicates();
        dbWrapper.printFromDB();

    }

    private static void runSmarterCalculator(String[] args) {
        SmarterCalculator
                .calculate(args)
                .stream()
                .map(PrintingCalculationResult::new)
                .forEach(PrintingCalculationResult::computeResult);
    }
}
