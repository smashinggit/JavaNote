package com.cs.base;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/12 16:36
 * @description：
 * @modified By：
 * @version: $
 * <p>
 * 线程隔离ThreadLocal
 * ThreadLocal往往用来实现变量在线程之间的隔离
 */
public class ThreadDemo3 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<?> runnableleFuture = executorService.submit(new MyRunnable());
        Future<Integer> callableFuture = executorService.submit(new MyCallable());


        new Thread(() -> {
            try {
                //get()方法会阻塞主线程执行
                System.out.println("runnableleFuture " + runnableleFuture.get());  //接收线程执行完的结果
                System.out.println("callableFuture " + callableFuture.get());  //接收线程执行完的结果
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println("主线程继续执行");


        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(() -> {

        }, 1, TimeUnit.SECONDS);


        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

            }
        }, 0, 1000);


        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Callable work done";
            }
        };
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            String result = futureTask.get();  //get() 是一个阻塞式的操作，一直等待 call 方法执行完毕。
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        threadLocalTest();
    }

    private static void threadLocalTest() {
        //定义一个 ThreadLocal，存储的是 String 类型，默认存储 subject 的值为"我是默认值"
        String subject = "我是默认值";


        ThreadLocal<String> threadLocal = new ThreadLocal<String>() {
            @Override
            protected String initialValue() {
                return subject;
            }
        };

        new Thread(() -> {
            threadLocal.set("我是线程一的值");
            String s = threadLocal.get();

            System.out.println(Thread.currentThread().getName() + " 中的值是 " + s);
        }, "线程1").start();
        new Thread(() -> {
            threadLocal.set("我是线程二的值");
            String s = threadLocal.get();

            System.out.println(Thread.currentThread().getName() + " 中的值是 " + s);
        }, "线程2").start();

        threadLocal.set("我是默认值");
        String s = threadLocal.get();
        System.out.println(Thread.currentThread().getName() + " 中的值是 " + s);
    }

}

class MyRunnable implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + ":" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + ": 正在进行计算...");
        Thread.sleep(1000);
        return 100;
    }
}
