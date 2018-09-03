package com.caxs.base.serviceImpl; 

import com.caxs.base.dao.HmUserDao;
import com.caxs.base.domain.HmUser;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.apache.shiro.web.filter.mgt.DefaultFilter.user;

/** 
* UserServiceImpl Tester. 
* 
* @author wangchen 
* @since <pre>08/03/2018</pre> 
* @version 1.0 
*/ 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-test.xml"})
public class UserServiceImplTest { 
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);

    @Autowired
    private HmUserDao hmUserDao;

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

        /** 
    * 
    * Method: loginUser(HmUser user) 
    * 
    */ 
    @Test
    public void testLoginUser() throws Exception { 
    //TODO: Test goes here... 
    } 
    
        /** 
    * 
    * Method: creatUser(HmUser user) 
    * 
    */ 
    @Test
    public void testCreatUser() throws Exception {
        int a = 0 ;
        try {
            HmUser user = new HmUser();
            user.setId("14");
            user.setLoginid("789");
            user.setUsername("xindaichen");
            user.setPassword("1111111");
            a = hmUserDao.insertSelective(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
        /** 
    * 
    * Method: updataUser(HmUser user) 
    * 
    */ 
    @Test
    public void testUpdataUser() throws Exception { 
    //TODO: Test goes here... 
    } 
    
        /** 
    * 
    * Method: selectUser() 
    * 
    */ 
    @Test
    public void testSelectUser() throws Exception {
        List<HmUser> list;
        try {
            list = hmUserDao.selectAllUser();
        } catch (Exception e) {
            e.printStackTrace();
            list = new ArrayList<>();
        }
    } 
    
        /** 
    * 
    * Method: select(String name) 
    * 
    */ 
    @Test
    public void testSelect() throws Exception {
    //TODO: Test goes here...
    } 
    
    
    } 
