package com.cs.base;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/6 10:43
 * @description：面向对象
 * @modified By：
 * @version: $
 * <p>
 * 面向对象的特征：
 * 继承(inheritance)
 * 封装(encapsulation)
 * 多态(polymorphism)
 * <p>
 * 成员变量和局部变量的区别：
 * 1、在类中的位置不同
 * 成员变量——类中方法外
 * 局部变量——方法内或者方法声明上
 * 2、在内存中的位置不同
 * 成员变量——堆内存
 * 局部变量——栈内存
 * 3、 生命周期不同
 * 成员变量——随着对象的存在而存在，随着对象的消失而消失
 * 局部变量——随着方法的调用而存在，随着方法的调用完毕而消失
 * 4、初始化值不同
 * 成员变量——有默认的初始化值
 * 局部变量——没有默认的初始化值，必须先定义，赋值，才能使用。
 */
public class ObjectDemo {


    public static void main(String[] args) {

        // 面向过程： 把大象装进冰箱
        System.out.println("面向过程： 把大象装进冰箱");
        open();
        in();
        close();

        //面向对象： 把大象装进冰箱
        System.out.println("面向对象： 把大象装进冰箱");
        BingXiang.open();
        DaXiang.in();
        BingXiang.close();
    }


    /**
     * 面向过程： 把大象装进冰箱
     */

    private static void open() {
        System.out.println("打开冰箱门");
    }

    private static void in() {
        System.out.println("装进大象");
    }

    private static void close() {
        System.out.println("关闭冰箱门");
    }


}


/**
 * 面向对象： 把大象装进冰箱
 */
class DaXiang {
    public static void in() {
        System.out.println("装进大象");
    }
}

class BingXiang {
    public static void open() {
        System.out.println("打开冰箱门");
    }

    public static void close() {
        System.out.println("关闭冰箱门");
    }
}