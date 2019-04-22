package com.cs.structure.array;

import java.util.Scanner;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/19 11:07
 * @description：基于数组实现LRU算法
 * @modified By：
 * @version: $
 * 实现思路
 * 维护一个固定大小的数组，越靠近头部的元素是越近访问的
 * 1.当访问数据在缓存中，遍历数组将访问数据前的所有元素后移一位，并将访问数据放入头部
 * 2.当访问数据不在缓存中，
 * 如果缓存未满，遍历数组所有数据后移一位，并将访问数据放入头部
 * 如果缓存已满，先删除数据最后一个元素，然后把数组所有元素后移一位，最后将当前数据放入头部
 */
public class LRUBaseArray<T> {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请在键盘上输入数字:");

        LRUBaseArray<Integer> lruBaseArray = new LRUBaseArray<>(5);
        while (true) {

            lruBaseArray.add(scanner.nextInt());
            lruBaseArray.printAll();
        }
    }


    //默认容量
    private final static int DEFAULT_CAPACITY = 10;

    private T[] array;
    //数据长度
    private int length;
    //数据容量
    private int capacity;


    public LRUBaseArray() {
        this.capacity = DEFAULT_CAPACITY;
        array = (T[]) new Object[DEFAULT_CAPACITY];
        length = 0;
    }

    public LRUBaseArray(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
        length = 0;
    }


    public void add(T data) {

        int pos = findData(data);

        if (pos == -1) {  //不存在数组中

            if (length == capacity) { //数组已满

                for (int i = length - 1; i > 0; i--) {  //将数组内的所有数据后移一位
                    array[i] = array[i - 1];
                }
                array[0] = data;      //将访问元素置于数组头部

            } else {

                for (int i = length; i > 0; i--) {  //将数组内的所有数据后移一位
                    array[i] = array[i - 1];
                }
                array[0] = data;      //将访问元素置于数组头部
                length++;
            }

        } else {  //存在数组中

            for (int i = pos; i > 0; i--) {  //将pos位置前的所有数据后移一位
                array[i] = array[i - 1];
            }
            array[0] = data;      //将访问元素置于数组头部
        }
    }

    /**
     * 找到入参数据在数组中的位置，如果不在数组中返回-1
     *
     * @param data
     * @return
     */
    public int findData(T data) {

        for (int i = 0; i < length; i++) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    private void printAll() {

        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }
}
