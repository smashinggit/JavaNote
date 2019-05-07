package com.cs.design.builder;

import java.util.ArrayList;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/5 10:35
 * @description：
 * @modified By：
 * @version: $
 */
public abstract class CarModel {

    private ArrayList<String> sequence = new ArrayList<>();

    protected abstract void start();

    protected abstract void engineBoom();

    protected abstract void alarm();

    protected abstract void stop();

    final public void run() {
        for (int i = 0; i < sequence.size(); i++) {

            String action = sequence.get(i);
            if (action.equals("start")) {
                this.start();

            } else if (action.equals("stop")) {
                this.stop();

            } else if (action.equals("alarm")) {
                this.alarm();
            } else if (action.equals("boom")) {
                this.engineBoom();
            }
        }
    }

    public void setSequence(ArrayList sequece) {
        this.sequence = sequece;
    }
}
