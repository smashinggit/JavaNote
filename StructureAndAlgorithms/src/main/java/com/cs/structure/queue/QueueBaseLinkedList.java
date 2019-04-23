package com.cs.structure.queue;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/23 8:58
 * @description：基于链表实现的队列
 * @modified By：
 * @version: $
 */
public class QueueBaseLinkedList<T> {


    public static void main(String[] args) {
        QueueBaseLinkedList queue = new QueueBaseLinkedList<Integer>(5);

        System.out.println("空队列时出队 " + queue.dequeue());

        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        //队列已满，无法入队
        System.out.println("队列已满，无法入队 queue.enqueue(5) " + queue.enqueue(5));
        queue.printAll();

        System.out.println("dequeue " + queue.dequeue().getElement());
        queue.printAll();

        System.out.println("dequeue " + queue.dequeue().getElement());
        queue.printAll();


        System.out.println("继续入队");
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        queue.printAll();

        System.out.println("dequeue " + queue.dequeue().getElement());
        queue.printAll();

    }


    /**
     * 头指针
     */
    private Node head;
    /**
     * 尾指针
     */
    private Node tail;
    /**
     * 长度
     */
    private int length;
    /**
     * 容量
     */
    private int capacity;


    public QueueBaseLinkedList() {

        head = null;
        tail = null;
        length = 0;
        capacity = Integer.MAX_VALUE;
    }

    public QueueBaseLinkedList(int capacity) {
        head = null;
        tail = null;
        length = 0;
        this.capacity = capacity;
    }

    /**
     * 入队
     *
     * @param data
     * @return
     */
    public boolean enqueue(T data) {

        Node newNode = new Node(data);

        //队列已满
        if (length >= capacity) {
            return false;
        }

        //空队列
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        length++;

        return true;
    }


    /**
     * 出队
     *
     * @return
     */
    public Node<T> dequeue() {
        Node node = head;

        if (node != null) {
            head = head.getNext();
            length--;
            return node;
        }
        return null;
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

