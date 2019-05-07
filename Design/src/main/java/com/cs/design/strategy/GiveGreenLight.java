package com.cs.design.strategy;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 16:15
 * @description：
 * @modified By：
 * @version: $
 */
public class GiveGreenLight implements IStrategy {
    @Override
    public void operate() {
        System.out.println("求吴国太开绿灯,放行！");
    }
}
