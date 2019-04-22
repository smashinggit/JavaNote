package com.cs.structure.array;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/16 11:15
 * @description： 实现一个大小固定的数组，支持动态增删改操作
 * @modified By：
 * @version: $
 */
class Array<T> {

    private T[] data;
    //数据长度
    private int length;
    //数组容量
    private int capacity;

    //构造方法，定义数组大小
    public Array(int capacity) {
        this.data = (T[]) new Object[ capacity];
        this.length = capacity;
        this.capacity = 0;  //一开始一个数都没有存所以为0
    }

    //根据索引，找到数据中的元素并返回
    public T find(int index) {
        if (index < 0 || index >= capacity) return null;
        return data[index];
    }

    //插入元素:头部插入，尾部插入
    public boolean insert(int index, T value) {

        if (capacity == length) {
            System.out.println("数组已满，没有可插入的位置");
            return false;
        }

        // 如果count还没满，那么就可以插入数据到数组中
        // 位置不合法
        if (index < 0 || index > capacity) {   //注意：当index==count的时候，意思是在数组尾部插入一个数据，所以这里的判断是index > capacity
            System.out.println("位置不合法");
            return false;
        }

        // 位置合法
        //数组整体长度加1，从现有数组尾部到插入点index间的数据(包含尾部和index)整体向后移
        for (int i = capacity; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = value;
        capacity++;
        return true;
    }

    //根据索引，删除数组中的元素
    public boolean delete(int index) {

        if (index < 0 || index >= capacity) return false;

        //从删除位置开始，将后面的元素向前移动一位
        for (int i = index; i < capacity - 1; i++) {
            data[i] = data[i + 1];
        }
        capacity--;
        return true;
    }


    public void printAll() {
        for (int i = 0; i < capacity; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("");
    }

}
