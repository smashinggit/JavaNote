package com.cs.base;

import java.util.*;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/11 10:11
 * @description：
 * @modified By：
 * @version: $
 * <p>
 * Set
 * 元素是无序(存储顺序和取出顺序不一致),元素是唯一的，不可重复的
 * <p>
 * <p>
 * HashSet
 * 不保证 set 的迭代顺序
 * 特别是它不保证该顺序恒久不变。
 * <p>
 * HashSet如何保证元素唯一性
 * 底层数据结构是哈希表(元素是链表的数组)
 * 哈希表依赖于哈希值存储
 * 添加功能底层依赖两个方法：
 * int hashCode()
 * boolean equals(Object obj)
 * <p>
 * add方法
 * 步骤：
 * 首先比较哈希值
 * 如果相同，继续走，比较地址值或者走equals()
 * 如果不同,就直接添加到集合中
 * 按照方法的步骤来说：
 * 先看hashCode()值是否相同
 * 相同:继续走equals()方法
 * 返回true： 说明元素重复，就不添加
 * 返回false：说明元素不重复，就添加到集合
 * 不同：就直接把元素添加到集合
 * 如果类没有重写这两个方法，默认使用的Object()。一般来说不同相同。
 * 而String类重写了hashCode()和equals()方法，所以，它就可以把内容相同的字符串去掉。只留下一个
 * <p>
 * HashSet存储自定义对象，并保证元素的唯一性
 * 要在自定义类中重写hashCode()和equals()这两个方法
 * <p>
 * <p>
 * <p>
 * LinkedHashSet类
 * 底层数据结构由哈希表和链表组成
 * 由链表保证元素有序(存储和取出是一致)
 * 由哈希表保证元素唯一性
 * <p>
 * <p>
 * <p>
 * TreeSet类 底层数据结构是红黑树(红黑树是一种自平衡的二叉树)
 * 使用元素的自然顺序对元素进行排序
 * 或者根据创建 set 时提供的 Comparator 进行排序
 * 所以排序有两种方式
 * 自然排序
 * 比较器排序
 * 具体取决于使用的构造方法。
 * <p>
 */
public class SetDemo {


    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("java");
        set.add("java");
        set.add("web");
        set.add("android");

        //虽然Set集合的元素无序，但是，作为集合来说，它肯定有它自己的存储顺序，而你的顺序恰好和它的存储顺序一致，
        // 这代表不了有序，你可以多存储一些数据，就能看到效果
        for (String item : set) {
            System.out.println("item " + item);
        }

        Iterator<String> iterator = set.iterator();
//        while (iterator.hasNext()) {
//        }


        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("hello");
        hashSet.add("world");
        hashSet.add("world");

        for (String item : hashSet) {
            System.out.println("hashSet item " + item);
        }


/**
 * TreeSet集合保证元素排序和唯一性的原理
 * 唯一性：是根据比较的返回是否是0来决定。
 * 排序：
 * A:自然排序(元素具备比较性)
 * 让元素所属的类实现自然排序接口 Comparable
 * B:比较器排序(集合具备比较性)
 * 让集合的构造方法接收一个比较器接口的子类对象 Comparator
 */

        //自然排序
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(12);
        treeSet.add(38);
        treeSet.add(20);
        for (Integer item : treeSet) {
            System.out.println(item);  //元素已经自动排序 5 12 20 38
        }


        // 如果一个类的元素要想能够进行自然排序，就必须实现自然排序接口
        TreeSet<Student> treeSet2 = new TreeSet<>();
        Student s1 = new Student("朱婷", 22);
        Student s2 = new Student("惠若琪", 22);
        Student s3 = new Student("徐云丽", 21);
        Student s4 = new Student("朱婷婷", 22);
        Student s5 = new Student("郎平", 55);
        Student s6 = new Student("林丹", 34);
        Student s7 = new Student("李宗伟", 33);
        Student s8 = new Student("阿杜", 23);
        treeSet2.add(s1);
        treeSet2.add(s2);
        treeSet2.add(s3);
        treeSet2.add(s4);
        treeSet2.add(s5);
        treeSet2.add(s6);
        treeSet2.add(s7);
        treeSet2.add(s8);

        for (Student student : treeSet2) {
            System.out.println(student);  //元素根据Student类中的比较器排序
        }

        randomTest();

    }

    /**
     * 获取10个1至20的随机数，要求随机数不能重复。
     */
    private static void randomTest() {

        Random random = new Random();
//        HashSet<Integer> hashSet = new HashSet<>(); //没有自然排序
        TreeSet<Integer> treeSet = new TreeSet<>();

        while (treeSet.size() < 10) {
            int nextInt = random.nextInt(20);
            treeSet.add(nextInt);
        }

        for (Integer item : treeSet) {
            System.out.println("生产的随机数 " + item);
        }
    }

}
