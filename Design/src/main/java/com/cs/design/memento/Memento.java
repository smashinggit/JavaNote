package com.cs.design.memento;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/7 9:33
 * @description：备忘录
 * @modified By：
 * @version: $
 */
public class Memento {

    private String state = "";

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
