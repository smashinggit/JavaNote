package com.cs.design.command;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 10:25
 * @description：牵头人
 * @modified By：
 * @version: $
 * 根据客户的命令安排不同的组员进行工作
 * 避免客户直接跟各个组沟通
 */
public class Invoker {

    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action() {
        this.command.execute();
    }
}
