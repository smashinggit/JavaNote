package com.cs.design.factory;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/30 16:43
 * @description：
 * @modified By：
 * @version: $
 */
public class WhiteHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("白种人的皮肤颜色是 白色");
    }

    @Override
    public void talk() {
        System.out.println("白种人说话  hello");
    }
}
