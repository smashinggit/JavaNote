package com.cs.design.observe;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 18:00
 * @description：被观察者
 * @modified By：
 * @version: $
 */
public interface Observable {

    void addObserver(Observer observer);

    void deleteObserver(Observer observer);

    void notifyObservers(String content);
}
