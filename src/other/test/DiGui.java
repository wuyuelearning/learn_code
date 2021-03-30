package other.test;

import sun.misc.ConditionLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wuyue on 2020/7/24.
 */
public class DiGui {
    public static void main(String[] args){
        DiGui gui =new DiGui();
        System.out.println(  "---"+gui.digui1(1));
    }

    private Integer  digui1(int i){
        if (i ==10)
            return null;
        digui1(++i);
        System.out.println(i);
        return ++i;
    }
}
