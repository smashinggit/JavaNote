package com.cs.design.decorate;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 15:55
 * @description：
 * @modified By：
 * @version: $
 */
public abstract class Decorator extends SchoolReport {

    /**
     * 首先我要知道是哪个成绩单
     */
    private SchoolReport report;

    public Decorator(SchoolReport report) {
        this.report = report;
    }

    /**
     * 成绩单还是要被看到的
     */
    @Override
    public void report() {
        this.report.report();
    }

    /**
     * 看完还是要签名的
     *
     * @param name
     */
    @Override
    public void sign(String name) {
        this.report.sign(name);
    }
}
