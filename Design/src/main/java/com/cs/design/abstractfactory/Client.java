package com.cs.design.abstractfactory;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/30 16:36
 * @description：抽象工厂方法模式
 * @modified By：
 * @version: $
 * Provide an interface for creating families of related or dependent objects without specifying
 * their concrete classes
 * 为创建一组相关或相互依赖的对象提供一个接口，而且无须指定它们
 * 的具体类。
 */
public class Client {

    public static void main(String[] args) {

        //第一条生产线，男性生产线
        MaleHumanFactory maleHumanFactory = new MaleHumanFactory();
        //第一条生产线，女性生产线
        FemaleHumanFactory femaleHumanFactory = new FemaleHumanFactory();


        System.out.println("--黄色女性--");
        Human yellowFemale = femaleHumanFactory.createYellowHuman();
        yellowFemale.getColor();
        yellowFemale.talk();
        yellowFemale.getSex();

        System.out.println("--黄色男性--");
        Human yellowMale = maleHumanFactory.createYellowHuman();
        yellowMale.getColor();
        yellowMale.talk();
        yellowMale.getSex();

    }

}
