package com.cs.design.responsibility;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 11:11
 * @description：
 * @modified By：
 * @version: $
 */
public class Son extends Handler {
    public Son( ) {
        super(Handler.SON_LEVEL_REQUEST);
    }

    @Override
    void response(IWomen women) {
        System.out.println("--------母亲向儿子请示-------");
        System.out.println("母亲的请示是："+women.getRequest());
        System.out.println("母亲的答复是:同意");
    }
}
