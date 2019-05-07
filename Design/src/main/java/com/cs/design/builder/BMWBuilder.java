package com.cs.design.builder;

import java.util.ArrayList;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/5 10:52
 * @description：
 * @modified By：
 * @version: $
 */
public class BMWBuilder extends CarBuilder {

    BMWModel bmwModel = new BMWModel();

    @Override
    public void setSequence(ArrayList sequence) {
        this.bmwModel.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return bmwModel;
    }
}
