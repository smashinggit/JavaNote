package com.cs.design.memento;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/7 9:35
 * @description：备忘录模式（Memento Pattern
 * @modified By：
 * @version: $
 *
 * 在不破坏封装性的前提下，捕获一个对象的内部状
 * 态，并在该对象之外保存这个状态。这样以后就可将该对象恢复到原先保存的状态
 */
public class Client {

    public static void main(String[] args) {
        Boy boy = new Boy();
        Caretaker caretaker = new Caretaker();

        boy.setState("心情棒棒哒");
        System.out.println("=====男孩现在的状态======");
        System.out.println(boy.getState());

        //需要记录下当前状态呀
        caretaker.setMemento(boy.createMemento());

        //男孩去追女孩，状态改变
        boy.changeState();
        System.out.println("\n=====男孩追女孩子后的状态======");
        System.out.println(boy.getState());

        //追女孩失败，恢复原状
        boy.restoreMemento(caretaker.getMemento());
        System.out.println("\n=====男孩恢复后的状态======");
        System.out.println(boy.getState());
    }
}
