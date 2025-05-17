package MergeSort;

import threads.SquarePrinterCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Runner {
    public static void main(String[] args) throws Exception {
        List<Integer> values = List.of( 10,5,234,6,5,233,23,445);

        ExecutorService executor = Executors.newCachedThreadPool();
        Sorter sorter = new Sorter(values, executor);

        Future<List<Integer>> future = executor.submit(sorter);
        System.out.println(future.get());
    }
}
