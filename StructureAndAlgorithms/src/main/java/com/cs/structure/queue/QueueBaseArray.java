package com.cs.structure.queue;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/19 16:59
 * @description：基于数组实现顺序队列
 * @modified By：
 * @version: $
 * <p>
 * 队列需要两个指针
 * 一个是 head 指针，指向队头(实际上，指向队列头一个数据)
 * 一个是 tail 指针，指向队尾(实际上，指向队列末尾的下一个位置)
 */
public class QueueBaseArray<T> {


    public static void main(String[] args) {
        QueueBaseArray<Integer> queue = new QueueBaseArray<>(5);

        System.out.println("队列为空时出队 " + queue.dequeue());

        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        //队列已满，无法入队
        queue.enqueue(5);
        queue.printAll();

        System.out.println("dequeue " + queue.dequeue());
        queue.printAll();

        System.out.println("dequeue " + queue.dequeue());
        queue.printAll();


        System.out.println("继续入队");
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        queue.printAll();

        System.out.println("dequeue " + queue.dequeue());
        queue.printAll();
    }


    private T[] array;
    /**
     * 数据长度
     */
    private int length;
    /**
     * 数组容量
     */
    private int capacity;
    /**
     * 头指针
     */
    private int head;
    /**
     * 尾指针
     */
    private int tail;


    public QueueBaseArray(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
        this.length = 0;
        this.head = 0;
        this.tail = 0;
    }


    /**
     * 入队
     *
     * @param data
     * @return
     */
    public boolean enqueue(T data) {

        //标识队列末尾没有空间了
        if (tail == capacity) {

            // tail ==n && head==0，表示队列已满
            if (head == 0) {
                return false;
            }

            //队尾没有空间了，进行一次数据搬移
            for (int i = 0; i < tail - head; i++) {
                array[i] = array[head + i];
            }
            tail = tail - head;
            head = 0;
        }

        array[tail] = data;
        tail++;
        length++;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public T dequeue() {
        //空队列
        if (head == tail) {
            return null;
        }

        T headData = array[head];
        head++;
        length--;
        return headData;
    }

    public void printAll() {

        for (int i = head; i < tail; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("");
    }

}
