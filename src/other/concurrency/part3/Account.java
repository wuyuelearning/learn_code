package concurrency.part3;

/**
 * Created by wuyue on 2020/12/3.
 */
public class Account {
    private int balance;
    void transfer(Account target ,int ami){
        synchronized (this){
            synchronized (target){
                if (this.balance>=ami){
                    this.balance -= ami;
                    target.balance+=ami;
                }
            }
        }
    }
}
