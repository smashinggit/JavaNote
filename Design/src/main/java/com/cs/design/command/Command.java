package com.cs.design.command;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 10:31
 * @description：命令
 * @modified By：
 * @version: $
 * 对客户发出的命令进行封装，每个命令是一个对象，避免
 * 客户、负责人、组员之间的交流误差，封装后的结果就是客户只要说一个命令，我的项目组
 * 就立刻开始启动，不用思考、解析命令字符串
 * <p>
 * <p>
 * Command抽象类可以有N个子类,只要是由客户产生、时常
 * 性的行为都可以定义为一个命令
 */
public abstract class Command {

    Group cg = new CodeGroup();
    Group pg = new PageGroup();
    Group rg = new RequirementGroup();

    abstract void execute();
}
