package com.cs.design.adapter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 16:48
 * @description：
 * @modified By：
 * @version: $
 */
public class OuterUser implements IOuterUser {
    @Override
    public Map<String, String> getUserBaseInfo() {
        HashMap baseInfoMap = new HashMap();
        baseInfoMap.put("userName", "这个员工叫混世魔王...");
        baseInfoMap.put("mobileNumber", "这个员工电话是...");
        return baseInfoMap;
    }

    @Override
    public Map<String, String> getUserOfficeInfo() {
        HashMap officeInfo = new HashMap();
        officeInfo.put("jobPosition", "这个人的职位是BOSS...");
        officeInfo.put("officeTelNumber", "员工的办公电话是...");
        return officeInfo;
    }

    @Override
    public Map<String, String> getUserHomeInfo() {
        HashMap homeInfo = new HashMap();
        homeInfo.put("homeTelNumbner", "员工的家庭电话是...");
        homeInfo.put("homeAddress", "员工的家庭地址是...");
        return homeInfo;
    }
}
