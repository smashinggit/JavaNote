package com.cs.base;

import java.util.*;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/11 14:32
 * @description：
 * @modified By：
 * @version: $
 * <p>
 * Map集合
 * 概述
 * 将键映射到值的对象
 * 一个映射不能包含重复的键
 * 每个键最多只能映射到一个值
 * <p>
 * Map集合存储元素是成对出现的，Map集合的键是唯一的，值是可重复的。可以把这个理解为：夫妻对
 * Collection集合存储元素是单独出现的，Collection的儿子Set是唯一的，List是可重复的。可以把这个理解为：光棍
 * 注意：
 * Map集合的数据结构值针对键有效，跟值无关
 * Collection集合的数据结构是针对元素有效
 * <p>
 * <p>
 * <p>
 * HashMap类概述
 * 键是哈希表结构，可以保证键的唯一性
 * <p>
 * <p>
 * LinkedHashMap
 * 概述
 * Map 接口的哈希表和链接列表实现，具有可预知的迭代顺序。
 * 由哈希表保证键的唯一性，不可重复
 * 由链表保证键盘的有序(存储和取出的顺序一致)
 * <p>
 * <p>
 * TreeMap
 * 概述
 * 键是红黑树结构，可以保证键的排序和唯一性
 * <p>
 * <p>
 * //HashMap:线程不安全，效率高。允许null键和null值
 * //Hashtable:线程安全，效率低。不允许null键和null值
 * <p>
 * Hashtable源码中有这么一段
 * Unlike the new collection implementations, {@code Hashtable} is synchronized.
 * If a thread-safe implementation is not needed, it is recommended to use
 * {@link HashMap} in place of {@code Hashtable}.  If a thread-safe
 * highly-concurrent implementation is desired, then it is recommended
 * to use {@link java.util.concurrent.ConcurrentHashMap} in place of
 * {@code Hashtable}
 * <p>
 * <p>
 * <p>
 * Collection和Collections的区别
 * Collection:是单列集合的顶层接口，有子接口List和Set。
 * Collections:是针对集合操作的工具类，有对集合进行排序和二分查找的方法
 */
public class MapDemo {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("邓超", "孙俪");
        map.put("黄晓明", "杨颖");
        map.put("周杰伦", "昆凌");
        map.put("刘恺威", "杨幂");
        System.out.println("map: " + map);
        System.out.println("map: " + map.put("马蓉", "王宝强")); //如果是此key是第一次添加,put方法返回的值是null
        System.out.println("map: " + map.put("马蓉", "宋喆"));//如果是此key已经存在,put方法返回的是被替换掉的值


        //HashMap:线程不安全，效率高。允许null键和null值
        //Hashtable:线程安全，效率低。不允许null键和null值
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("android", "hello");
        hashMap.put(null, "world");
        hashMap.put("java", null);
        System.out.println("hashMap: " + hashMap);

        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("android", "hello");
//        hashtable.put(null,"world");  //NullPointerException
//        hashtable.put("java",null);  //NullPointerException
        System.out.println("hashtable: " + hashtable);


        collectsTest();
    }

    private static void collectsTest() {
        List<Integer> list = new ArrayList<>();
        list.add(30);
        list.add(20);
        list.add(50);
        list.add(10);
        list.add(40);
        System.out.println("list:" + list);

        // public static <T> void sort(List<T> list)：排序 默认情况下是自然顺序。
        Collections.sort(list);
        System.out.println("自然顺序list:" + list);

        // public static <T> int binarySearch(List<?> list,T key):二分查找
        System.out.println("二分查找:" + Collections.binarySearch(list, 20));
        System.out.println("二分查找:" + Collections.binarySearch(list, 300)); //二分查找不存在的时候返回-6为什么呢。因为当二分查找不存在的时候，它就会返回最大索引+1再+1.

        // public static <T> T max(Collection<?> coll):最大值
        System.out.println("max:" + Collections.max(list));

        // public static void reverse(List<?> list):反转
        Collections.reverse(list);
        System.out.println("list:" + list);

        //public static void shuffle(List<?> list):随机置换
        Collections.shuffle(list);
        System.out.println("list:" + list);

    }
}
