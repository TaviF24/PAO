package task2;


import task2.Exceptions.Unchecked.InvalidArgumentsLengthException;
import task2.Exceptions.Checked.UnknownOperandTypeException;

import java.util.*;

public class InputConverter {

    private static final String[] booleanValues = {
            "true", "false", "True", "False", "TRUE", "FALSE"
    };

    private static boolean isInt(String s){
        try{
            Integer.parseInt(s);
        }catch (NumberFormatException err) {
            return false;
        }
        return true;
    }

    private static boolean isBoolean(String s){
        return Arrays.asList(booleanValues).contains(s);
    }



    public static List<CalculatorRequest> mapRequests(String[] args) throws UnknownOperandTypeException{
        List<CalculatorRequest> l = new ArrayList<CalculatorRequest>();
        if(args.length % 3 !=0)
            throw new InvalidArgumentsLengthException(args);

        for(int i=0;i<args.length;i+=3) {
            try {
                if (isBoolean(args[i]) && isBoolean(args[i + 2])) {
                    boolean b1 = Boolean.parseBoolean(args[i]);
                    boolean b2 = Boolean.parseBoolean(args[i + 2]);
                    l.add(new CalculatorRequest(b1, b2, args[i + 1]));
                } else {
                    if (isInt(args[i]) && isInt(args[i + 2]) && !args[i + 1].equals("/")) {
                        int i1 = Integer.parseInt(args[i]);
                        int i2 = Integer.parseInt(args[i + 2]);
                        l.add(new CalculatorRequest(i1, i2, args[i + 1]));
                    } else {
                        if ((!Character.isDigit(args[i].charAt(0)) && args[i].charAt(0) != '-' ) ||
                                (!Character.isDigit(args[i+2].charAt(0)) && args[i+2].charAt(0) != '-' )) {
                            String op = args[i] + " " + args[i + 1] + " " + args[i + 2];
                            throw new UnknownOperandTypeException(op);
                        } else {
                            try{
                                double d1 = Double.parseDouble(args[i]);
                                double d2 = Double.parseDouble(args[i + 2]);
                                l.add(new CalculatorRequest(d1, d2, args[i + 1]));
                            }catch (RuntimeException e){
                                throw new UnknownOperandTypeException(e.toString());
                            }
                        }
                    }
                }
            } catch (UnknownOperandTypeException e) {
                System.err.println(e.getMessage());
            }
        }
        return l;
    }
}
