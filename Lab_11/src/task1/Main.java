package task1;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            numbers.add(i);
        }

        /*-----------------------TASK 1-----------------------*/
        ThreadTesting.withFuture(numbers);
        ThreadTesting.withParallelStream(numbers);
        ThreadTesting.withThread(numbers);

//        ThreadTesting.multipleTests();
    }

}
