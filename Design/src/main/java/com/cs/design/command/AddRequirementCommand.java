package com.cs.design.command;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 10:43
 * @description：
 * @modified By：
 * @version: $
 */
public class AddRequirementCommand extends Command {
    @Override
    void execute() {
        //找到需求组
        super.rg.find();
        //增加一份需求
        super.rg.add();
        //给出计划
        super.rg.plan();
    }
}
