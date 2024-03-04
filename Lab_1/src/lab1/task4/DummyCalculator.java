package lab1.task4;

public class DummyCalculator {

    private boolean isInt(String s){
        try{
            Integer.parseInt(s);
        }catch (NumberFormatException err) {
            return false;
        }
        return true;
    }

    private void print(String [] args){
        if(isInt(args[0])) {
            int i1 = Integer.parseInt(args[0]);
            if (isInt(args[2]))
                System.out.println(switch (args[1]){
                    case "+" -> i1 + Integer.parseInt(args[2]);
                    case "-" -> i1 - Integer.parseInt(args[2]);
                    case "*" -> i1 * Integer.parseInt(args[2]);
                    case "/" -> (i1*1.0) / Integer.parseInt(args[2]);
                    default -> "";
                });
            else
                System.out.println(switch (args[1]){
                    case "+" -> i1 + Double.parseDouble(args[2]);
                    case "-" -> i1 - Double.parseDouble(args[2]);
                    case "*" -> i1 * Double.parseDouble(args[2]);
                    case "/" -> i1 / Double.parseDouble(args[2]);
                    default -> "";
                });
        }
        else {
            double d1 = Double.parseDouble(args[0]);
            if (isInt(args[2]))
                System.out.println(switch (args[1]){
                    case "+" -> d1 + Integer.parseInt(args[2]);
                    case "-" -> d1 - Integer.parseInt(args[2]);
                    case "*" -> d1 * Integer.parseInt(args[2]);
                    case "/" -> d1 / Integer.parseInt(args[2]);
                    default -> "";
                });
            else
                System.out.println(switch (args[1]){
                    case "+" -> d1 + Double.parseDouble(args[2]);
                    case "-" -> d1 - Double.parseDouble(args[2]);
                    case "*" -> d1 * Double.parseDouble(args[2]);
                    case "/" -> d1 / Double.parseDouble(args[2]);
                    default -> "";
                });

        }
    }

    public void calculate(String[] args){

        if (Character.isAlphabetic(args[0].charAt(0))){
            boolean b1 = Boolean.parseBoolean(args[0]);
            boolean b2 = Boolean.parseBoolean(args[2]);
            System.out.println(switch (args[1]){
                case "|" -> b1||b2;
                case "&" -> b1&&b2;
                default -> "";
            });
        }else
            print(args);
    }
}
