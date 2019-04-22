package com.cs.base;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/8 11:25
 * @description：
 * @modified By：
 * @version: $
 * <p>
 * String类概述
 * <p>
 * 字符串是由多个字符组成的一串数据(字符序列)
 * 字符串可以看成是字符数组
 * 通过查看API，我们可以知道
 * <p>
 * 字符串字面值”abc”也可以看成是一个字符串对象。
 * 字符串是常量，一旦被赋值，就不能被改变
 * <p>
 * <p>
 * <p>
 * == 和 equals有什么区别呢
 * ==:
 * 基本类型：比较的就是值是否相同
 * 引用类型：比较的就是地址值是否相同
 * equals:
 * 引用类型：默认情况下，比较的是地址值。
 * 不过，我们可以根据情况自己重写该方法。一般重写都是自动生成，比较对象的成员变量值是否相同
 * <p>
 * <p>
 * 字符串内容为空 和 字符串对象为空。
 * String s = “”;
 * String s5 = null;
 * boolean isEmpty()：判断字符串是否为空
 * // s5对象都不存在，所以不能调用方法，空指针异常
 * //System.out.println("isEmpty:" + s5.isEmpty());
 * <p>
 * <p>
 * <p>
 * String,StringBuffer,StringBuilder的区别
 * String是内容不可变的，而StringBuffer,StringBuilder都是内容可变的。
 * StringBuffer是同步的，数据安全,效率低;StringBuilder是不同步的,数据不安全,效率高
 * <p>
 * <p>
 * <p>
 * StringBuffer和数组的区别?
 * 二者都可以看出是一个容器，装其他的数据。
 * 但是呢,StringBuffer的数据最终是一个字符串数据。
 * 而数组可以放置多种数据，但必须是同一种数据类型的。
 */
public class StringDemo {

    public static void main(String[] args) {


        String s1 = new String("hello");
        String s2 = "hello";

        //==:比较引用类型比较的是地址值是否相同
        //equals:比较引用类型默认也是比较地址值是否相同，
        //而String类重写了equals()方法，比较的是内容是否相同。
        System.out.println("s1 == s2 " + s1 == s2); //false
        System.out.println("s1.equals(s2) " + s1.equals(s2));//true

        String s3 = "hello";
        String s4 = "he" + new String("llo");
        System.out.println("s3 == s4 " + s3 == s4); //false
        System.out.println("s3.equals(s4) " + s3.equals(s4));//true


        Student student1 = new Student("jack", 18);
        Student student2 = new Student("jack", 18);
        Student student3 = student1;
        Student student4 = new Student("jack", 20);

        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());

        System.out.println(student1 == student2); //false
        System.out.println(student1.equals(student2));//true
        System.out.println(student1.equals(student1)); //true
        System.out.println(student1.equals(student3)); //true
        System.out.println(student1.equals(student4)); //false

        // 统计一个字符串中大写字母字符，小写字母字符，数字字符出现的次数。(不考虑其他字符)
        tongji();

        stringBuffer();
    }


    /**
     * 我们如果对字符串进行拼接操作，每次拼接，都会构建一个新的String对象，既耗时，又浪费空间。
     * 而StringBuffer就可以解决这个问题
     */
    private static void stringBuffer() {
        //A thread-safe, mutable sequence of characters
        StringBuffer sb = new StringBuffer();
        System.out.println("sb:" + sb);
        System.out.println("sb.capacity():" + sb.capacity()); //返回当前容量。 理论值(初始化默认容量是16)
        System.out.println("sb.length():" + sb.length()); //返回长度（字符数）。 实际值

        // public StringBuffer(int capacity):指定容量的字符串缓冲区对象
        StringBuffer sb2 = new StringBuffer(50);
        System.out.println("sb2:" + sb2);
        System.out.println("sb2.capacity():" + sb2.capacity());
        System.out.println("sb2.length():" + sb2.length());

        // public StringBuffer(String str):指定字符串内容的字符串缓冲区对象
        StringBuffer sb3 = new StringBuffer("hello");
        System.out.println("sb3:" + sb3);
        System.out.println("sb3.capacity():" + sb3.capacity());
        System.out.println("sb3.length():" + sb3.length());


        // String和StringBuffer的相互转换
        // 注意：不能把字符串的值直接赋值给StringBuffer

        // String 转换 StringBuffer
        String s = "hello";
        StringBuffer sb4 = new StringBuffer(s);   //方式1:通过构造方法
        StringBuffer sb5 = new StringBuffer();   // 方式2：通过append()方法
        sb5.append(s);

        // StringBuffer转换 String
        StringBuffer buffer = new StringBuffer("java");
        String str = new String(buffer);   // 方式1:通过构造方法
        String str2 = buffer.toString(); // 方式2：通过toString()方法
    }


    private static void tongji() {
        //定义一个字符串
        String s = "Hello123World";

        //定义三个统计变量
        int bigCount = 0;//大写字母
        int smallCount = 0;//小写字母
        int numberCount = 0;//数字

        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt >= 'a' && charAt <= 'z') {
                smallCount++;
            } else if (charAt >= 'A' && charAt <= 'Z') {
                bigCount++;
            } else if (charAt >= '0' && charAt <= '9') {
                numberCount++;
            }
        }
        System.out.println("大写字母" + bigCount + "个");
        System.out.println("小写字母" + smallCount + "个");
        System.out.println("数字" + numberCount + "个");
    }

}


class Student extends Object implements Comparable<Student> {

    String name;
    int age;


    public Student() {
        super();
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //重写此方法
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {

            if (this.name.equals(((Student) obj).name) && this.age == ((Student) obj).age)
                return true;
            else
                return false;
        } else
            return false;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }


    // 如果一个类的元素要想能够进行自然排序，就必须实现自然排序接口
    @Override
    public int compareTo(Student o) {
        // 主要条件 姓名的长度
        int num = this.name.length() - o.name.length();

        // 姓名的长度相同，不代表姓名的内容相同
        // 注意：this.name.compareTo(o.name)  这个compareTo是String类中的方法，
        int num2 = num == 0 ? this.name.compareTo(o.name) : num;

        // 姓名的长度和内容相同，不代表年龄相同，所以还得继续判断年龄
        int num3 = num2 == 0 ? this.age - o.age : num2;

        return num3;
    }
}
