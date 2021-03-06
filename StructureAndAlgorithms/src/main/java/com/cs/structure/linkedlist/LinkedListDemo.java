package com.cs.structure.linkedlist;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/18 10:39
 * @description： 链表
 * @modified By：
 * @version: $
 * <p>
 * 常见的缓存淘汰策略
 * 先进先出策略 FIFO（First In，First Out)
 * 最少使用策略 LFU（Least Frequently Used)
 * 最近最少使用策略 LRU（Least Recently Used）
 * <p>
 * 数组和链表的区别
 * 底层的存储结构：
 * 数组需要一块连续的内存空间，对于内存空间要求比较高
 * 而链表恰恰相反，它并不需要一块连续的内存空间，它通过“指针”将一组零散的内存块串联起来使用
 * <p>
 * 常见的链表
 * 单链表
 * 双向链表
 * 循环链表
 * <p>
 * 链表通过指针将一组零散的内存块串联在一起。其中，我们把内存块称为链表的“结点”
 * 为了将所有的结点串起来，每个链表的结点除了存储数据之外，还需要记录链上的下一个结点的地址
 * <p>
 * “数组简单易用，在实现上使用的是连续的内存空间，可以借助 CPU 的缓存机制，预读数组中的数据，
 * 所以访问效率更高。而链表在内存中并不是连续存储，所以对 CPU 缓存不友好，没办法有效预读。”
 * 这里的CPU缓存机制指的是什么？为什么就数组更好了？
 * CPU在从内存读取数据的时候，会先把读取到的数据加载到CPU的缓存中。而CPU每次从内存读取数据并不是只读取
 * 那个特定要访问的地址，而是读取一个数据块(这个大小我不太确定。。)并保存到CPU缓存中，然后下次访问内存
 * 数据的时候就会先从CPU缓存开始查找，如果找到就不需要再从内存中取。这样就实现了比内存访问速度更快的机制，
 * 也就是CPU缓存存在的意义:为了弥补内存访问速度过慢与CPU执行速度快之间的差异而引入
 * 对于数组来说，存储空间是连续的，所以在加载某个下标的时候可以把以后的几个下标元素也加载到CPU缓存这样执
 * 行速度会快于存储空间不连续的链表存储
 */
public class LinkedListDemo {
    public static void main(String[] args) {

    }
}
