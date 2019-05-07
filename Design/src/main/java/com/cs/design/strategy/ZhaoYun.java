package com.cs.design.strategy;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 16:20
 * @description：
 * @modified By：策略模式
 * @version: $
 * <p>
 * 策略模式（Strategy Pattern）叫做政策模式（Policy Pattern）
 * 定义一组算法，将每个算法都封装起来，并且使它们之间可以互换
 */
public class ZhaoYun {

    public static void main(String[] args) {
        Context context;

        //刚刚到吴国的时候拆第一个
        System.out.println("---刚刚到吴国的时候拆第一个---");
        context = new Context(new BackDoor());
        context.operate();
        //刘备乐不思蜀了，拆第二个了
        System.out.println("---刘备乐不思蜀了，拆第二个了---");
        context = new Context(new GiveGreenLight());
        context.operate(); //执行了第二个锦囊
        //孙权的小兵追来了，咋办？拆第三个
        System.out.println("---孙权的小兵追来了，咋办？拆第三个---");
        context = new Context(new BlockEnemy());
        context.operate(); //孙夫人退兵
    }
}
