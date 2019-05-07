package com.cs.design.builder;

import java.util.ArrayList;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/5 10:56
 * @description：
 * @modified By：
 * @version: $
 */
public class Director {
    ArrayList<String> sequence = new ArrayList<>();
    BenzBuilder benzBuilder = new BenzBuilder();


    /**
     * A类型的奔驰车模型，先start，然后stop，其他什么引擎、喇叭一概没有
     *
     * @return
     */
    public BenzModel getABenzModel() {

        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("stop");

        this.benzBuilder.setSequence(sequence);
        return (BenzModel) this.benzBuilder.getCarModel();
    }


    /**
     * B型号的奔驰车模型，是先发动引擎，然后启动，然后停止，没有喇叭
     *
     * @return
     */
    public BenzModel getBBenzModel() {

        this.sequence.clear();
        this.sequence.add("boom");
        this.sequence.add("start");
        this.sequence.add("stop");
        this.benzBuilder.setSequence(sequence);
        return (BenzModel) this.benzBuilder.getCarModel();
    }


    /**
     * C型号的宝马车是先按下喇叭（炫耀嘛），然后启动，然后停止
     *
     * @return
     */
    public BenzModel getCBenzModel() {

        this.sequence.clear();
        this.sequence.add("alarm");
        this.sequence.add("start");
        this.sequence.add("stop");
        this.benzBuilder.setSequence(sequence);
        return (BenzModel) this.benzBuilder.getCarModel();
    }

}
