import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task2 {
    private int counter;
    private Lock lock = new ReentrantLock(true);

    public void runTask() {

new Thread(()->{
    for (int i = 0; i < 5; i++) {
        lock.lock();
        counter++;
        System.out.println(counter);
        lock.unlock();
    }
}).start();

new Thread(()->{
    for (int i = 0; i < 5; i++) {
        lock.lock();
        counter++;
        System.out.println(counter);
        lock.unlock();
    }
}).start();

new Thread(()->{
    for (int i = 0; i < 5; i++) {
        lock.lock();
        counter++;
        System.out.println(counter);
        lock.unlock();
    }
}).start();
    }

}
