package task4;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args){

        int n = 10;
        IntStream.range(0,n+1)
                .filter(x->x%2==0)
                .mapToObj(nr -> new RootSquare(nr))
                .forEach(x -> System.out.println(x));

    }
}
