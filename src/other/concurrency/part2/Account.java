package concurrency.part2;

/**
 * Created by wuyue on 2020/12/2.
 */
public class Account {
    public  int balance;

      void  transfer(Account target, int amt){
          synchronized (Account.class){
              if(balance>=amt){
                  balance-=amt;
                  target.balance+=amt;
              }
          }

    }
}
