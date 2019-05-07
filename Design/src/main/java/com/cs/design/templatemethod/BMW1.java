package com.cs.design.templatemethod;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/5 9:58
 * @description：
 * @modified By：
 * @version: $
 */
public class BMW1 extends BMWModel {


    @Override
    protected void alarm() {
        System.out.println("BMW1 喇叭响");
    }

    @Override
    protected void engineBoom() {
        System.out.println("BMW1 引擎轰鸣");

    }

    @Override
    protected void start() {
        System.out.println("BMW1 启动");

    }

    @Override
    protected void stop() {
        System.out.println("BMW1 停止");
    }
}
