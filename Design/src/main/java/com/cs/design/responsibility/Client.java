package com.cs.design.responsibility;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 11:13
 * @description：责任链模式
 * @modified By：
 * @version: $
 * <p>
 * 使多个对象都有机会处理请求，从而避免了请求的发送者和接受者之间的耦合关
 * 系。将这些对象连成一条链，并沿着这条链传递该请求，直到有对象处理它为止
 */
public class Client {

    public static void main(String[] args) {

        Father father = new Father();
        Husband husband = new Husband();
        Son son = new Son();

        father.setNext(husband);
        husband.setNext(son);

        IWomen women = new Women(Handler.HUSBAND_LEVEL_REQUEST, "逛街");

        father.handleMessage(women);
    }
}
