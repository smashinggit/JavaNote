package com.cs.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/5 14:47
 * @description：
 * @modified By：
 * @version: $
 */
public class GamePlayerIH implements InvocationHandler {

    /**
     * 被代理者
     */
    Class cls = null;

    /**
     * 被代理的实例
     */
    Object object = null;


    /**
     * 我要代理谁
     *
     * @param object
     */
    public GamePlayerIH(Object object) {
        this.object = object;
    }

    /**
     * 调用被代理的方法
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(this.object, args);
        if (method.getName().equals("login")) {
            System.out.println("有人登录了账号");
        }
        return result;
    }
}
