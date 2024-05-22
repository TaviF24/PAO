package task1;

import java.util.ArrayList;
import java.util.HashMap;
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

    private static void sequential(ArrayList<Integer> numbers){
        for(Integer number : numbers){
            System.out.println(number + "^2=" + calculateSquare(number));
        }
    }

    private static HashMap<String, Long> getMappedTime(ArrayList<Function<ArrayList<Integer>, String>> functions, ArrayList<Integer> numbers){
        HashMap<String, Long> hashMap = new HashMap<>();
        for(Function<ArrayList<Integer>, String> function : functions){
            long start = System.nanoTime();
            String functionName = function.apply(numbers);
            long finish = System.nanoTime();
            long timeElapsed = finish-start;
            hashMap.put(functionName, timeElapsed);
        }
        return hashMap;
    }

    public static void withThread(ArrayList<Integer> numbers) throws InterruptedException {

        ArrayList<Thread> threads = new ArrayList<>();
        int nrOfThreads = Runtime.getRuntime().availableProcessors(); // on my machine is 8
        int numbersPerThread = numbers.size()/nrOfThreads;
        for(int i=0; i<nrOfThreads-1; i++){
            int startIndex = i*numbersPerThread;
            int endIndex = startIndex+numbersPerThread;
            threads.add(new Thread(()-> printSquare(numbers, startIndex, endIndex)));
        }
        int startIndex = (nrOfThreads-1)*numbersPerThread;
        int endIndex = numbers.size();
        threads.add(new Thread(()-> printSquare(numbers, startIndex, endIndex)));
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



    public static void multipleTests() {
        ArrayList<Function<ArrayList<Integer>, String>> functionList = new ArrayList<>();

        functionList.add((x->{
            try {
                withThread(x);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "with Thread";
        }));

        functionList.add((x->{
            withParallelStream(x);
            return "with ParallelStream";
        }));

        functionList.add((x->{
            try {
                withFuture(x);
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "with Future";
        }));

        functionList.add((x->{
            sequential(x);
            return "with Sequential";
        }));


        String fileName = "outputTask2.txt";
        ArrayList<Integer> listOfNumbers = generateNumbers(10);
        HashMap<String, Long> result = getMappedTime(functionList, listOfNumbers);
        FilePrinter.printFromHash(fileName, result);

        listOfNumbers = generateNumbers(1_000);
        result = getMappedTime(functionList, listOfNumbers);
        FilePrinter.printFromHash(fileName, result);

        listOfNumbers = generateNumbers(10_000);
        result = getMappedTime(functionList, listOfNumbers);
        FilePrinter.printFromHash(fileName, result);

        listOfNumbers = generateNumbers(10_000_000);
        result = getMappedTime(functionList, listOfNumbers);
        FilePrinter.printFromHash(fileName, result);
    }

}

