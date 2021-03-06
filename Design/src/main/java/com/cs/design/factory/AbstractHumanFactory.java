package com.cs.design.factory;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/30 16:42
 * @description：
 * @modified By：
 * @version: $
 */
interface AbstractHumanFactory {

    <T extends Human> T createHuman(Class<T> c);
}
