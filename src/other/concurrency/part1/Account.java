package concurrency.part1;

/**
 * Created by wuyue on 2020/12/1.
 */
public class Account {


    private final Object balanceLock =new Object();
    private Integer balance;
    private final Object passWordLock =new Object();
    private String passWord;

    void withdraw(Integer amt){
        synchronized (balanceLock){
            if (balance>0){
                balance-=amt;
            }
        }
    }

    Integer getBalance(){
        synchronized (balanceLock){
            return balance;
        }
    }

    void updatePassWord(String pw){
        synchronized (passWordLock){
            passWord = pw;
        }
    }

    String getPassWord(){
        synchronized (passWordLock){
            return passWord;
        }
    }
}


