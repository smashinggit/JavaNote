package com.cs.design.adapter;

import java.util.Map;

/**
 * @author ：chensen
 * @date ：Created in 2019/5/6 16:47
 * @description：
 * @modified By：
 * @version: $
 */
public interface IOuterUser {

    Map<String, String> getUserBaseInfo();

    Map<String, String> getUserOfficeInfo();

    Map<String, String> getUserHomeInfo();
}
