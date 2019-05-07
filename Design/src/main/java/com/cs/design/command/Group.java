package com.cs.design.command;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 10:18
 * @description：
 * @modified By：
 * @version: $
 */
public abstract class Group {

    /**
     * 甲乙双方分开办公，如果你要和某个组讨论，你首先要找到这个组
     */
    abstract void find();

    /**
     * 被要求增加功能
     */
    abstract void add();

    abstract void delete();

    abstract void change();

    /**
     * 被要求给出所有的变更计划
     */
    abstract void plan();
}
