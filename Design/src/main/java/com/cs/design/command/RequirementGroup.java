package com.cs.design.command;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 10:19
 * @description：需求组
 * @modified By：
 * @version: $
 */
public class RequirementGroup extends Group {
    /**
     * 客户要求需求组过去和他们谈
     */
    @Override
    void find() {
        System.out.println("找到需求组...");
    }

    @Override
    void add() {
        System.out.println("客户要求增加一项需求...");
    }

    @Override
    void delete() {
        System.out.println("客户要求删除一项需求...");

    }

    @Override
    void change() {
        System.out.println("客户要求修改一项需求...");

    }

    @Override
    void plan() {
        System.out.println("客户要求需求变更计划...");

    }
}
