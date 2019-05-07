package com.cs.design.abstractfactory;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/30 17:41
 * @description：
 * @modified By：
 * @version: $
 */
public class MaleYellowHuman extends AbstractYellowHuman {
    @Override
    public void getSex() {
        System.out.println("黄人男性");
    }
}
