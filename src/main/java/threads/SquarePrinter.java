package threads;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SquarePrinter implements Runnable{

    private Integer number;


    @Override
    public void run() {
        System.out.println(number * number + " Printed by Thread" + Thread.currentThread().getName());
    }
}
