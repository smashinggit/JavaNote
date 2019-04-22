package com.cs.structure.linkedlist;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/18 16:25
 * @description：单链表
 * @modified By：
 * @version: $
 * <p>
 * 实现的功能：
 * 1.插入头部
 * 2.插入尾部
 * 3.插入某个结点前
 * 4.插入某个结点后
 * 5.插入指定位置
 * 6.根据指定下标返回对应的结点
 * 7.获取某个结点的前/后结点
 * 8.删除头结点
 * 9.删除尾结点
 * 8.删除指定结点
 * 9.删除指定值的结点
 * 10.删除指定位置的结点
 * 11.获取链表长度
 * 12.清空链表
 */
public class SingleLinkedList<T> {

    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();

        Node<Integer> node = new Node<>(-100, null);
        list.insertToHead(0);
        System.out.println("insertToHead(0)");
        list.printAll();

        list.insertToHead(1);
        System.out.println("insertToHead(1)");
        list.printAll();

        list.insertToTail(5);
        System.out.println("insertToTail(5)");
        list.printAll();

        list.insert(node, 1); //插入到index为1的
        System.out.println("insert(node, 1)");
        list.printAll();

        list.insertAfter(node, -101);
        System.out.println("insertAfter(node, -101)");
        list.printAll();

        list.insertBefore(node, -99);
        System.out.println("insertBefore(node, -99)");
        list.printAll();

        Node byIndex = list.findByIndex(2);
        System.out.println("list.findByIndex(2) " + byIndex.getElement());

        list.deleteHead();
        System.out.println("deleteHead()");
        list.printAll();

        list.deleteTail();
        System.out.println("deleteTail()");
        list.printAll();

        list.deleteByIndex(2);
        System.out.println("deleteByIndex(2)");
        list.printAll();

        list.deleteByNode(node);
        System.out.println("deleteByNode(node)");
        list.printAll();


