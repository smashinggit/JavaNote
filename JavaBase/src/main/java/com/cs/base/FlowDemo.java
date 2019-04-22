package com.cs.base;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/5 23:05
 * @description： 流程控制语句、跳转控制语句
 * @modified By：
 * @version: $
 * <p>
 * <p>
 */
public class FlowDemo {


    public static void main(String[] args) {
        ShuiXianHuaNum();
        zhumulangma();
        star();
        chengfabiao();
        breakAndContinue();
    }


    /**
     * for循环适合针对一个范围判断进行操作
     * <p>
     * 统计3位数中共有多少个水仙花数
     * 所谓的水仙花数是指一个三位数，其各位数字的立方和等于该数本身
     */
    private static void ShuiXianHuaNum() {
        int count = 0;
        for (int i = 100; i < 1000; i++) {
            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 10 / 10 % 10;

            if (i == (ge * ge * ge + shi * shi * shi + bai * bai * bai)) {
                count++;
                System.out.println("水仙花数是：" + bai + "" + shi + "" + ge);
            }
        }
        System.out.println("水仙花数共有" + count + "个");
    }

    /**
     * while循环适合判断次数不明确操作
     * <p>
     * 需求：我国最高山峰是珠穆朗玛峰：8848m，我现在有一张足够大的纸张，厚度为：0.01m。
     * 请问，我折叠多少次，就可以保证厚度不低于珠穆朗玛峰的高度?
     */
    private static void zhumulangma() {

        int count = 0;
        float end = 8848f;
        float start = 0.01f;

        while (start < end) {
            count++;
            start *= 2;  //折叠一次有什么变化呢?就是厚度是以前的2倍。
            System.out.println("第" + count + "次的厚度是 " + start);
        }

        //输出统计变量
        System.out.println("要叠" + count + "次");
    }

    /**
     * 请输出一个4行5列的星星(*)图案
     */
    private static void star() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    /**
     * 请输出个九九乘法表
     */
    private static void chengfabiao() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " * " + i + " = " + i * j + "   ");
            }
            System.out.print("\n");
        }
    }


    /**
     * break 退出当前循环
     * continue 退出本次循环
     */
    private static void breakAndContinue() {

        for (int i = 0; i < 10; i++) {
            if (i == 3)
                break;
            System.out.println("i = " + i);
        }
        System.out.println("break 跳出循环");


        for (int i = 0; i < 10; i++) {
            if (i == 3)
                continue;
            System.out.println("i = " + i);
        }
        System.out.println("continue 跳过此次循环");
    }
}
