package com.cs.design.proxy;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/5 11:30
 * @description：
 * @modified By：
 * @version: $
 */
public class GamePlayerProxy implements IGamePlayer {
    IGamePlayer gamePlayer = null;

    /**
     * 通过构造函数传递要对谁进行代练
     *
     * @param gamePlayer
     */
    public GamePlayerProxy(IGamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }


    @Override
    public void login(String name, String password) {
    this.gamePlayer.login(name, password);
    }

    /**
     * 代练杀怪
     */
    @Override
    public void killBoss() {
        this.gamePlayer.killBoss();
    }

    /**
     * 代练升级
     */
    @Override
    public void upgrade() {
        this.gamePlayer.upgrade();
    }
}
