package com.cs.base;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/15 16:34
 * @description：
 * @modified By：
 * @version: $
 * <p>
 * volatie 用于修饰变量，它有两个作用
 * 它可以保证变量在多线程之间是可见的，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。
 * 禁止指令重排序。
 * <p>
 * 什么是原子性操作？
 * 原子性：即一个操作或者多个操作 要么全部执行并且执行的过程不会被任何因素打断，要么就都不执行。
 * 对于共享资源一步或者多步的操作是不会被中断执行的，这种操作过程就是原子性操作，
 * 比如从账户A向账户B转1000元，那么必然包括2个操作：从账户A减去1000元，往账户B加上1000元。
 * 将整个操作视为一个整体，这是原子性操作的核心特征。
 * volatile 是不能保证多线程对共享资源操作的原子性的
 * 在Java中,对基本数据类型的变量的读取和赋值操作是原子性操作，即这些操作是不可被中断的，要么执行，要么不执行
 * x = 10;         //语句1
 * y = x;         //语句2
 * x++;           //语句3
 * x = x + 1;     //语句4
 * 其实只有语句1是原子性操作，其他三个语句都不是原子性操作
 * <p>
 * Java内存模型只保证了基本读取和赋值是原子性操作，如果要实现更大范围操作的原子性，
 * 可以通过synchronized和Lock来实现。由于synchronized和Lock能够保证任一时刻只有一个线程执行该代码块，
 * 那么自然就不存在原子性问题了，从而保证了原子性
 * <p>
 * 可见性
 * 可见性是指当多个线程访问同一个变量时，一个线程修改了这个变量的值，其他线程能够立即看得到修改的值。
 * 当一个共享变量被volatile修饰时，它会保证修改的值会立即被更新到主存，
 * 当有其他线程需要读取时，它会去内存中读取新值。
 * <p>
 * 有序性
 * 即程序执行的顺序按照代码的先后顺序执行
 * 一般来说，处理器为了提高程序运行效率，可能会对输入代码进行优化，
 * 它不保证程序中各个语句的执行先后顺序同代码中的顺序一致，但是它会保证程序最终执行结果和代码顺序执行的结果是一致的
 * 指令重排序不会影响单个线程的执行，但是会影响到线程并发执行的正确性
 * 要想并发程序正确地执行，必须要保证原子性、可见性以及有序性。
 * 只要有一个没有被保证，就有可能会导致程序运行不正确
 * <p>
 * personCount++ 在内存中的操作过程如下：
 * 线程person1 读取了 personCount 的值0，这时线程person1工作内存就保存了 personCount 的值为 0。
 * 这时 CPU 的执行权被 线程person2 抢走了，这时 线程person1 就阻塞了。
 * 线程person2读取主存中的 personCount 此时值为 0，因为 线程person1 只是读取了personCount，
 * 并没有修改这个值，因此不会导致 线程person2 中的缓存失效，然后线程person2 对 personCount
 * 进行累加然后写入到主存的值为1中。
 * 到了 线程person1 执行时，由于在第一步中已经将 personCount 读取到本地内存中，因此不会再去主存中读取了，
 * 这时进行累加得到值是 personCount 的值为 1。
 * 此时 线程person1和线程person2操作得到的值都是1，这就出现了线程安全问题
 * <p>
 * <p>
 * 使用volatile关键字的场景
 * synchronized关键字是防止多个线程同时执行一段代码，那么就会很影响程序执行效率，
 * 而volatile关键字在某些情况下性能要优于synchronized，但是要注意volatile关键字是无法
 * 替代synchronized关键字的，因为volatile关键字无法保证操作的原子性
 * 使用volatile必须具备以下2个条件
 * 1）对变量的写操作不依赖于当前值
 * 2）该变量没有包含在具有其他变量的不变式中
 */
public class ThreadDemo5 {

    public static void main(String[] args) throws InterruptedException {

//        TestThread thread = new TestThread();
//        thread.start();
//
//        Thread.sleep(3000);
//        thread.setNum(-1);
        TestThread2 testThread2 = new TestThread2();
        Thread thread1 = new Thread(testThread2);
        Thread thread2 = new Thread(testThread2);

        thread1.start();
        thread2.start();
    }
}

//验证 volatile 不能保证原子性操作
class TestThread2 implements Runnable {
    private volatile int personCount = 0;

    @Override
    public void run() {

        for (int i = 0; i < 5000; i++) {
            personCount++;
        }
        //它的执行结果是会是 10000 吗？
        //答案是不一定会是10000。因为在多个线程下对personCount进行累加操作。
        // 而 personCount++ 它并不是一个原子性操作，因此在多线程环境下，就会出现数据错误问题
        //　这里面就有一个误区了，volatile关键字能保证可见性没有错，但是上面的程序错在没能保证原子性。
        // 可见性只能保证每次读取的是最新的值，但是volatile没办法保证对变量的操作的原子性
        System.out.println(Thread.currentThread().getName() + "-人数：" + personCount);
    }
}

class TestThread extends Thread {
    //volatile 能保证变量被一个线程2修改后，会立即将数据写入到主存中，
    // 并且线程1中缓存的变量无效，这样线程1去读取这个变量时就能得到一个最新的值。
    private volatile int num = 0;

    @Override
    public void run() {

        while (true)
            try {
                System.out.println("此时的num 为 " + num);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    public void setNum(int num) {
        this.num = num;
    }
}
