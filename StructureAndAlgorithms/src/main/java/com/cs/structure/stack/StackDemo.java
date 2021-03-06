package com.cs.structure.stack;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/19 15:19
 * @description：
 * @modified By：
 * @version: $
 * <p>
 * 栈是一种“操作受限”的线性表，只允许在一端插入和删除数据
 * 后进者先出，先进者后出，这就是典型的“栈”结构
 * 栈主要包含两个操作，入栈和出栈
 * <p>
 * 为什么要使用栈？
 * 从功能上来说，数组或链表确实可以替代栈，但你要知道，特定的数据结构是对特定场景的抽象
 * 而且，数组或链表暴露了太多的操作接口，操作上的确灵活自由，但使用时就比较不可控，自然也就更容易出错。
 * <p>
 * 如何实现一个栈？
 * 栈既可以用数组来实现，也可以用链表来实现
 * 用数组实现的栈，我们叫作顺序栈
 * 用链表实现的栈，我们叫作链式栈
 * <p>
 * 复杂度
 * 管是顺序栈还是链式栈，我们存储数据只需要一个大小为 n 的数组就行了
 * 在入栈和出栈过程中，只需要一两个临时变量存储空间
 * 所以空间复杂度是O(1)
 * 不管是顺序栈还是链式栈，入栈、出栈只涉及栈顶个别数据的操作
 * 所以时间复杂度都是 O(1)
 */
public class StackDemo {
}
