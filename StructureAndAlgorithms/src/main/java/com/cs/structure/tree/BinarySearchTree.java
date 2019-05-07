package com.cs.structure.tree;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/30 9:58
 * @description：二叉查找树
 * @modified By：
 * @version: $
 * 二叉查找树要求，在树中的任意一个节点，
 * 其左子树中的每个节点的值，都要小于这个节点的值，
 * 而右子树节点的值都大于这个节点的值
 */
public class BinarySearchTree {


    public static void main(String[] args) {

    }


    private Node<Integer> tree;


    /**
     * 二叉查找树的查找操作
     *
     * @param data
     * @return
     */
    public Node<Integer> find(int data) {
        Node<Integer> p = tree;
        while (p != null) {
            if (data < p.data) {
                p = p.leftNode;
            } else if (data > p.data) {
                p = p.rightNode;
            } else {
                return p;
            }
        }
        return null;
    }

    /**
     * @param data
     */
    public void insert(int data) {
        if (tree == null) {
            tree = new Node<>(data);
            return;
        }

        Node<Integer> p = tree;

        while (p != null) {
            if (data > p.data) {
                if (p.rightNode == null) {
                    p.rightNode = new Node<>(data);
                    return;
                }
                p = p.rightNode;
            } else {
                if (p.leftNode == null) {
                    p.leftNode = new Node<>(data);
                    return;
                }
                p = p.leftNode;
            }
        }
    }

    /**
     * @param data
     */
    public void delete(int data) {
        //p 指向要删除的节点，初始化指向根节点
        Node<Integer> p = tree;
        //pp记录的是p的父节点
        Node pp = null;

        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.rightNode;
            } else {
                p = p.leftNode;
            }
        }

        // 没有找到
        if (p == null) {
            return;
        }

        //要删除的节点有两个子节点
        //
        if (p.leftNode != null && p.rightNode != null) {
            //查找右子树中最小节点
            Node<Integer> minP = p.rightNode;
            // minPP 表示 minP 的父节点
            Node minPP = p;
            while (minP.leftNode != null) {
                minPP = minP;
                minP = minP.leftNode;
            }
            // 将minP的数据替换到p中
            p.data = minP.data;
            // 下面就变成了删除minP了
            p = minP;
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        // p的子节点
        Node child;
        if (p.leftNode != null) {
            child = p.leftNode;
        } else if (p.rightNode != null) {
            child = p.rightNode;
        } else {
            child = null;
        }

        if (pp == null) {
            tree = child;
        } // 删除的是根节点
        else if (pp.leftNode == p) {
            pp.leftNode = child;
        } else {
            pp.rightNode = child;
        }
    }

}
