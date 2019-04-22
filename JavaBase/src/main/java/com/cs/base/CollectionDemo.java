package com.cs.base;

import java.util.*;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/10 16:21
 * @description：
 * @modified By：
 * @version: $
 * <p>
 * List接口概述
 * 有序的 collection（也称为序列）。此接口的用户可以对列表中每个元素的插入位置进行精确地控制。
 * 用户可以根据元素的整数索引（在列表中的位置）访问元素，并搜索列表中的元素。
 * 与 set 不同，列表通常允许重复的元素。
 * <p>
 * <p>
 * <p>
 * List和Set的区别很明显
 * List接口：元素是有序的，元素可以重复，因为该集合体系有索引
 * Set接口：元素是无序，元素不可以重复，不能索引
 * <p>
 * <p>
 * <p>
 * List的三个子类
 * ArrayList:
 * 底层数据结构是数组，查询快，增删慢。
 * 线程不安全，效率高。
 * Vector:
 * 底层数据结构是数组，查询快，增删慢。
 * 线程安全，效率低。
 * LinkedList:
 * 底层数据结构是链表，查询慢，增删快。
 * 线程不安全，效率高
 * <p>
 * Vector是线程安全的集合类，ArrayList并不是线程安全的类。Vector类对集合的元素操作时都加了synchronized，保证线程安全。
 * Vector与ArrayList本质上都是一个Object[] 数组，ArrayList提供了size属性，Vector提供了elementCount属性，
 * 他们的作用是记录集合内有效元素的个数。与我们平常调用的arrayList.size()和vector.size()一样返回的集合内有效元素的个数。
 * Vector与ArrayList的扩容并不一样，Vector默认扩容是增长一倍的容量，Arraylist是增长50%的容量。
 * Vector与ArrayList的remove,add(index,obj)方法都会导致内部数组进行数据拷贝的操作，这样在大数据量时，可能会影响效率。
 * Vector与ArrayList的add(obj)方法，如果新增的有效元素个数超过数组本身的长度，都会导致数组进行扩容。
 */
public class CollectionDemo {

    public static void main(String[] args) {
        //List接口
        List list = new ArrayList();
        list.add("hello");
        list.add("world");
        list.add("java");

        Iterator iterator1 = list.iterator();
        ListIterator listIterator = list.listIterator();

        //判断里面有没有”world”这个元素，如果有，我就添加一个”javaee”元素，请写代码实现
        //这样写会报错
        //迭代器是依赖于集合而存在的，在判断成功后，集合的中新添加了元素，而迭代器却不知道，所以就报错了，这个错叫并发修改异常
        //迭代器遍历元素的时候，通过集合是不能修改元素的

//        while (iterator1.hasNext()) {
//            String s = (String) iterator1.next();
//            if (s.equals("world")) {
//                list.add("javaee"); //Exception in thread "main" java.util.ConcurrentModificationException
//            }
//        }

        // 方式1：迭代器迭代元素，迭代器修改元素
        // 而Iterator迭代器却没有添加功能，所以我们使用其子接口ListIterator
        while (listIterator.hasNext()) {
            String s = (String) listIterator.next();
            if ("world".equals(s)) {
                listIterator.add("javaee");  //注意，是listIterator添加元素，
            }
        }
        System.out.println("使用ListIterator迭代器后得到的结果:" + list);

        // 方式2：集合遍历元素，集合修改元素(普通for)
        for (int x = 0; x < list.size(); x++) {
            String s = (String) list.get(x);
            if ("world".equals(s)) {
                list.add("javaee");
            }
        }
        System.out.println("使用集合遍历后得到的结果:" + list);


        Vector vector = new Vector();
        vector.addElement("java");  //线程安全的
        vector.addElement("web");
        vector.addElement("android");
        Iterator iterator = vector.iterator();


        LinkedList linkedList = new LinkedList();
        linkedList.add("java");
        linkedList.add("web");
        linkedList.add("android");

        linkedList.addFirst("haha");
        linkedList.removeFirst();

        linkedList.getFirst();
        linkedList.getLast();

        arrayListTest();
        linkedListTest();
    }


    private static void linkedListTest() {
        MyTask task = new MyTask();
        task.add("hello");
        task.add("world");
        task.add("java");

        while (!task.isEmpty()) {
            System.out.println("MyTask " + task.get());
        }
    }

    private static void arrayListTest() {

        ArrayList array = new ArrayList();
        array.add("hello");
        array.add("world");
        array.add("java");
        array.add("world");
        array.add("java");
        array.add("world");
        array.add("world");
        array.add("world");
        array.add("world");
        array.add("java");
        array.add("world");

//        // 创建新集合
//        ArrayList newArray = new ArrayList();
//
//        // 遍历旧集合,获取得到每一个元素
//        Iterator it = array.iterator();
//        while (it.hasNext()) {
//            String s = (String) it.next();
//            if (!newArray.contains(s)) {   // 拿这个元素到新集合去找，看有没有
//                newArray.add(s);
//            }
//        }


        //假如我们的需求是：不能创建新的集合，就在以前的集合上做修改
        // 由选择排序思想引入，我们就可以通过这种思想做这个题目
        // 拿0索引的依次和后面的比较，有就把后的干掉
        // 同理，拿1索引...
        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = i + 1; j < array.size(); j++) {

                if (array.get(i).equals(array.get(j))) {
                    array.remove(j);
                    j--;
                }

            }
        }

        // 遍历集合
        Iterator it = array.iterator();
        while (it.hasNext()) {
            String s = (String) it.next();
            System.out.println(s);
        }

    }
}

/**
 * 自定义的栈集合
 */

class MyTask {
    LinkedList linkedList;

    public MyTask() {
        linkedList = new LinkedList();
    }

    public void add(Object obj) {
        linkedList.addFirst(obj);
    }

    public Object get() {
        return linkedList.removeFirst();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

}
