package task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        double scalar = 3;
        int total = 0;
        Scanner input = new Scanner(System.in);

        FunctionInterface f1 = (Double nr) -> nr*scalar;
        FunctionInterface f2 = (Double nr) -> nr+1;
        FunctionInterface f3 = (Double nr) -> 1/nr;
        FunctionInterface f4 = (Double nr) -> nr*nr;
        FunctionInterface f5 = (Double nr) -> Math.sin(nr);

        List<FunctionInterface> functionsList = new ArrayList<>(){
            {
                add(f1);
                add(f2);
                add(f3);
                add(f4);
                add(f5);
            }};

        try {
            System.out.print("Number of elements = ");
            total = input.nextInt();
        }
        catch (RuntimeException e){
            System.err.println("Oops, that is not an integer");
        }

        List<Double> numbers = new ArrayList<>();
        for(int i=0; i<total; i++){
            try{
                numbers.add(input.nextDouble());
            }catch (RuntimeException e){
                System.out.println("Oops, that is not a number");
                input.next();
            }
        }

        numbers.stream()
                .map(nr ->functionsList.get(new Random().nextInt(functionsList.size())).fun(nr))
                .forEach(nr -> System.out.println(nr));

    }
}
