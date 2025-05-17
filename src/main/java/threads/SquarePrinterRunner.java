package threads;

import java.util.List;

public class SquarePrinterRunner {
    public static void main(String[] args) {
        //create list
        List<Integer> values = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //iterate over list and create threads

        for(int value : values) { //autoboxing
            Thread thread = new Thread(new SquarePrinter(value));
            thread.start();
        }
    }
}
