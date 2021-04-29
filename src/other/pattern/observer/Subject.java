package other.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuyue on 2021/4/13.
 */
abstract class Subject {
    List<Observer> observers =new ArrayList<>();

    public void add(Observer observer){
        observers.add(observer);
    }

    public void remove(Observer observer){
        observers.remove(observer);
    }

    public abstract void notifyObserver();
}
