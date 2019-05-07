package com.cs.design.responsibility;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 11:11
 * @description：
 * @modified By：
 * @version: $
 */
public class Husband extends Handler {

    public Husband( ) {
        super(Handler.HUSBAND_LEVEL_REQUEST);
    }

    @Override
    void response(IWomen women) {
        System.out.println("--------妻子向丈夫请示-------");
        System.out.println("妻子的请示是："+women.getRequest());
        System.out.println("丈夫的答复是:同意");
    }
}
