package com.bdqn.mybatis.service;

import com.bdqn.mybatis.pojo.TestEntity;
import com.bdqn.mybatis.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext.xml")

public class UserServiceTest {
    ApplicationContext ctx = null;
    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addNewUser() {
        UserService userService = (UserService) ctx.getBean("userService");
        User user = (User) ctx.getBean("user");
        userService.addNewUser(user);
        /*TestEntity testEntity = (TestEntity) ctx.getBean("entity");
        testEntity.showValue();*/
    }
}