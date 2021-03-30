package other.concurrency.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wuyue on 2020/12/15.
 */
public class BlockedQueue<T> {
    final Lock lock= new ReentrantLock();
    final Condition notFull =lock.newCondition();
    final Condition notEmpty =lock.newCondition();

    void enr(T v){
        lock.lock();
        try {
//            while (队列已满){
//                notFull.await();
//            }
//            notEmpty.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    void deq(){
        lock.lock();
        try{
//            while (队列已空){
//                notEmpty.await();
//            }
//            notFull.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


}
