package com.cs.design.factory;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/30 16:43
 * @description：
 * @modified By：
 * @version: $
 */
public class BlackHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黑种人的皮肤颜色是 黑色");
    }

    @Override
    public void talk() {
        System.out.println("黑种人说话 *（#￥——）@#@#*（");
    }
}
