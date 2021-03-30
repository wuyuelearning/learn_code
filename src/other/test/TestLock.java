package other.test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wuyue on 2021/3/11.
 */
public class TestLock {
    public static void main(String[] args) {
    TestLock testLock =new TestLock();
    testLock.fun();
    }
    ReentrantLock lock =new ReentrantLock();
    Condition condition1 =lock.newCondition();
    Condition condition2 =lock.newCondition();
    Condition condition3 =lock.newCondition();
    int num=1;

    private void fun(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0;i<10;i++)
                    print10();
            }
        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i =0;i<10;i++)
//                print5();
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i =0;i<10;i++)
//                print15();
//            }
//        }).start();



    }




    private void print5() {

        lock.lock();
        try {
            while (num!=1){
                condition1.await();
                System.out.println("A ..wait....");
            }
            for (int i=0;i<5;i++){
                System.out.print( "A ,");
            }
            System.out.println();
            num =2;
            condition2.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (lock.isHeldByCurrentThread()){
                System.out.println("A --- 释放锁");
                lock.unlock();
            }
        }
    }

    private void print10(){
        
        lock.lock();
        try{
            while (num!=2){
                System.out.println("B ..wait....");
                condition2.await();
            }
            for (int i=0;i<10;i++){
                System.out.print( "B ,");
            }
            System.out.println();
            num =3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()){
                System.out.println("B--- 释放锁");
                lock.unlock();
            }
        }
    }

    private void print15(){
        lock.lock();
        try {
            while (num!=3){
                condition3.await();
                System.out.println("C ..wait....");
            }
            for (int i=0;i<15;i++){
                System.out.print( "C ,");
            }
            System.out.println();
            num=1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (lock.isHeldByCurrentThread()){
                System.out.println("C --- 释放锁");
                lock.unlock();
            }
        }
    }


}
