package other.pattern.observer;

import java.math.BigDecimal;

/**
 * Created by wuyue on 2021/4/13.
 */
public class ConcreteSubject extends Subject {
    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.response();
        }
    }
}
