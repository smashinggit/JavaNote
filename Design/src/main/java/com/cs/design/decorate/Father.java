package com.cs.design.decorate;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 15:50
 * @description：装饰模式
 * @modified By：
 * @version: $
 * <p>
 * 动态地给一个对象添加一些额外的职责。
 * 就增加功能来说，装饰模式相比生成子类更为灵活
 */
public class Father {

    public static void main(String[] args) {
        SchoolReport report;

        //原装的成绩单
        report = new FouthGradeSchoolReport();
        //加了最高分说明的成绩单
        report = new HighScoreDecorator(report);
        //又加了成绩排名的说明
        report = new SortDecorator(report);

        report.report();
        report.sign("家长");
    }
}
