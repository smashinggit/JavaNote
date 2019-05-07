package com.cs.design.decorate;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 16:00
 * @description：
 * @modified By：
 * @version: $
 */
public class SortDecorator extends Decorator {
    public SortDecorator(SchoolReport report) {
        super(report);
    }

    private void reportSort() {
        System.out.println("我是排名第38名...");
    }

    /**
     * 老爸看完成绩单后再告诉他，加强作用
     */
    @Override
    public void report() {
        super.report();
        this.reportSort();
    }
}
