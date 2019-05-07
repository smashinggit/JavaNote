package com.cs.design.observe;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 17:51
 * @description：
 * @modified By：
 * @version: $
 */
public class Client {

    public static void main(String[] args) {
        Observable hanFeiZi = new HanFeiZi();

        Observer lisi = new LiSi();
        Observer wanger = new WangEr();

        hanFeiZi.addObserver(lisi);
        hanFeiZi.addObserver(wanger);
        ((HanFeiZi) hanFeiZi).haveBreakfast();

    }
}
