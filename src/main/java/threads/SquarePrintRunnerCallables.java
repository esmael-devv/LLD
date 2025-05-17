package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquarePrintRunnerCallables {
    public static void main(String[] args) throws Exception {
        //create list
        List<Integer> values = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        List<Future<Integer>> results = new ArrayList<>();
        //iterate over list and create threads
        for(Integer value : values) {
            Future<Integer> future = executor.submit(new SquarePrinterCallable(value));
            results.add(future);
        }

        for(Integer value : values) { // real benifit of using future is after submit we can do some other task like here printing this for loop as it is asynchronous task
            System.out.println("waiting for the future of : " + value);
        }

        for(Future<Integer> future : results) {
            System.out.println(future.isDone()); // isDone is a non blocking method
            //System.out.println(future.isCancelled());
            System.out.println("The Square is " + future.get()); // get is blocking method
            System.out.println("Computed ");
        }

    }
}
