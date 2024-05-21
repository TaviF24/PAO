package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCalculator {
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public Future<String> calculate(Integer input) {
        return executor.submit(
                () -> input + "^2=" + input*input
        );
    }

    public void execute(ArrayList<Integer> numbers) throws ExecutionException, InterruptedException {
        List<Future<String>> futures = new ArrayList<>();
        for(Integer number : numbers){
            futures.add(calculate(number));
        }

        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        executor.shutdown();
    }
}
