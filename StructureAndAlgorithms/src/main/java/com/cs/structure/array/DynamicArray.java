package com.cs.structure.array;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/19 14:38
 * @description：支持动态扩容的数组
 * @modified By：
 * @version: $
 * <p>
 * 实现思路
 * 维护一个固定大小的数组
 * 往数组中添加数据的时候
 * 如数组未满，则直接添加
 * 如果数组已满，则根据扩容倍数新创建一个更大容量的数组，并将旧数组中的值拷贝过去
 */
public class DynamicArray<T> {

    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>(2);

        dynamicArray.add(0);
        dynamicArray.printAll();

        dynamicArray.add(1);
        dynamicArray.printAll();

        dynamicArray.add(2);  //数据满的时候自动扩容
        dynamicArray.printAll();

        dynamicArray.add(3);
        dynamicArray.printAll();

        dynamicArray.add(4);    //数据满的时候自动扩容
        dynamicArray.printAll();

        dynamicArray.add(5);
        dynamicArray.printAll();
    }


    //默认容量
    private final static int DEFAULT_CAPACITY = 10;
    //扩容倍数
    private final static int ENLARGEMENT_TIMES = 2;

    private T[] array;
    //数据长度
    private int length;
    //数据容量
    private int capacity;


    public DynamicArray() {
        this.capacity = DEFAULT_CAPACITY;
        this.array = (T[]) new Object[capacity];
        this.length = 0;
    }

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
        this.length = 0;
    }


    public void add(T data) {

        if (length == capacity) {  //数组已满，扩容
            capacity = capacity * ENLARGEMENT_TIMES;
            Object[] newArray = new Object[capacity];  //数组长度为旧数组的2倍
            for (int i = 0; i < length; i++) {    //拷贝旧数组的数据到新数组
                newArray[i] = array[i];
            }
            array = (T[]) newArray;
            System.out.println("自动扩容 当前数组容量为 " + capacity);
        }

        array[length] = data;
        length++;
    }

    private void printAll() {

        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

}
