package com.cs.structure.tree;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/30 9:28
 * @description：结点
 * @modified By：
 * @version: $
 */
public class Node<T> {

    T data;
    Node<T> leftNode;
    Node<T> rightNode;


    public Node(T data) {
        this.data = data;
        this. leftNode=null;
        this. rightNode=null;
    }

    public Node(T data, Node<T> leftNode, Node<T> rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    /**
     * 打印结点信息
     */
    public void print() {
    }
}
