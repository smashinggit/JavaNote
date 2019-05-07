package com.cs.design.proxy;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/5 11:27
 * @description：
 * @modified By：
 * @version: $
 */
public class GamePlayer implements IGamePlayer {
    String name;

    public GamePlayer(String name) {
        this.name = name;
    }

    @Override
    public void login(String name, String password) {
        System.out.println("玩家 " + name + " 登录游戏");
    }

    @Override
    public void killBoss() {
        System.out.println("玩家 " + name + " 打BOSS");

    }

    @Override
    public void upgrade() {
        System.out.println("玩家 " + name + " 升级");

    }
}
