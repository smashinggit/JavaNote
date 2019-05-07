package com.cs.design.templatemethod;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/5 9:40
 * @description：模板方法模式
 * @modified By：
 * @version: $
 * <p>
 * 定义一个操作中的算法的框架，而将一些步骤延迟到子类中。使得子类可以不改
 * 变一个算法的结构即可重定义该算法的某些特定步骤
 * <p>
 * 模板方法模式就是在模板方法中按照一定的规则和顺序调用基本方法
 */
public class TemplateMethod {

    public static void main(String[] args) {
        BMW1 bmw1 = new BMW1();
        BMW2 bmw2 = new BMW2();


        bmw1.run();
        bmw2.setAlarmFlag(false);
        bmw2.run();
    }
}
