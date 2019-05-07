package com.cs.design.observe;

import java.util.ArrayList;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 17:37
 * @description：
 * @modified By：
 * @version: $
 */
public class HanFeiZi implements IHanFeiZi, Observable {

    ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void haveBreakfast() {
        System.out.println("韩非子:开始吃饭了...");
        this.notifyObservers("韩非子在吃饭");
    }

    @Override
    public void haveFun() {
        System.out.println("韩非子:开始娱乐了...");
        this.notifyObservers("韩非子在娱乐");
    }


    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 通知所有的观察者
     *
     * @param content
     */
    @Override
    public void notifyObservers(String content) {
        for (Observer observer : observers) {
            observer.update(content);
        }
    }
}
