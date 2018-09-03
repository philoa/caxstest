package com.caxs.base.dao;

import com.caxs.base.domain.HmUser;

import java.util.List;

public interface HmUserDao {
    int deleteByPrimaryKey(String id);

    int insert(HmUser record);

    int insertSelective(HmUser record);

    HmUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(HmUser record);

    int updateByPrimaryKey(HmUser record);

    HmUser selectByPasswardAndName(HmUser record);

    List<HmUser> selectAllUser();
}