package other.concurrency.lock;

import java.util.concurrent.*;

/**
 * Created by wuyue on 2021/1/4.
 */
public class Driver2 {

    private static final int N = 10;

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch doneSignal = new CountDownLatch(3);
        Executor e = Executors.newFixedThreadPool(N);

        for (int i = 0; i < N; i++) {
            e.execute(new WorkerRunnable(doneSignal, i));
        }
        doneSignal.await();
        System.out.println("done!!!!");
    }

    static class WorkerRunnable implements Runnable {
        private CountDownLatch doneSignal;
        private int i;
        Semaphore f =new Semaphore(10);

        public WorkerRunnable(CountDownLatch doneSignal, int i) {
            this.doneSignal = doneSignal;
            this.i = i;
        }


        @Override
        public void run() {
            try {
                doWork(i);
                Thread.sleep(4000);
                doneSignal.countDown();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        void doWork(int i) throws InterruptedException {
            System.out.println("Thread: " + i + "  do work...");
        }
    }

}
