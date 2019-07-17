package com.bdqn.mybatis.pojo;

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

public class HelloSpringTest {
    ApplicationContext context = null;

    @Before
    public void setUp() throws Exception {
        /*使用Spring框架进行测试*/
        context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void print() {
       /* HelloSpring helloSpring = new HelloSpring();
        helloSpring.setName("Spring");
        helloSpring.print();*/

        HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
        helloSpring.print();
    }
}