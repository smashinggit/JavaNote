package com.cs.design.builder;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/5 10:44
 * @description：
 * @modified By：
 * @version: $
 * <p>
 * 建造者模式（Builder Pattern）也叫做生成器模式，
 * 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示
 * <p>
 * 建造者模式最主要的功能是基本方法的调用顺序安排，也就是这些基本方法已经实现了，
 * 通俗地说就是零件的装配， 顺序不同产生的对象也不同；
 * 而工厂方法则重点是创建，创建零件是它的主要职责，组装顺序则不是它关心的。
 */
public class Client {

    public static void main(String[] args) {

        Director director = new Director();
        BenzModel benzA = director.getABenzModel();
        BenzModel benzB = director.getBBenzModel();

        benzA.run();
        benzB.run();
    }
}
