package lamdas;

public class Printer implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello World " + Thread.currentThread().getName());
    }
}
