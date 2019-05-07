package com.cs.structure.tree;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/30 9:14
 * @description：二叉树
 * @modified By：
 * @version: $
 * <p>
 * <p>
 * 二叉树既可以用链式存储，也可以用数组顺序存储
 * 数组顺序存储的方式比较适合完全二叉树，其他类型的二叉树用数组存储会比较浪费存储空间
 * <p>
 * 二叉树的遍历
 * 前序遍历
 * 对于树中的任意节点来说，先打印这个节点，然后再打印它的左子树，最后打印它的右子树。
 * 递推公式  preOrder(r) = print r -> preOrder(r->left) -> preOrder(r->right)
 * 中序遍历
 * 对于树中的任意节点来说，先打印它的左子树，然后再打印它本身，最后打印它的右子树。
 * 递推公式  inOrder(r) = inOrder(r->left) -> print r -> inOrder(r->right)
 * 后序遍历
 * 对于树中的任意节点来说，先打印它的左子树，然后再打印它的右子树，最后打印这个节点本身。
 * 递推公式  postOrder(r) = postOrder(r->left) -> postOrder(r->right) -> print r
 * <p>
 * 二叉树遍历的时间复杂度
 * 每个节点最多会被访问两次，所以遍历操作的时间复杂度，跟节点的个数 n 成正比，
 * 也就是说二叉树遍历的时间复杂度是 O(n)。
 */

public class BinaryTree {

    /**
     * 前序遍历
     *
     * @param root
     */
    public void preOrder(Node root) {
        if (root == null) {
            return;
        }

        root.print();
        preOrder(root.leftNode);
        preOrder(root.rightNode);
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.leftNode);
        root.print();
        inOrder(root.rightNode);
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    public void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.leftNode);
        postOrder(root.rightNode);
        root.print();
    }
}
