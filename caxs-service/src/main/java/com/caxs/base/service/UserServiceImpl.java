package com.caxs.base.service;

import com.caxs.base.dao.HmUserDao;
import com.caxs.base.domain.HmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: caxstest
 * @author: wangchen
 * @date: 2018/8/2 20:16
 */
@Component
public class UserServiceImpl implements IUserService {

    @Autowired
    private HmUserDao hmUserDao;

    @Override
    public int loginUser(HmUser user) {

        int a = 0;
        try {
            HmUser hmUser = hmUserDao.selectByPasswardAndName(user);
            if (!StringUtils.isEmpty(user.getUsername()) && user.getUsername().equals(hmUser.getUsername())&& !StringUtils.isEmpty(user.getPassword()) && user.getPassword().equals(hmUser.getPassword())){
                a = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public int creatUser(HmUser user) {
        int a = 0 ;
        try {
            a = hmUserDao.insertSelective(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public int updataUser(HmUser user) {
        int a = 0 ;
        try {
            a = hmUserDao.updateByPrimaryKeySelective(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public List<HmUser> selectUser() {
        List<HmUser> list;
        try {
            list = hmUserDao.selectAllUser();
        } catch (Exception e) {
            e.printStackTrace();
            list = new ArrayList<>();
        }
        return list;
    }

    @Override
    public HmUser select(String name) {
        HmUser hmUser = new HmUser();
        try {
            hmUser.setUsername(name);
            hmUser = hmUserDao.selectByPasswardAndName(hmUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hmUser;
    }
}
