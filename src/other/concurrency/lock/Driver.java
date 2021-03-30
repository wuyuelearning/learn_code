package other.concurrency.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by wuyue on 2021/1/4.
 */
public class Driver {
    private static final int N = 10;
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal =new CountDownLatch(1);
        CountDownLatch doneSignal =new CountDownLatch(N);

        for (int i=0;i<N;i++){
            new Thread(new WorkerRunnable(startSignal,doneSignal,i)).start();
        }
        System.out.println("do1 ......");
        startSignal.countDown();
        System.out.println("do2...");
        doneSignal.await();
        System.out.println("done !!!");

        CyclicBarrier c  =new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {

            }
        });




    }
    private void do1(){
        System.out.println("do1 ......");
    }

    static class WorkerRunnable implements Runnable{
        CountDownLatch startSignal ;
        CountDownLatch doneSignal ;
        int i=0;
        public WorkerRunnable(CountDownLatch startSignal,CountDownLatch doneSignal,int i){
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
            this.i = i;
        }
        void doWork(int i) throws InterruptedException {
            System.out.println("Thread: " + i + "  do work...");
        }

        @Override
        public void run() {
            try {
                startSignal.await();
                doWork(i);
                doneSignal.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
