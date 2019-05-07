package com.cs.design.factory;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/30 16:46
 * @description：
 * @modified By：
 * @version: $
 */
public class HumanFactory implements AbstractHumanFactory {

    @Override
    public <T extends Human> T createHuman(Class<T> c) {

        Human human = null;
        try {
            human = (Human) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) human;
    }
}
