package com.cs.structure.linkedlist;

import java.util.Scanner;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/18 14:55
 * @description：基于单链表LRU缓存淘汰算法
 * @modified By：
 * @version: $
 * <p>
 * LRU缓存淘汰算法
 * 最近最少使用
 * <p>
 * 实现思路
 * 我们维护一个有序单链表，越靠近链表尾部的结点是越早之前访问的
 * 当有一个新的数据被访问时，我们从链表头开始顺序遍历链表
 * 1.如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来的位置删除，然后再插入到链表的头部
 * 2.如果此数据没有在缓存链表中，又可以分为两种情况：
 * 如果此时缓存未满，则将此结点直接插入到链表的头部
 * 如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部
 * <p>
 */
public class LRUBaseLinkedList<T> {

    public static void main(String[] args) {
        LRUBaseLinkedList<Integer> lruList = new LRUBaseLinkedList(5);
        System.out.println("请在键盘输入数字:");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            lruList.add(scanner.nextInt());
            lruList.printAll();
        }
    }


    // 默认链表容量
    private final static int DEFAULT_CAPACITY = 10;
    //头结点
    private Node<T> headNode;
    //链表容量
    private int capacity;
    //链表长度
    private int length;


    public LRUBaseLinkedList() {
        this.headNode = new Node<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(int capacity) {
        this.headNode = new Node<>();
        this.capacity = capacity;
        this.length = 0;
    }


    /**
     * 查找入参结点的前一个结点
     *
     * @param data
     * @return
     */
    private Node findPreNode(T data) {
        Node p = headNode;
//        while (p.getNext() != null) {
//            if (data.equals(p.getNext().getElement())) {
//                return p;
//            }
//            p = p.getNext();
//        }

        while (p.getNext() != null && !data.equals(p.getNext().getElement())) {
            p = p.getNext();
        }
        if (p.getNext() == null) return null; //空链表或者链表中不存在对应data
        return p;
    }

    /**
     * 向链表中添加数据
     *
     * @param data
     */
    public void add(T data) {
        Node preNode = findPreNode(data);

        if (preNode != null) {   // 链表中存在，删除原数据，再插入到链表的头部

            deleteElemOptim(preNode);
            insertElemAtBegin(data);

        } else {                // 链表中不存在

            if (length >= this.capacity) { //链表已满，删除尾结点
                deleteElemAtEnd();
            }
            insertElemAtBegin(data);
        }
    }

    /**
     * 删除preNode结点下一个元素
     *
     * @param preNode
     */
    private void deleteElemOptim(Node preNode) {
        Node temp = preNode.getNext();
        preNode.setNext(temp.getNext());

        temp = null;
        length--;
    }


    /**
     * 在链表头部插入结点
     *
     * @param data
     */
    private void insertElemAtBegin(T data) {
        Node next = headNode.getNext();
        headNode.setNext(new Node(data, next));
        length++;
    }


    /**
     * 删除尾结点
     */
    private void deleteElemAtEnd() {
        Node preNode = headNode;

        // 空链表直接返回
        if (preNode.getNext() == null)
            return;

        // preNode为倒数第二个结点
        while (preNode.getNext().getNext() != null)
            preNode = preNode.getNext();

        Node temp = preNode.getNext();
        temp = null;
        preNode.setNext(null);
        length--;
    }

    private void printAll() {
        Node node = headNode.getNext();
        while (node != null) {
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }
}



