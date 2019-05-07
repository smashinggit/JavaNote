package com.cs.design.templatemethod;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/5 9:53
 * @description：
 * @modified By：
 * @version: $
 */
public abstract class BMWModel {

    protected abstract void alarm();

    protected abstract void engineBoom();

    protected abstract void start();

    protected abstract void stop();


    /**
     * 为了防止恶意的操作，一般模板方法都加上final关键字，不允许被覆写
     */
    final public void run() {
        this.start();
        this.engineBoom();
        if (isAlarm()) {
            this.alarm();
        }
        this.stop();
    }

    /**
     * 钩子方法，默认喇叭是会响的
     *
     * @return
     */
    protected boolean isAlarm() {
        return true;
    }
}
