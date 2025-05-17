package addersubtracter;

import lombok.AllArgsConstructor;
import lombok.Synchronized;

import java.util.concurrent.locks.Lock;

@AllArgsConstructor
public class Subtractor implements Runnable{

    private Count count;
    private Lock lock;
    @Override
    public void run() {

        for (int i = 0; i <=10000; i++) {

            synchronized (this.count){
                //lock.lock();
                int value = count.getValue();
                value = value - i;
                count.setValue(value);
                //lock.unlock();
            }
        }
    }
}

// first we added lock and did unlock explicitly using Lock interface
// later we have used synchronized block which will acquire and release lock automatically
// we can use AtomicInteger as type of the count variable and use internal methods like getAndAdd()
// this ensures synchronization at hardware level
// we can use AtomicInteger in Contention scenario as they use a concept called
// lock free Programing which ensures synchronization at hardware level where thread outside Critical section get the updated value


