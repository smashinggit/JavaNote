package com.cs.design.factory;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/30 16:36
 * @description：工厂方法模式
 * @modified By：
 * @version: $
 * Define an interface for creating an object,but let subclasses decide which class to
 * instantiate.Factory Method lets a class defer instantiation to subclasses.
 * 定义一个用于创建对象的 接口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到其子类
 * <p>
 * <p>
 * 工厂方法模式的扩展
 * 1、缩小为简单工厂模式，也叫做静态工厂模式
 * 掉继承抽象类，并在createHuman前增加static关键字
 * public class FemaleHumanFactory  {
 * <p>
 * public <T extends Human> static T createHuman(Class<T> c) {
 * <p>
 * Human human = null;
 * try {
 * human = (Human) Class.forName(c.getName()).newInstance();
 * } catch (Exception e) {
 * e.printStackTrace();
 * }
 * return (T) human;
 * }
 * }
 * <p>
 * 2、升级为多个工厂类
 * 我们就为每个产品定义一个创造者，然后由调用者自己去选择与哪个工厂方法关联
 * 每个人种（具体的产品类）都对应了一个创建者，每个创建者都独立负责创建对应的产品对象，非常符合单一职责原则
 * 但是给可扩展性和可维护性带来了一定的影响
 *
 *
 */
public class Client {

    public static void main(String[] args) {

        AbstractHumanFactory factory = new HumanFactory();

        System.out.println("--造出的第一批人是白色人种--");
        WhiteHuman whiteHuman = factory.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.talk();

        System.out.println("--造出的第二批人是黑色人种--");
        BlackHuman blackHuman = factory.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();

        System.out.println("--造出的第三批人是黄色人种--");
        YellowHuman yellowHuman = factory.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();
    }

}
