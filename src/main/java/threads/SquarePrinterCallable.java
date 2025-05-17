package threads;

import lombok.AllArgsConstructor;
import java.util.concurrent.Callable;

@AllArgsConstructor
public class SquarePrinterCallable implements Callable<Integer> {

    private Integer number;

    @Override
    public Integer call() throws Exception {
        Thread.sleep(10000);
        return number*number;
    }
}
