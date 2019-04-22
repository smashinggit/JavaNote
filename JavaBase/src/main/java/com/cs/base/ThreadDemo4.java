package com.cs.base;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/15 15:59
 * @description：
 * @modified By：
 * @version: $
 * <p>
 * 在 Java 中，一般情况下都是使用 synchronized 关键字来加锁的，
 * synchronized 这种机制一旦开始获取锁，是不能中断的，也没有提供尝试获取锁的功能
 * 在 JDK1.5 提供了 Lock 接口，开发人员显示地去操作锁的获取和释放，因此被称为显式锁。
 * 并且提供了synchronized不提供的机制
 * <p>
 * Lock API
 * void lock(); 阻塞式获取锁
 * 这种方式与 synchronized 获取锁差不多，如果需要获取的锁被其他线程持有，那么将挂起阻塞等待其他线程释放锁
 * boolean tryLock(); 尝试非阻塞式地获取锁
 * boolean tryLock(long time, TimeUnit unit) throws InterruptedException; 尝试非阻塞式地获取锁
 * 非阻塞去尝试获取锁，如果获取到锁会返回 true，如果没有获取到锁，则返回 false。
 * 带有时间参数的方法表示开始获取锁时，如果此时该锁没有被其他线程持有，那么则返回 true，
 * 否则将进行超时等待，中途如果线程发生了中断信号，则 tryLock 方法抛出中断异常。
 * void lockInterruptibly() throws InterruptedException; 能被中断获取锁
 * 请求锁，如果当前锁被其他线程持有，那么将阻塞等待，除非外界调用 thread.interrupt() 发出中断信号。
 * <p>
 * Lock 锁的标准写法
 * //阻塞式获取锁
 * lock.lock();
 * <p>
 * try{
 * //对共享资源的操作
 * }finally{
 * lock.unlock();
 * }
 * <p>
 * //获取一个可中断的锁
 * try{
 * lock.lockInterruptibly();
 * }catch(InterruptedException e){
 * //发生了异常，不应该往下执行，因为没有获取到锁就调用unlock 会抛出异常
 * return;
 * }
 * try{
 * //对共享资源的操作
 * }finally{
 * lock.unlock();
 * }
 * <p>
 * 什么是可重入锁？
 * 可重入锁就是当前线程获取到锁，并执行需要加锁的方法时，在方法内部再次的获取该锁是可以直接锁去，
 * 这种情况就是避免了自己把自己给锁死了。ReentrantLock 和 synchronized 都是可重入锁
 * synchronized(this){
 * //do sth
 * synchronized(this){//再次获取同一把锁，可以直接获取
 * //do sth
 * }
 * }
 * <p>
 * ReentrantLock实现公平锁和非公平锁
 * 公平锁表示线程的执行顺序按照请求锁的顺序来执行，也就是先请求锁的线程优先获取锁。
 * 非公平锁则是由 CPU 负责线程去调度获取锁，不一定是按照先请求锁的线程优先获取锁
 * 获取一个公平锁
 * Lock lock = new ReentrantLock(true);
 * <p>
 * 公平锁和非公平锁的效率哪个比较高呢?
 * 当然是非公平锁， ReentrantLock 和 synchronized 内部的缺省实现都是非公平锁。
 * 因为线程B在请求锁时发现当前锁被其他线程A持有，那么线程B该发生上下文切换，将处于挂起，
 * 这时如果还有另外一个线程C过来请求锁，发现锁还是被其他线程A持有，那么线程C该发生上下文切换，
 * 处于挂起状态，此时如果线程 A 释放锁了，那么此时锁只能被线程B 获取，线程 C 只能等待到线程 B
 * 执行完毕。恢复一个被挂起的线程与该线程真正开始执行之间存在严重的延迟。
 * <p>
 * <p>
 * <p>
 * 读写锁ReentrantReadWritLock
 * 在上面讲到的 synchronized 和 ReentrantLock 都是独占锁，也就是也就说同一时刻只能有一个线程去访问。
 * 而这里提到的读写锁是在同一时刻，允许多个读线程去访问，但是在写线程访问时，所有其他读写线程都会被阻塞。
 * ReentrantReadWritLock 内部维护了两个锁，分别为读锁(共享锁)和写锁(排他锁)，它们内部都是实现Lock 接口
 * <p>
 * <p>
 * <p>
 * Condition接口
 * 在 synchronized 内置锁中，一般是使用对象的 wait() 和 notify() 实现等待通知机制，
 * 而在 Lock 显示锁中是使用 Condition 的 await 和 signal 实现等待通知机制。
 * <p>
 * 对比 Object 的 wait 和 notify
 * signal()/notify()
 * signalAll/notifyAll()
 * await()/wait()
 * await(long time, TimeUnit unit)/wait(long millis),wait(long var1, int var3)
 */
public class ThreadDemo4 {

    public static void main(String[] args) throws InterruptedException {

        Shop shop = new Shop();
        Thread laowang = new Thread(shop, "老王");
        Thread laozhang = new Thread(shop, "老张");

        laowang.start();
        laozhang.start();

        Thread.sleep(3000);
        shop.depreciateXiaomi9(9);
        Thread.sleep(3000);
        shop.depreciateXiaomi9(7);
    }
}


class Shop implements Runnable {
    private int xiaomi9Discount = 10;

    private Lock lock = new ReentrantLock();
    //小米9条件
    Condition condition = lock.newCondition();

    //通知方：折扣改变的通知方法
    public void depreciateXiaomi9(int discount) {

        try {
            lock.lock();  //阻塞式获取锁

            System.out.println(Thread.currentThread().getName() + "收到总部通知，现在进行小米9打" + discount + "折活动，通知米粉们来买吧");
            xiaomi9Discount = discount;

            //通知客户：小米9打折了哦，赶紧去看看价格吧。
            //condition.signal();//随机通知一个等待线程
            condition.signalAll();//通知所有等待的线程
        } finally {
            lock.unlock();
        }
    }

    // 等待方：查询小米9价格
    public void getXiaomi9Price() {

        try {
            lock.lock();

            System.out.println(Thread.currentThread().getName() + "正在查询小米9价格");
            //小米9的折扣还没低于8折，不要给我推销

            while (xiaomi9Discount > 8) {

                try {
                    System.out.println(Thread.currentThread().getName() + "发现小米9价格折扣为" + xiaomi9Discount + "太少，我要开始等待降价，老板，降价了，就通知我哦，开始等待...");
                    //等待：等待小米9降价
                    condition.await();

                    System.out.println(Thread.currentThread().getName() + "收到通知：小米9搞活动，打折了哦，目前折扣为：" + xiaomi9Discount);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "剁手买顶配小米9：" + xiaomi9Discount + "折购入");
        } finally {
            lock.unlock();
        }
    }


    @Override
    public void run() {
        getXiaomi9Price();
    }
}