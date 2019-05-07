package com.cs.design.strategy;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 16:15
 * @description：
 * @modified By：
 * @version: $
 */
public class BackDoor implements IStrategy {
    @Override
    public void operate() {
        System.out.println("找乔国老帮忙，让吴国太给孙权施加压力");
    }
}
