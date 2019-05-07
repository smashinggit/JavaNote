package com.cs.design.builder;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/5 10:37
 * @description：
 * @modified By：
 * @version: $
 */
public class BenzModel extends CarModel {
    @Override
    protected void start() {
        System.out.println("奔驰车 启动");
    }

    @Override
    protected void engineBoom() {
        System.out.println("奔驰车 引擎轰鸣");

    }

    @Override
    protected void alarm() {
        System.out.println("奔驰车 响喇叭");

    }

    @Override
    protected void stop() {
        System.out.println("奔驰车 停止");

    }
}
