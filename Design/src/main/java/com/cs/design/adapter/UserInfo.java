package com.cs.design.adapter;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 16:46
 * @description：
 * @modified By：
 * @version: $
 */
public class UserInfo implements IUserInfo {
    @Override
    public String getUserName() {
        System.out.println("姓名叫做...");
        return null;
    }

    @Override
    public String getHomeAddress() {
        System.out.println("这里是员工的家庭地址...");
        return null;
    }

    @Override
    public String getMobileNumber() {
        System.out.println("这个人的手机号码是0000...");
        return null;
    }

    @Override
    public String getJobPosition() {
        System.out.println("这个人的职位是BOSS...");
        return null;
    }

    @Override
    public String getHomeTelNumber() {
        System.out.println("这个人的家庭号码是1234...");
        return null;
    }
}
