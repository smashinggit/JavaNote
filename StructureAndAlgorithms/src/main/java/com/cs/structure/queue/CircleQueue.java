package com.cs.structure.queue;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/23 10:05
 * @description：基于数组实现循环队列
 * @modified By：
 * @version: $
 * <p>
 * <p>
 * 确定好队空和队满的判定条件
 * 队列为空的判断条件仍然是 head == tail
 * 当队满时，(tail+1)%n=head
 * <p>
 * 循环队列：队列满的表达式
 * 这里讲一下，这个表达式是怎么来的。在一般情况下，我们可以看出来，当队列满时，tail+1=head。
 * 但是，有个特殊情况，就是tail=n-1，而head=0时，这时候，tail+1=n，而head=0，
 * 所以用(tail+1)%n == n%n == 0。而且，tail+1最大的情况就是 n ，不会大于 n，
 * 这样，tail+1 除了最大情况，不然怎么余 n 都是 tail+1 本身，也就是 head。
 * 这样，表达式就出现了
 * <p>
 * 当队列满时，图中的 tail 指向的位置实际上是没有存储数据
 * 所以，循环队列会浪费一个数组的存储空间
 * <p>
 * 老师，循环队列的数组实现，在您的代码中，入队时会空留出一个位置，而且我感觉不太好理解。
 * 我定义一个记录队列大小的值size，当这个值与数组大小相等时，表示队列已满，当tail达到最底时，
 * size不等于数组大小时，tail就指向数组第一个位置。当出队时，size--，入队时size++
 * <p>
 * 很多同学都提到循环队列增加flag来避免浪费最后一个存储空间，那是不是flag本身也需要一个存储空间
 * 是的
 * <p>
 */
public class CircleQueue<T> {

    public static void main(String[] args) {
        CircleQueue<Integer> queue = new CircleQueue<>(5);

        System.out.println("队列为空时出队 " + queue.dequeue());

        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        //队列已满，无法入队
        System.out.println("队列已满，无法入队 queue.enqueue(5) " + queue.enqueue(5));
        queue.printAll();

        System.out.println("dequeue " + queue.dequeue());
        queue.printAll();

        System.out.println("dequeue " + queue.dequeue());
        queue.printAll();


        System.out.println("继续入队 100 200 300");
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        queue.printAll();

        System.out.println("dequeue " + queue.dequeue());
        queue.printAll();
    }


    private T[] array;
    private int head;
    private int tail;
    private int capacity;

    public CircleQueue(int capacity) {
        array = (T[]) new Object[capacity];
        this.capacity = capacity;
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

        //队列已满
        if ((tail + 1) % capacity == head) {
            return false;
        }

        array[tail] = data;
        tail = (tail + 1) % capacity;
        return true;
    }


    /**
     * 出队
     *
     * @return
     */
    public T dequeue() {
        //队列为空
        if (head == tail) {
            return null;
        }

        T result = array[head];
        head = (head + 1) % capacity;
        return result;
    }

    public void printAll() {

        for (int i = head; i % capacity != tail; i++) {
            System.out.print(array[i % capacity] + ", ");
        }
        System.out.println("");
    }
}
