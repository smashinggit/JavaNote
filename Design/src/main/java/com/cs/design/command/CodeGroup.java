package com.cs.design.command;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 10:19
 * @description：代码组
 * @modified By：
 * @version: $
 */
public class CodeGroup extends Group {
    /**
     * 客户要求需求组过去和他们谈
     */
    @Override
    void find() {
        System.out.println("找到代码组...");
    }

    @Override
    void add() {
        System.out.println("客户要求增加一项功能...");
    }

    @Override
    void delete() {
        System.out.println("客户要求删除一项功能...");

    }

    @Override
    void change() {
        System.out.println("客户要求修改一项功能...");

    }

    @Override
    void plan() {
        System.out.println("客户要求代码变更计划...");

    }
}
