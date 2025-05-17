package threads;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SquarePrinterRunnerExecutors {
    public static void main(String[] args) {
        //create list
        List<Integer> values = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //Executor executor = Executors.newSingleThreadExecutor();

        //ExecutorService executor = Executors.newFixedThreadPool(4); //max threads used to execute code

        ExecutorService executor = Executors.newCachedThreadPool(); // keep on creating threads as long as available and reuse them
        System.out.println(Thread.currentThread().getName());
        //iterate over list and create threads
        for(int value : values) { //autoboxing
            executor.execute(new SquarePrinter(value));
        }
    }
}
