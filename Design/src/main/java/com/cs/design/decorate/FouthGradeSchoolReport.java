package com.cs.design.decorate;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 15:49
 * @description：
 * @modified By：
 * @version: $
 */
public class FouthGradeSchoolReport extends  SchoolReport {
    @Override
    public void report() {
        System.out.println("尊敬的XXX家长:");
        System.out.println(" ......");
        System.out.println(" 语文 62 数学65 体育 98 自然 63");
        System.out.println(" .......");
        System.out.println(" 家长签名： ");
    }

    @Override
    public void sign(String name) {
            System.out.println("家长签名为："+name);
    }
}
