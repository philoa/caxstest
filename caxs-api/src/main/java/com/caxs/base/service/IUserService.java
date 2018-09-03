package com.caxs.base.service;

import com.caxs.base.domain.HmUser;

import java.util.List;

/**
 * @Description: caxstest
 * @author: wangchen
 * @date: 2018/8/2 18:36
 */

public interface IUserService {

    int loginUser(HmUser user);

    int creatUser(HmUser user);

    int updataUser(HmUser user);

    List<HmUser> selectUser();

    HmUser select(String name);

}
