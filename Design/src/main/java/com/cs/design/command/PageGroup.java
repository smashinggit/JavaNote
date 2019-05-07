package com.cs.design.command;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 10:19
 * @description：美工组
 * @modified By：
 * @version: $
 */
public class PageGroup extends Group {
    /**
     * 客户要求需求组过去和他们谈
     */
    @Override
    void find() {
        System.out.println("找到美工组...");
    }

    @Override
    void add() {
        System.out.println("客户要求增加一个页面...");
    }

    @Override
    void delete() {
        System.out.println("客户要求删除一个页面...");

    }

    @Override
    void change() {
        System.out.println("客户要求修改一个页面...");

    }

    @Override
    void plan() {
        System.out.println("客户要求页面变更计划...");

    }
}
