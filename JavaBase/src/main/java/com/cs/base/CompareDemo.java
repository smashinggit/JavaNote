package com.cs.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/11 15:18
 * @description：
 * @modified By：
 * @version: $
 * <p>
 * 1、如果实现类没有实现Comparable接口，又想对两个类进行比较（或者实现类实现了Comparable接口，
 * 但是对compareTo方法内的比较算法不满意），那么可以实现Comparator接口，自定义一个比较器，
 * 写比较算法
 * <p>
 * 2、实现Comparable接口的方式比实现Comparator接口的耦合性 要强一些，如果要修改比较算法，
 * 要修改Comparable接口的实现类，而实现Comparator的类是在外部进行比较的，不需要对实现类有任何修改。
 * 从这个角度说，其实有些不太好，尤其在我们将实现类的.class文件打成一个.jar文件提供给开发者使用的时候。
 * 实际上实现Comparator 接口的方式后面会写到就是一种典型的策略模式。
 */
public class CompareDemo {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(14);
        list.add(30);
        list.add(3);
        list.add(12);
        System.out.println("排序前 " + list);

        Collections.sort(list);
        System.out.println("排序后 " + list);


        List<Person> list2 = new ArrayList<>();
        list2.add(new Person("zhangsan", 15));
        list2.add(new Person("lisi", 30));
        list2.add(new Person("wangwu", 55));
        list2.add(new Person("jack", 10));
        list2.add(new Person("tony", 19));
        list2.add(new Person("zhangsan", 14));
        System.out.println("排序前 " + list2);

        Collections.sort(list2);
        System.out.println("排序后 " + list2);


        List<Person2> list3 = new ArrayList<>();
        list3.add(new Person2("zhangsan", 15));
        list3.add(new Person2("lisi", 30));
        list3.add(new Person2("wangwu", 55));
        list3.add(new Person2("jack", 10));
        list3.add(new Person2("tony", 19));
        list3.add(new Person2("zhangsan", 14));
        System.out.println("排序前 " + list3);


        Comparator<Person2> comparator = new Comparator<Person2>() {
            @Override
            public int compare(Person2 o1, Person2 o2) {
                //先比较姓名长度
                int result = o1.name.length() - o2.name.length();

                //如果姓名一样长，就按姓名的自然顺序排列
                int result2 = result == 0 ? o1.name.compareTo(o2.name) : result;

                //如果姓名一模一样，则比较年龄
                int result3 = result2 == 0 ? o1.age - o2.age : result2;

                return result3;
            }
        };
        Collections.sort(list3, comparator);
        System.out.println("排序后 " + list3);
    }
}

/**
 * Comparable接口
 * <p>
 * Lists (and arrays) of objects that implement this interface can be sorted
 * automatically by {@link Collections#sort(List) Collections.sort} (and
 * {@link Arrays#sort(Object[]) Arrays.sort}).  Objects that implement this
 * interface can be used as keys in a {@linkplain SortedMap sorted map} or as
 * elements in a {@linkplain SortedSet sorted set}, without the need to
 * specify a {@linkplain Comparator comparator}
 */
class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "{name=" + name + ", age=" + age + "}";
    }

    @Override
    public int compareTo(Person o) {
        //先比较姓名长度
        int result = this.name.length() - o.name.length();


        //如果姓名一样长，就按姓名的自然顺序排列
        int result2 = result == 0 ? this.name.compareTo(o.name) : result;

        //如果姓名一模一样，则比较年龄
        int result3 = result2 == 0 ? this.age - o.age : result2;

        return result3;
    }
}

class Person2 {
    String name;
    int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "{name=" + name + ", age=" + age + "}";
    }

}