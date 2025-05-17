package addersubtracter;

import lombok.AllArgsConstructor;

import java.util.concurrent.locks.Lock;

@AllArgsConstructor
public class Adder  implements Runnable{

    private Count count;
    private Lock lock;
    @Override
    public void run() {

        for(int i=1;i<=10000;i++){
            lock.lock();
            int value = count.getValue();
            value = value + i;
            count.setValue(value);
            lock.unlock();
        }
    }
}
