package com.cs.design.memento;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/7 9:40
 * @description：备忘录的管理类
 * @modified By：
 * @version: $
 */
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
