package com.cs.design.observe;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 18:06
 * @description：
 * @modified By：
 * @version: $
 */
public class WangEr implements Observer {
    @Override
    public void update(String content) {
        System.out.println("王二：观察到韩非子活动，自己也开始活动了...");
        this.cry(content);
        System.out.println("王斯：哭死了...\n");
    }

    private void cry(String content) {
        System.out.println("王斯：因为" + content + "，--所以我悲伤呀！");
    }
}
