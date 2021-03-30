package other.concurrency.part3;

/**
 * Created by wuyue on 2020/12/3.
 */
public class Account {
    private int balance;
    private Allocator actr =Allocator.getInstance();

    void transfer(Account target ,int ami){
        actr.apply(this,target);
        try {
            synchronized (this){
                synchronized (target){
                    if (this.balance>=ami){
                        this.balance -= ami;
                        target.balance+=ami;
                    }
                }
            }
        }finally {
            actr.free(this,target);
        }

    }
}
