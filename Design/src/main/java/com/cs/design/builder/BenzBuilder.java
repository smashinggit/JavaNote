package com.cs.design.builder;

import java.util.ArrayList;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/5 10:52
 * @description：
 * @modified By：
 * @version: $
 */
public class BenzBuilder extends CarBuilder {

    BenzModel benzModel = new BenzModel();

    @Override
    public void setSequence(ArrayList sequence) {
        this.benzModel.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return benzModel;
    }
}
