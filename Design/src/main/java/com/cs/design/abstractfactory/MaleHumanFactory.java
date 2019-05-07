package com.cs.design.abstractfactory;

/**
 * @author ：chensen
 * @date ：Created in 2019/4/30 16:46
 * @description：
 * @modified By：
 * @version: $
 */
public class MaleHumanFactory implements AbstractHumanFactory {

    @Override
    public Human createYellowHuman() {
        return new MaleYellowHuman();
    }

    @Override
    public Human createWhiteHuman() {
        return new MaleWhiteHuman();
    }

    @Override
    public Human createBlackHuman() {
        return new MaleBlackHuman();
    }
}
