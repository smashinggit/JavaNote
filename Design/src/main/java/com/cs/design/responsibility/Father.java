package com.cs.design.responsibility;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 11:11
 * @description：
 * @modified By：
 * @version: $
 */
public class Father extends Handler {

    /**
     * 父亲只处理女儿的请求
     */
    public Father() {
        super(Handler.FATHER_LEVEL_REQUEST);
    }

    @Override
    void response(IWomen women) {
        System.out.println("--------女儿向父亲请示-------");
        System.out.println("女儿的请示是：" + women.getRequest());
        System.out.println("父亲的答复是:同意");
    }
}