        list.deleteByValue(-99);
        System.out.println("deleteByValue(-99)");
        list.printAll();
    }


    //头结点
    private Node headNode;
    //链表长度
    private int length;

    public SingleLinkedList() {
        headNode = null;
        length = 0;
    }

    /**
     * 链表头部插入一个结点
     *
     * @param value
     */
    public void insertToHead(T value) {
        insertToHead(new Node(value, null));
    }

    /**
     * 链表头部插入一个结点
     *
     * @param newNode
     */
    public void insertToHead(Node newNode) {
        if (headNode == null) {
            headNode = newNode;
        } else {
            newNode.setNext(headNode);
            headNode = newNode;
        }
        length++;
    }

    /**
     * 链表尾部插入一个结点
     *
     * @param value
     */
    public void insertToTail(T value) {
        Node newNode = new Node(value, null);
        insertToTail(newNode);
    }

    /**
     * 链表尾部插入一个结点
     *
     * @param newNode
     */
    public void insertToTail(Node newNode) {
        //空链表，可以插入新节点作为head，也可以不操作
        if (headNode == null) {
            insertToHead(newNode);
        } else {
            Node p = headNode;
            while (p.getNext() != null) {  //找到尾结点
                p = p.getNext();
            }
            newNode.setNext(p.getNext()); //因为p为尾结点，所以p.getNext()即为null
            p.setNext(newNode);
        }
        length++;
    }

    /**
     * 在指定结点node后插入一个新结点
     *
     * @param node
     * @param value
     */
    public void insertAfter(Node node, T value) {
        Node newNode = new Node(value, null);
        insertAfter(node, newNode);
    }

    /**
     * 在指定结点node后插入一个新结点
     *
     * @param node
     * @param newNode
     */
    public void insertAfter(Node node, Node newNode) {
        if (node == null) return;

        newNode.setNext(node.getNext());
        node.setNext(newNode);
        length++;
    }

    /**
     * 在指定结点node前插入一个新结点
     *
     * @param node
     * @param value
     */
    public void insertBefore(Node node, T value) {
        Node newNode = new Node(value, null);
        insertBefore(node, newNode);
    }

    /**
     * 在指定结点node前插入一个新结点
     *
     * @param node
     * @param newNode
     */
    public void insertBefore(Node node, Node newNode) {
        if (node == null) return;

        if (headNode == node) {
            insertToHead(newNode);
            return;
        }

        Node p = headNode;
        while (p != null && p.getNext() != node) {  //找到指定结点node的前结点
            p = p.getNext();
        }

        if (p == null) return;  //链表为空或者不包含指定的node结点

        newNode.setNext(node);
        p.setNext(newNode);
        length++;
    }

    /**
     * 插入指定位置
     *
     * @param newNode
     * @param index
     */
    public boolean insert(Node newNode, int index) {

        if (index < 0 || index > length) return false;
        if (newNode == null) return false;

        if (index == 0)
            insertToHead(newNode);
        else if (index == length)
            insertToTail(newNode);
        else {

            Node p = headNode;
            int pos = 0;
            while (p != null && pos != (index - 1)) {  //找到指定index上的前结点
                p = p.getNext();
                pos++;
            }

            newNode.setNext(p.getNext());
            p.setNext(newNode);
        }
        length++;
        return true;
    }

    /**
     * @param value
     * @return 根据指定值返回结点.若链表为空或者没有指定值，返回null
     */
    public Node findByValue(T value) {

        Node p = headNode;

        while (p != null && !value.equals(p.getElement())) {  //找到指定值的结点
            p = p.getNext();
        }
        return p;
    }

    /**
     * 根据指定下标返回对应的结点
     *
     * @param index
     * @return 下标小于0或者超出链表长度，返回null
     */
    public Node findByIndex(int index) {

        if (index < 0) return null;

        Node p = headNode;
        int position = 0;
        while (p != null && position != index) { //找到指定位置index对应的结点
            p = p.getNext();
            position++;
        }
        return p;
    }

    /**
     * 删除头结点
     */
    public void deleteHead() {
        headNode = headNode.getNext();
        length--;
    }

    /**
     * 删除尾结点
     */
    public void deleteTail() {

        Node p = headNode;
        Node pPre = null; //尾结点的前结点

        while (p != null && p.getNext() != null) {
            pPre = p;
            p = p.getNext();
        }
        pPre.setNext(null);
        length--;
    }

    /**
     * 删除指定结点
     *
     * @param node
     */
    public void deleteByNode(Node node) {

        if (node == null || headNode == null) return;

        if (node == headNode) {
            deleteHead();
            return;
        }

        Node q = headNode;
        while (q != null && q.getNext() != node) {  //找到指定结点的前结点
            q = q.getNext();
        }

        if (q == null) return;   //链表中不包含指定的node结点

        q.setNext(q.getNext().getNext());
        length--;
    }

    /**
     * 删除指定值的结点
     *
     * @param value
     */
    public boolean deleteByValue(T value) {

        if (headNode == null) return false;

        Node p = headNode;
        Node pPre = null;

        while (p != null && !p.getElement().equals(value)) { //找到指定值结点,即p,  preNode为p的前结点
            pPre = p;
            p = p.getNext();
        }

        if (p == null) return false;  //链表中不包含指定值的结点

        if (pPre == null) { //pPre == null说明要删除的结点为头结点
            deleteHead();
        } else {
            pPre.setNext(pPre.getNext().getNext());
        }
        length--;
        return true;
    }

    /**
     * 删除指定位置的结点
     *
     * @param index
     */
    public boolean deleteByIndex(int index) {
        if (index < 0 || index >= length) return false;
        if (length == 0) return false;

        if (index == 0) {
            deleteHead();
        } else {
            Node p = headNode;
            int pos = 0;
            while (p != null && pos != (index - 1)) {
                p = p.getNext();
                pos++;
            }

            p.setNext(p.getNext().getNext());
        }
        length--;
        return true;
    }

    /**
     * 获取链表长度
     *
     * @return
     */
    public int getSize() {
        return length;
    }

    public void clear() {
        headNode = null;
        length = 0;
    }


    public void printAll() {
        Node p = headNode;
        while (p != null) {
            System.out.print(p.getElement() + " ");
            p = p.getNext();
        }
        System.out.println();
    }

}
