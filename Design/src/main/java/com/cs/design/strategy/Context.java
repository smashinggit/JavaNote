package com.cs.design.strategy;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 16:18
 * @description：
 * @modified By：
 * @version: $
 */
public class Context {

    IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void operate() {
        this.strategy.operate();
    }

}
