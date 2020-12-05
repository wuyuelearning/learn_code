package concurrency.part2;

import java.util.concurrent.TimeUnit;

/**
 * Created by wuyue on 2020/12/2.
 */
public class test {
    public static void main(String[] args) throws InterruptedException {
        Account a1 = new Account();
        Account a2 = new Account();
        Account a3 = new Account();
        a1.balance = 200000;
        a2.balance = 200000;
        a3.balance = 200000;

        for (int i = 0; i < 200000; i++) {
            new Thread(() -> {
                a1.transfer(a2, 1);
            }).start();
            new Thread(() -> {
                a2.transfer(a3, 1);
            }).start();
        }


        TimeUnit.SECONDS.sleep(1);
        System.out.println(a1.balance);
        System.out.println(a2.balance);
        System.out.println(a3.balance);

    }
}
