package com.cs.design.factory;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/30 16:43
 * @description：
 * @modified By：
 * @version: $
 */
public class YellowHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黄种人的皮肤颜色是 皇色");
    }

    @Override
    public void talk() {
        System.out.println("黄种人说话  你好");
    }
}
