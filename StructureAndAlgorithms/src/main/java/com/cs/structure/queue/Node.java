package com.cs.structure.queue;

/**
 * 单向链表的结点类
 *
 * @param <T>
 */
class Node<T> {

    private T element;
    private Node next;

    public Node() {
        this.next = null;
    }

    public Node(T element) {
        this.element = element;
    }

    public Node(T element, Node next) {
        this.element = element;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
