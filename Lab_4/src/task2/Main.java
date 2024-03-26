package task2;

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

        try {
            SmarterCalculator smarterCalculator = new SmarterCalculator();
            smarterCalculator.CalculateAndShowResults(test1);
        }
        catch (RuntimeException e){
            System.err.println(e.getMessage());
        }
    }
}
