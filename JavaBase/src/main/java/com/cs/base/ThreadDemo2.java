package com.cs.base;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/12 14:23
 * @description：
 * @modified By：
 * @version: $
 * <p>
 * 新建状态(NEW)
 * 新建一个线程对象，此时并没有执行 start() 方法，这时的线程状态就是处于新建状态。
 * 就绪状态(RUNNABLE)
 * start() 方法调用之后会让一个线程进入就绪等待队列，JVM 会为其创建对应的虚拟机栈，
 * 本地方法栈和程序计数器。处于这个状态的线程还没开始运行，需要等待 CPU 的执行权。
 * 运行状态(RUNNING)
 * 处于就绪状态的线程在抢到 CPU 执行权之后，就处于运行状态，执行该线程的 run 方法
 * 阻塞状态(BLOCKED)
 * TIME_WAIT/WAI: 运行的线程执行 wait() /wait(long),join()/join(long)方法，那么这些线程放弃 CPU
 * 执行和线程持有的锁，并且 JVM 会将这些线程放入到等待池中。
 * BLOCKED: 运行时的线程在获取同步锁时，发现锁被其他线程持有，这时 JVM 会将当前线程放入锁池中
 * 结束(TERMINATED)
 * 线程 run 方法执行完毕，或者线程被异常终止。
 * <p>
 * <p>
 * 启动一个线程是run()还是start()?它们的区别?
 * 启动一个线程是start();
 * run():封装了被线程执行的代码,直接调用仅仅是普通方法的调用
 * start():启动线程，并由JVM自动调用run()方法
 * <p>
 * sleep()和wait()方法的区别?
 * sleep():必须指时间;不释放锁。
 * wait():可以不指定时间，也可以指定时间;释放锁。
 * <p>
 * <p>
 * 线程之间的安全性问题
 * 问题1：同一进程间的多个线程是可以共享该进程的资源的，当多个线程访问共享变量时，就会线程安全问题。
 * 问题2：为了解决线程之间的同步问题，一般会引入锁机制，对于线程之间抢夺锁时也是有可能造成死锁问题。
 * 问题3：在 JVM 内存模型中，每一个线程都会分配一个虚拟机栈，这个虚拟机栈是需要占用内存空间的，
 * 如果无限制的创建线程的话，会耗尽系统的内存。
 * <p>
 * join() 会阻塞当前线程，等待调用join方法的线程执行完毕
 * <p>
 * <p>
 * <p>
 * 线程的协作
 * 等待/通知机制:
 * 是指一个线程A调用了对象O的wait()方法进入等待状态，而另一个线程B调用了对象O的notify()或者notifyAll()
 * 方法，线程A收到通知后从对象O的wait()方法返回，进而执行后续操作。上述两个线程通过对象O来完成交互
 * <p>
 * 等待和通知的标准范式
 * 等待方遵循如下原则：
 * 获取对象锁。
 * 如果条件不符合，那么调用该对象的 wait()方法，被其他 notify() 之后仍要检查条件。
 * 条件满足则执行对应的逻辑
 * 伪代码如下
 * synchronized(锁对象){
 * while(条件不满足){
 * 锁对象.wait();
 * }
 * //满足条件处理对应的逻辑
 * }
 * <p>
 * 通知方遵循如下原则：
 * 获取对象锁。
 * 改变条件。
 * 通知正在等待对象锁的线程。
 * synchronized(锁对象){
 * 改变条件
 * 锁对象.notifyAll();
 * }
 * <p>
 * 为什么wait(),notify(),notifyAll()等方法都定义在Object类中?
 * 因为这些方法的调用是依赖于锁对象的，而同步代码块的锁对象是任意锁。
 * 而Object代码任意的对象，所以，定义在这里面。
 * <p>
 * 一个对象拥有两个池
 * 锁池:
 * 假设 A 线程持有对象 Object 的锁，此时其他线程想要执行该对象的某一个
 * 同步方法或者同步块，这些线程就会进入该对象的锁池中。
 * 等待池:
 * 假设 A 线程正在同步方法或者同步块中执行中调用了object.wait() ，那么线程 A 就会进入对象 object
 * 的等待池中，等待其他线程调用该对象的 notify() 或者 notifyAll() 方法。如果其他线程调用的
 * object.notity() 方法，那么 CPU 会从等待池中随机取出一个线程放入锁池中，如果其他线程调用
 * object.notifyAll() 那么 CPU 会将等待池中所有的线程到放入到锁池中，准备争夺锁的持有权
 * <p>
 * notify 和 notifyAll 应该用谁?
 * 如果多个线程都调用了 对象锁.wait() 方法，那么如果只是调用 对象锁.notify() 方法，
 * 那么不一定会唤醒你想要的那个线程，CPU 只是随机地都等待池种去取出一个线程放入锁池中，
 * 所以说最好是使用 notifyAll();
 */
