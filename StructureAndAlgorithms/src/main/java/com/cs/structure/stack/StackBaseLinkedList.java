package com.cs.structure.stack;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/19 16:06
 * @description：基于链表的栈
 * @modified By：
 * @version: $
 */
public class StackBaseLinkedList<T> {

    public static void main(String[] args) {
        StackBaseLinkedList<Integer> stack = new StackBaseLinkedList<>();

        System.out.println("pop " + stack.pop());

        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.printAll();

        System.out.println("pop " + stack.pop());
        stack.printAll();

        System.out.println("pop " + stack.pop());
        stack.printAll();

        System.out.println("peek " + stack.peek());
    }

    //头结点
    private Node head;
    //数据长度
    private int length;

    public StackBaseLinkedList() {
        head = null;
        length = 0;
    }

    /**
     * 入栈
     *
     * @param data
     * @return
     */
    public boolean push(T data) {

        if (head == null) {
            head = new Node(data);
        } else {
            Node newHead = new Node(data, head);
            head = newHead;
        }
        length++;
        return true;
    }

    /**
     * 出栈
     *
     * @return
     */
    public T pop() {
        if (head == null) return null;

        Node<T> oldHead = head;
        head = oldHead.getNext();
        length--;
        return oldHead.getElement();
    }

    /**
     * 查看栈顶的数据(并不出栈)
     *
     * @return
     */
    public T peek() {
        if (head == null) return null;
        return (T) head.getElement();
    }

    public int getLength() {
        return length;
    }

    public void printAll() {

        Node p = head;
        while (p != null) {
            System.out.print(p.getElement() + ", ");
            p = p.getNext();
        }
        System.out.println("");
    }

}
