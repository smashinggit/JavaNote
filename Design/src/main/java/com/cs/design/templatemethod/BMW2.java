package com.cs.design.templatemethod;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/5 9:58
 * @description：
 * @modified By：
 * @version: $
 */
public class BMW2 extends BMWModel {

    private boolean alarmFlag = true;

    public void setAlarmFlag(boolean alarmFlag) {
        this.alarmFlag = alarmFlag;
    }

    /**
     * 由用户决定是否响喇叭
     *
     * @return
     */
    @Override
    protected boolean isAlarm() {
        return alarmFlag;
    }

    @Override
    protected void alarm() {
        System.out.println("BMW2 喇叭响");
    }

    @Override
    protected void engineBoom() {
        System.out.println("BMW2 引擎轰鸣");

    }

    @Override
    protected void start() {
        System.out.println("BMW2 启动");

    }

    @Override
    protected void stop() {
        System.out.println("BMW2 停止");
    }


}
