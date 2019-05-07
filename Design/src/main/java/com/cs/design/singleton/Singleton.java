package com.cs.design.singleton;

import java.util.Vector;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/30 16:20
 * @description：单例模式（Singleton Pattern）
 * @modified By：
 * @version: $
 * 注意，在高并发情况下，请注意单例模式的线程同步问题
 */
public class Singleton {

    public static void main(String[] args) {

    }

}

/**
 * 饿汉式单例
 */
class SingleInstance {
    private static final SingleInstance instance = new SingleInstance();

    private SingleInstance() {
    }

    public static SingleInstance getInstance() {
        return instance;
    }
}

/**
 * 懒汉式单例
 */
class SingleInstance2 {
    private static SingleInstance2 instance = null;

    private SingleInstance2() {
    }

    public static synchronized SingleInstance2 getInstance() {
        if (instance == null) {
            instance = new SingleInstance2();
        }
        return instance;
    }
}

/**
 * 单例模式的扩展
 */
class SingleInstance3 {
    private static int maxNum = 3;
    private static int currentInstanceIndex = 0;
    private static Vector<SingleInstance3> instanceList = new Vector<>(maxNum);

    static {
        for (int i = 0; i < maxNum; i++) {
            instanceList.add(new SingleInstance3());
        }
    }

    private SingleInstance3() {
    }

    public static SingleInstance3 getInstance() {
        //此处根据具体业务逻辑返回
        return instanceList.get(currentInstanceIndex);
    }
}