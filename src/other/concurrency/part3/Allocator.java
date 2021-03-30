package other.concurrency.part3;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by wuyue on 2020/12/7.
 */
public class Allocator {

    private Allocator(){

    }
    private static volatile  Allocator allocator;

    public static Allocator getInstance(){
        if (allocator ==null){
            synchronized (Allocator.class){
                if (allocator == null){
                    allocator =new Allocator();
                }
            }
        }
        return allocator;

    }

    private List<Object> als = new CopyOnWriteArrayList<>();

    public synchronized void apply(Object from, Object to) {
        while (als.contains(from) || als.contains(to)) {
            try {
                wait();
            } catch (InterruptedException e) {

            }

        }
        als.add(from);
        als.add(to);
    }

    public synchronized void free(Object from, Object to) {
        als.remove(from);
        als.remove(to);
        notifyAll();
    }
}
