package com.cs.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/5 11:28
 * @description：
 * @modified By：
 * @version: $
 * 代理模式（Proxy Pattern）是一个使用率非常高的模式
 * 为其他对象提供一种代理以控制对这个对象的访问
 */
public class Client {
    public static void main(String[] args) {

//        IGamePlayer zhangsan = new GamePlayer("zhangsan");
//        IGamePlayer gameProxy = new GamePlayerProxy(zhangsan);
//        gameProxy.login("zhangsan", "123456");
//        gameProxy.killBoss();
//        gameProxy.upgrade();


        //动态代理
        IGamePlayer zhangsan = new GamePlayer("zhangsan");
        InvocationHandler handler = new GamePlayerIH(zhangsan);

        //动态产生一个代理者
        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(zhangsan.getClass().getClassLoader(),
                new Class[]{IGamePlayer.class}, handler);

        proxy.login("zhangsan", "123456");
        proxy.killBoss();
        proxy.upgrade();
    }
}
