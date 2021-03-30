package other.concurrency.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wuyue on 2021/1/4.
 */
public class TestTmp {
    public static void main(String[] args) throws InterruptedException {
        TestTmp testTmp =new TestTmp();
        testTmp.test();
    }
    private AtomicInteger  num = new AtomicInteger(0);
    private ReentrantLock reentrantLock = new ReentrantLock();

    public void test() throws InterruptedException {
        Integer nThread = 20;
        Integer nLatch = 2000;
        ExecutorService executorService = Executors.newFixedThreadPool(nThread);
        CountDownLatch countDownLatch = new CountDownLatch(nLatch);

        class RunnableThread implements Runnable {
            @Override
            public void run() {

                try {
                    if (reentrantLock.tryLock()) {
                        System.out.println(Thread.currentThread().getName() + " isLocked :" + reentrantLock.isLocked());
                        num.addAndGet(1);

                    } else {
                        System.out.println(Thread.currentThread().getName() + " can't lock");
                    }
                } finally {
                    countDownLatch.countDown();
                    if (reentrantLock.isLocked() && reentrantLock.isHeldByCurrentThread()) {
                        reentrantLock.unlock();
                        System.out.println(Thread.currentThread().getName() + " has been unLocked");
                    }
//                    System.out.println(Thread.currentThread().getName() + " has been unLocked");
                }
                System.out.println(num);
            }
        }
        for (int i = 0; i < nLatch; i++) {
            executorService.execute(new RunnableThread());
        }
//
        countDownLatch.await();
        System.out.println(num);
        executorService.shutdown();
    }
}
