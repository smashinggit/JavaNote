package com.cs.design.command;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 10:44
 * @description：
 * @modified By：
 * @version: $
 */
public class DeletePageCommand extends Command {
    @Override
    void execute() {
        super.pg.find();
        super.pg.delete();
        super.pg.plan();
    }
}
