package com.cs.design.strategy;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 16:15
 * @description：
 * @modified By：
 * @version: $
 */
public class BlockEnemy implements IStrategy {
    @Override
    public void operate() {
        System.out.println("孙夫人断后，挡住追兵");
    }
}