public class ThreadDemo2 {
    // 创建两把锁对象
    public static Object lockA = new Object();
    public static Object lockB = new Object();

    public static void main(String[] args) throws InterruptedException {

        //模拟死锁
        Thread dieLock1 = new Thread(new DieLock(true));
        Thread dieLock2 = new Thread(new DieLock(false));
        dieLock1.start();
        dieLock2.start();

        //老王和老张买小米9手机
        //等待/通知 范式的应用
        XiaomiShop xiaomiShop = new XiaomiShop();

        //老王想要买手机
        Thread laowang = new Thread(xiaomiShop, "老王");
        //老张也要买手机
        Thread laozhang = new Thread(xiaomiShop, "老张");

        laowang.start();
        laozhang.start();

        Thread.sleep(3000);
        xiaomiShop.depreciateXiaomi9(9);//降价了

        Thread.sleep(3000);
        xiaomiShop.depreciateXiaomi9(8); //又降价了

    }
}

/**
 * 老王和老张买小米9手机
 * 等待/通知 范式的应用
 */
class XiaomiShop implements Runnable {

    private int xiaomi9Discount = 10;
    private Object lock = new Object();

    //通知方：折扣改变的通知方法
    public void depreciateXiaomi9(int discount) {

        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + "收到总部通知，现在进行小米9打" + discount + "折活动，通知米粉们来买吧");
            xiaomi9Discount = discount;

            //通知客户：小米9打折了哦，赶紧去看看价格吧。
//            notify();//抛出 IllegalMonitorStateException 调用wait()，notify()和notifyAll()的线程在调用这些方法前必须"拥有"对象的锁。当前的线程不是此对象锁的所有者，却调用该对象的notify()，notify()，wait()方法时抛出该异常
//            notifyAll();//抛出 IllegalMonitorStateException

//            lock.notify();//随机通知一个等待线程
            lock.notifyAll();//通知所有等待的线程
        }
    }

    // 等待方：查询小米9价格
    public void getXiaomi9Price() {

        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + "正在查询小米9价格");
            //小米9的折扣还没低于8折，不要给我推销

            while (xiaomi9Discount > 8) {

                try {
                    System.out.println(Thread.currentThread().getName() + "发现小米9价格折扣为" + xiaomi9Discount + "太少，我要开始等待降价，老板，降价了，就通知我哦，开始等待...");
                    //等待：等待小米9降价
                    lock.wait();

                    System.out.println(Thread.currentThread().getName() + "收到通知：小米9搞活动，打折了哦，目前折扣为：" + xiaomi9Discount);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + "剁手买顶配小米9：" + xiaomi9Discount + "折购入");
        }
    }


    @Override
    public void run() {
        getXiaomi9Price();
    }
}


class SyncTest {
    private int count;

    //synchronized 作用于对象实例方法上，对象锁是当前 this 对象。
    public synchronized void increase() {
        count++;
    }

//--------------------------------------

    private Object monitor = new Object();

    //synchronized 作用于对象实例方法内部的同步代码块上，对象锁是当前 this 对象/或者 monitor。
    public void increase2() {
        synchronized (this) {//对象锁是当前 this 对象
            count++;
        }

//        synchronized (monitor) {//对象锁是 monitor
//            count++;
//        }
    }

    // ---------------------------------------------

    //其实类锁也是一个对象锁
    //类锁：使用在类静态方法上
    public synchronized static void change() {

    }

    //类锁：SyncTest.class对象作为对象实例方法代码块锁
    public static void change2() {
        synchronized (SyncTest.class) {

        }
    }
}


//死锁问题及其代码
//是指两个或者两个以上的线程在执行的过程中，因争夺资源产生的一种互相等待现象
class DieLock implements Runnable {

    boolean flag;

    public DieLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {

        if (flag) {

            synchronized (ThreadDemo2.lockA) {
                System.out.println("if lockA");

                synchronized (ThreadDemo2.lockB) {
                    System.out.println("if lockB");
                }
            }
        } else {

            synchronized (ThreadDemo2.lockB) {
                System.out.println("else lockB");

                synchronized (ThreadDemo2.lockA) {
                    System.out.println("else lockA");
                }
            }

        }

    }
}