package other.pattern.observer;

/**
 * Created by wuyue on 2021/4/13.
 */
public class ConcreteObserver1 implements Observer {
    @Override
    public void response() {
        System.out.println("1");
    }
}
