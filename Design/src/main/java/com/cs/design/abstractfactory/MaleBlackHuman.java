package com.cs.design.abstractfactory;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/30 17:41
 * @description：
 * @modified By：
 * @version: $
 */
public class MaleBlackHuman extends AbstractBlackHuman {
    @Override
    public void getSex() {
        System.out.println("黑人男性");
    }
}
