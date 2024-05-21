package task1;

import javax.lang.model.type.NullType;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

public class ThreadTesting {


    private static int calculateSquare(int number){
        return number*number;
    }

    private static void printSquare(ArrayList<Integer> list, int startIndex, int endIndex){
        for(int i=startIndex; i<endIndex; i++){
            System.out.println(list.get(i) + "^2=" + calculateSquare(list.get(i)));
        }
    }

    private static ArrayList<Integer> generateNumbers(int size){
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i=0; i<size; i++){
            numbers.add(i);
        }
        return numbers;
    }

    private static void secvential(ArrayList<Integer> numbers){
        for(Integer number : numbers){
            System.out.println(number + "^2=" + calculateSquare(number));
        }
    }

    private static long getTime(Function<ArrayList<Integer>, Void> function, ArrayList<Integer> list){
        function.apply(list);
        return 0;
    }

    public static void withThread(ArrayList<Integer> numbers) throws InterruptedException {

        ArrayList<Thread> threads = new ArrayList<>();
        int nrOfThreads = Runtime.getRuntime().availableProcessors(); // on my machine is 8
        for(int i=0; i<nrOfThreads; i++){
            int startIndex = i*numbers.size()/nrOfThreads;
            int endIndex = startIndex+numbers.size()/nrOfThreads;
            threads.add(new Thread(()-> printSquare(numbers, startIndex,endIndex)));
        }

        for(Thread thread : threads){
            thread.start();
        }

        for(Thread thread : threads){
            thread.join();
        }
    }

    public static void withParallelStream(ArrayList<Integer> numbers){
        numbers.parallelStream().forEach(number -> System.out.println(number + "^2=" + calculateSquare(number)));
    }

    public static void withFuture(ArrayList<Integer> numbers) throws ExecutionException, InterruptedException {
        FutureCalculator futureCalculator = new FutureCalculator();
        futureCalculator.execute(numbers);
    }



    public static void multipleTests() throws ExecutionException, InterruptedException {
        ArrayList<Integer> listOf10 = generateNumbers(10);
        getTime((x->{
            try {
                withFuture(x);
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }
            return null;
        }), listOf10);



    }

}
