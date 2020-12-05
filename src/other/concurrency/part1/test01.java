package concurrency.part1;

import java.util.concurrent.TimeUnit;

/**
 * Created by wuyue on 2020/11/30.
 */
public class test01 {
    public static void main(String[] args) throws InterruptedException {
        test01 t =new test01();
        System.out.println(t.fun());
        t.fun2();


    }
    private  long count= 0;
    Object object =new Object();
    private  long value= 0;
    private void addOne(){
        synchronized (new Object()){
            int i=0;
            while (i++<100000){
                value++;
            }

        }
    }

    private long get(){
        synchronized (new Object()){
            return value;
        }
    }

    private synchronized void add(){
        int i=0;
        while (i++<100000000){
            count++;
        }
    }

    void fun2() throws InterruptedException {
        for (int i=0;i<10000;i++){
            new Thread(()->{
                addOne();
            }).start();
        }

        TimeUnit.SECONDS.sleep(1);

        System.out.println(get());
    }

    private long fun() throws InterruptedException {

        Thread t =new Thread(()->{
            add();
        });
        Thread t1 =new Thread(()->{
            add();
        });

        t.start();
        t1.start();
        t.join();
        t1.join();
        return count;
    }
}
