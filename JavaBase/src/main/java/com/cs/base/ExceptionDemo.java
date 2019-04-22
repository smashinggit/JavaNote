package com.cs.base;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/11 16:16
 * @description：
 * @modified By：
 * @version: $
 * <p>
 * final
 * 最终的意思，可以修饰类，成员变量，成员方法
 * 修饰类，类不能被继承
 * 修饰变量，变量是常量
 * 修饰方法，方法不能被重写
 * finally
 * 是异常处理的一部分，用于释放资源。
 * 一般来说，代码肯定会执行，特殊情况：在执行到finally之前jvm退出了
 * finalize
 * 是Object类的一个方法，用于垃圾回收
 */
public class ExceptionDemo {

    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        try {
            int c = a / b;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        System.out.println("a + b = " + (a + b));

    }
}
