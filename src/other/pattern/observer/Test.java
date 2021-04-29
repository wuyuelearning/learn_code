package other.pattern.observer;

/**
 * Created by wuyue on 2021/4/13.
 */
public class Test {
    public static void main(String[] args) {
        Observer observer1 =new ConcreteObserver1();
        Observer observer2 =new ConcreteObserver2();
        Subject subject =new ConcreteSubject();
        subject.add(observer1);
        subject.add(observer2);
        subject.notifyObserver();

    }
}
