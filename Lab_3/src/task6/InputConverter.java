package task6;


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



    public static List<CalculatorRequest> mapRequests(String[] args){
        List<CalculatorRequest> l = new ArrayList<CalculatorRequest>();
        try{
            for(int i=0;i<args.length;i+=3){
                if (isBoolean(args[i]) && isBoolean(args[i+2])){
                    boolean b1 = Boolean.parseBoolean(args[i]);
                    boolean b2 = Boolean.parseBoolean(args[i+2]);
                    l.add(new CalculatorRequest(b1,b2,args[i+1]));
                }
                else{
                    if(isInt(args[i]) && isInt(args[i+2]) && !args[i+1].equals("/")) {
                        int i1 = Integer.parseInt(args[i]);
                        int i2 = Integer.parseInt(args[i+2]);
                        l.add(new CalculatorRequest(i1,i2,args[i+1]));
                    }
                    else{
                        double d1 = Double.parseDouble(args[i]);
                        double d2 = Double.parseDouble(args[i+2]);
                        l.add(new CalculatorRequest(d1,d2,args[i+1]));
                    }
                }
            }
        } catch (Exception e){
            System.out.println("Error found");
        }

        return l;
    }
}
