package lamdas;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Runner {
    public static void main(String[] args) throws Exception {
        Runnable runnable = () -> System.out.println("Hello World");
        Thread thread = new Thread(() -> System.out.println("Hello World!"));

        Callable<String> callable = () -> "Hello World!".toUpperCase();
        Future<String> value = Executors.newSingleThreadExecutor().submit(callable);
        System.out.println(value.get());

        thread.start();
    }
}


// Lamdas reduce code they internally call run method and
// can only be implemented on fuctionalInterfaces(interface with  single abstract Method)

