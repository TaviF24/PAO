package task6;

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

        SmarterCalculator smarterCalculator = new SmarterCalculator();
        smarterCalculator.CalculateAndShowResults(a);
    }
}
