package addersubtracter;

import org.w3c.dom.css.Counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        Lock lock = new ReentrantLock();
        Adder adder = new Adder(count, lock);
        Subtractor subtract = new Subtractor(count, lock);

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(adder);
        executor.execute(subtract);

        //Blocks until all tasks have completed execution after a shutdown request,or
        // the timeout occurs, or the current thread is interrupted whichever happens first.
        executor.awaitTermination(1, TimeUnit.SECONDS);

        System.out.println("Final Value: " + count.getValue());
    }
}
