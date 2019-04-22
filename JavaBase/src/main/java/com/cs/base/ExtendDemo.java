package com.cs.base;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/8 9:38
 * @description：
 * @modified By：
 * @version: $
 * <p>
 * <p>
 * 方法重写（Override）和方法重载（Overload）的区别?方法重载能改变返回值类型吗?
 * <p>
 * 方法重写：在子类中，出现和父类中一模一样的方法声明的现象。
 * 方法重载：同一个类中，出现的方法名相同，参数列表不同的现象。
 * 方法重载能改变返回值类型，因为它和返回值类型无关。
 * <p>
 * <p>
 * this关键字和super关键字分别代表什么?以及他们各自的使用场景和作用。
 * <p>
 * this:代表当前类的对象引用
 * super:代表父类存储空间的标识。(可以理解为父类的引用，通过这个东西可以访问父类的成员)
 * 场景：
 * 成员变量：this.成员变量——super.成员变量
 * 构造方法：this(…)——super(…)
 * 成员方法：this.成员方法——super.成员方法
 * <p>
 * <p>
 * <p>
 * 类与类,类与接口以及接口与接口的关系
 * 类与类：
 * 继承关系,只能单继承,可以多层继承。
 * 类与接口：
 * 实现关系,可以单实现,也可以多实现。
 * 并且还可以在继承一个类的同时实现多个接口。
 * 接口与接口：
 * 继承关系,可以单继承,也可以多继承。
 * <p>
 * <p>
 * <p>
 * 抽象类和接口的区别
 * 成员区别
 * 抽象类：
 * 成员变量：可以变量，也可以常量
 * 构造方法：有
 * 成员方法：可以抽象，也可以非抽象
 * 接口：
 * 成员变量：只可以常量
 * 成员方法：只可以抽象
 * 关系区别
 * <p>
 * 类与类
 * 继承，单继承
 * 类与接口
 * 实现，单实现，多实现
 * 接口与接口
 * 继承，单继承，多继承
 * 设计理念区别
 * 抽象类
 * 被继承体现的是：”is a”的关系。
 * 抽象类中定义的是该继承体系的共性功能。
 * 接口
 * 被实现体现的是：”like a”的关系。
 * 接口中定义的是该继承体系的扩展功能。
 */
public class ExtendDemo {

    /**
     * 子类中所有的构造方法默认都会访问父类中空参数的构造方法
     * 因为子类会继承父类中的数据，可能还会使用父类的数据。所以，子类初始化之前，一定要先完成父类数据的初始化。
     * 注意：子类每一个构造方法的第一条语句默认都是：super();
     */
    public static void main(String[] args) {

        Son son = new Son();
        System.out.println("------------");
        Son son2 = new Son();

    }
}

class Father {
    int age;

    public Father() {
        System.out.println("Father的无参构造方法");
    }

    public Father(String name) {
        System.out.println("Father的带参构造方法");
    }
}


/**
 * 如果父类没有无参构造方法，那么子类的构造方法会出现什么现象呢?我注释了上面例子中父类的无参构造，
 * 然后项目报错了，那么我们怎么解决呢？
 * <p>
 * 1、在父类中加一个无参构造方法
 * 2、通过使用super关键字去显示的调用父类的带参构造方法
 * 3、子类通过this去调用本类的其他构造方法
 * （子类中一定要有一个去访问了父类的构造方法，否则父类数据就没有初始化。）
 */
class Son extends Father {
    public Son() {
        //super();
        System.out.println("Son的无参构造方法");
    }

    public Son(String name) {
        //super();
        System.out.println("Son的带参构造方法");
    }
}
