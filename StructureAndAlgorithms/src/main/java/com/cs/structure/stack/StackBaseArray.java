package com.cs.structure.stack;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/19 15:27
 * @description：基于数组实现的栈
 * @modified By：
 * @version: $
 */
public class StackBaseArray<T> {


    public static void main(String[] args) {
        StackBaseArray<Integer> stack = new StackBaseArray<>(5);

        System.out.println("pop " + stack.pop());

        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);//栈已满，入栈失败
        stack.printAll();

        System.out.println("pop " + stack.pop());
        stack.printAll();

        System.out.println("pop " + stack.pop());
        stack.printAll();

        System.out.println("peek " + stack.peek());
    }


    private T[] array;
    //数据长度
    private int length;
    //数组容量
    private int capacity;

    //构造方法，定义数组大小
    public StackBaseArray(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.length = 0;
        this.capacity = capacity;
    }

    /**
     * 入栈
     *
     * @param data
     * @return
     */
    public boolean push(T data) {

        if (length == capacity)  //数组已满
            return false;

        for (int i = length; i > 0; i--) {  //数组整体后移一位
            array[i] = array[i - 1];
        }

        array[0] = data;
        length++;
        return true;
    }

    /**
     * 出栈
     *
     * @return
     */
    public T pop() {
        if (length == 0)
            return null;

        T top = array[0];
        for (int i = 0; i < length - 1; i++) {  //数据整体前移一位
            array[i] = array[i + 1];
        }
        length--;
        return top;
    }

    /**
     * 查看栈顶的数据(并不出栈)
     *
     * @return
     */
    public T peek() {
        if (length == 0)
            return null;

        return array[0];
    }

    public int getLength() {
        return length;
    }

    public void printAll() {

        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("");
    }
}
