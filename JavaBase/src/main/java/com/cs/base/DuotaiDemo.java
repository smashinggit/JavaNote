package com.cs.base;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/8 10:24
 * @description：
 * @modified By：
 * @version: $
 * <p>
 * <p>
 * <p>
 * 那么使用多态的前提是什么呢？
 * 1、要有继承关系。
 * 2、要有方法重写。
 * 3、要有父类引用指向子类对象。
 * <p>
 * <p>
 * <p>
 * 多态中的成员访问特点
 * 成员变量
 * 编译看左边，运行看左边
 * 构造方法
 * 子类的构造都会默认访问父类构造
 * 成员方法
 * 编译看左边，运行看右边
 * 静态方法
 * 编译看左边，运行看左边
 * 所以静态方法不能算方法的重写
 * <p>
 * <p>
 * <p>
 * 向上转型
 * 从子到父
 * 父类引用指向子类对象
 * Fu f = new Zi();
 * 向下转型
 * 从父到子
 * 父类引用转为子类对象
 * Zi z = (Zi)f; //要求该f必须是能够转换为Zi的。
 */
public class DuotaiDemo {

    public static void main(String[] args) {

        Animal cat = new Cat();
        cat.eat(); //成员方法  编译看左边，运行看右边
        cat.run();
//        cat.shangshu();//成员方法  编译看左边，运行看右边
        System.out.println("flag " + cat.flag);   //成员变量 编译看左边，运行看左边


        Animal dog = new Dog();  //向上转型 父类引用指向子类对象
        dog.eat();
        dog.run();
        ((Dog) dog).kanjia();  //向下转型  父类引用转为子类对象

    }
}

class Animal {
    int flag = 1;

    public void eat() {
        System.out.println("Animal吃东西，由子类实现");
    }

    public void run() {
        System.out.println("Animal跑步，由子类实现");
    }

}

class Cat extends Animal {
    int flag = 2;

    @Override
    public void eat() {
        System.out.println("猫爱吃鱼");
    }

    @Override
    public void run() {
        System.out.println("猫跑步");
    }

    public void shangshu() {
        System.out.println("猫会上树");
    }
}

class Dog extends Animal {
    int flag = 3;

    @Override
    public void eat() {
        System.out.println("狗爱吃肉");

    }

    @Override
    public void run() {
        System.out.println("狗");

    }

    public void kanjia() {
        System.out.println("狗会看家");
    }

}