package com.cs.design.memento;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/7 9:31
 * @description：
 * @modified By：
 * @version: $
 */
public class Boy {

    private String state = "";

    public void changeState() {
        state = "心情可能很不好";
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento() {
        return new Memento(this.state);
    }

    public void restoreMemento(Memento memento) {
        this.setState(memento.getState());
    }

}
