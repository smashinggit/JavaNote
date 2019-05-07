package com.cs.design.command;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 10:22
 * @description：命令模式
 * @modified By：
 * @version: $
 */
public class Client {

    public static void main(String[] args) {

//        Group rg = new RequirementGroup();
//        rg.find();
//        rg.add();
//        rg.plan();

        Invoker invoker = new Invoker();
        System.out.println("------------客户要求增加一项需求---------------");
        Command addCommand = new AddRequirementCommand();
        invoker.setCommand(addCommand);
        invoker.action();

    }
}
