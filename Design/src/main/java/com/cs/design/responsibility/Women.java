package com.cs.design.responsibility;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 11:08
 * @description：
 * @modified By：
 * @version: $
 */
public class Women implements IWomen {

    /**
     * * 通过一个int类型的参数来描述妇女的个人状况
     * * 1--未出嫁
     * * 2--出嫁
     * * 3--夫死
     */
    private int type = 0;

    /**
     * 妇女的请示
     */
    private String request = "";


    public Women(int type, String request) {
        this.type = type;
        //为了便于显示，在这里做了点处理
        switch (this.type) {
            case 1:
                this.request = "女儿的请求是：" + request;
                break;
            case 2:
                this.request = "妻子的请求是：" + request;
                break;
            case 3:
                this.request = "母亲的请求是：" + request;
            default:
                break;
        }
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public String getRequest() {
        return this.request;
    }
}
