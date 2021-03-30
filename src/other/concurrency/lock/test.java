package other.concurrency.lock;

import java.lang.management.BufferPoolMXBean;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wuyue on 2020/12/14.
 */
public class test {
    public static void main(String[] args) {
//
//        test test = new test();
//        BoundedBuffer b =new BoundedBuffer();
//        ReentrantLock t =new ReentrantLock();

//        for (int i=0;i<10;i++){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        b.take();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    b.put(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//       Thread d = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//
//            }
//        });
//
//       d.start();
//       d.interrupt();
//        System.out.println(d.isInterrupted());
//        System.out.println(d.isInterrupted());

//        while (!d.interrupted()){
//            System.out.println("next ");
//        }

        User user =new User();
        user.name ="11";
        AtomicStampedReference<User> atomicStampedReference =new AtomicStampedReference(user,18) ;
        user.name ="12";
        atomicStampedReference.set(user,12);





    }

    int value;
    Lock f = new ReentrantLock();
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();



    private void fun1() {
        lock.lock();

        try {
            value += get();
            condition.await();
        }catch (Exception e){

        }finally {
            lock.unlock();
            condition.signal();

        }
    }

    private int get() {
        f.lock();
        try {
            return value;

        } finally {
            f.unlock();
        }
    }
}
