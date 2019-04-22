package com.cs.base;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/12 10:42
 * @description：
 * @modified By：
 * @version: $
 * <p>
 * CPU 核心数和线程数的关系
 * 目前的 CPU 有双核，四核，八核，一般情况下，它和线程数是1:1的对应关系，
 * 也就是四核 CPU 一般就能并行执行 4 个线程。
 * 但 Intel 引入超线程技术后,使核心数与线程数形成1:2的关系，也就是我们常说的 4核8线程
 * <p>
 * 线程调度与线程调度模型
 * 任意时刻，只有一个线程占用 CPU，处于运行状态。而多线程并发执行就是轮流获取 CPU 执行权
 * 分时调用模型 -> 轮流获取 CPU 执行权，均分 CPU 执行时间。
 * 抢占式调度模型  ->  优先级高的线程优先获取 CPU 执行权，这也是 JVM 采用的线程调度模型。
 * <p>
 * 进程与线程
 * 进程是程序运行资源分配的最小单位。
 * 些资源就包括 CPU，内存空间，磁盘 IO 等。同一进程中的多个线程共享该进程的所有资源，
 * 而不同进程是彼此独立的。举个栗子，在手机开启一个 APP 实际上就是开启了一个进程了，
 * 而每一个 APP 程序会有很多线程在跑，例如刷新 UI 的线程等，所以说进程是包含线程的。
 * 线程是 CPU 调度的最小单位，必须依赖于进程而存在。
 * 线程是比进程更小的，能独立运行的基本单位，每一个线程都有一个程序计数器，虚拟机栈等，
 * 它可以与同一进程下的其它线程共享该进程的资源
 * <p>
 * 并行与并发  两者的区别：并行是同时执行，并发是交替执行
 * 并行 -> 指应用能够同时执行不同的任务。例如多辆汽车可以同时在同一条公路上的不同车道上并行通行
 * 并发 -> 指应用能够交替执行不同的任务，因为一般的计算机只有一个 CPU 也就是只有一颗心，
 * 如果一个 CPU 要运行多个进程，那就需要使用到并发技术了，例如时间片轮转进程调度算法。
 * 比如单 CPU 核心下执行多线程任务时并非同时执行多个任务，而是以一个非常短的时间不断地切换执行不同的任务，
 * 这个时间是我们无法察觉的出来的
 * <p>
 *
 *
 * <p>
 * public static void sleep(long millis)：线程休眠
 * public final void join()：线程加入
 * public static void yield()：线程礼让
 * public final void setDaemon(boolean on)：后台线程
 * public final void stop()：中断线程
 * public void interrupt()：中断线程
 */
public class ThreadDemo extends Thread {

    public static void main(String[] args) {

        SellTicket();
    }

    //某电影院目前正在上映贺岁大片，共有100张票，而它有3个售票窗口售票，请设计一个程序模拟该电影院售票。

    // 如何解决多线程安全问题呢?
    // 把多个语句操作共享数据的代码给锁起来，让任意时刻只能有一个线程执行即可
    private static void SellTicket() {
        SellTicket sellTicket = new SellTicket();

        Thread window1 = new Thread(sellTicket, "窗口一");
        Thread window2 = new Thread(sellTicket, "窗口二");
        Thread window3 = new Thread(sellTicket, "窗口三");

        window1.start();
        window2.start();
        window3.start();

    }

}

/**
 * 解决线程安全问题实现方式一：
 * 同步代码块
 * 格式：
 * synchronized(对象){ 需要同步的代码; }
 * 同步可以解决安全问题的根本原因就在那个对象上。该对象如同锁的功能
 * 同步的前提:
 * 多个线程
 * 多个线程使用的是同一个锁对象
 * 同步的好处:
 * 同步的出现解决了多线程的安全问题。
 * 同步的弊端:
 * 当线程相当多时，因为每个线程都会去判断同步上的锁，这是很耗费资源的，无形中会降低程序的运行效率
 * <p>
 * <p>
 * 解决线程安全问题实现方式二：
 * 我们 还有一种方法可以解决多线程的安全问题
 * 同步方法：就是把同步的关键字加到方法上
 */
class SellTicket implements Runnable {

    int tickets = 100; // 定义100张票
    boolean isDone = false;

    Object lockObject = new Object();
    Lock lock = new ReentrantLock();


    @Override
    public void run() {

//        // 解决线程安全问题实现一：
//        while (!isDone) {
//            synchronized (this) {
//                if (tickets > 0) {
//                    // 为了模拟更真实的场景，我们稍作休息
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");
//                } else
//                    isDone = true;
//            }
//        }

        //解决线程安全问题实现方式三:锁
        while (!isDone) {

            lock.lock();

            try {
                if (tickets > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()
                            + "正在出售第" + (tickets--) + "张票");

                } else
                    isDone = true;

            } finally {
                lock.unlock();
            }
        }

        //解决线程安全问题实现方式二:同步方法
//        while (!isDone)
//            sellTicket();
    }

    //把同步关键字加在方法上，它的对象是this
//    private synchronized void sellTicket() {
//
//        if (tickets > 0) {
//            // 为了模拟更真实的场景，我们稍作休息
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");
//        } else
//            isDone = true;
//    }
}
