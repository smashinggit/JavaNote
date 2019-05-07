package com.cs.design.builder;

import java.util.ArrayList;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/5 10:50
 * @description：
 * @modified By：
 * @version: $
 */
public abstract class CarBuilder {

    public abstract void setSequence(ArrayList sequence);

    public abstract CarModel getCarModel();

}
