package com.caxs.runner; 

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* ServiceProvider Tester. 
* 
* @author wangchen 
* @since <pre>08/02/2018</pre> 
* @version 1.0 
*/ 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-test.xml"})
public class ServiceProviderTest { 
    private static final Logger logger = LoggerFactory.getLogger(ServiceProviderTest.class);

    @Before
    public void before() throws Exception { 
    } 

    @After
    public void after() throws Exception { 
    } 

        /** 
    * 
    * Method: main(String[] args) 
    * 
    */ 
    @Test
    public void testMain() throws Exception { 
    //TODO: Test goes here...
        System.out.println("sadadassdasdsada");
    } 
    
    
    } 
