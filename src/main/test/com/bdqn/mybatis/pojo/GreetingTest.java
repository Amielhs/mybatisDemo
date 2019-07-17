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

public class GreetingTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void sayGreeting() {
        //通过ClassPathXmlApplicationContext显示地实例化Spring的上下文
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        //通过id获取Greeting bean的实例
        Greeting zhangGa = (Greeting) context.getBean("zhangGa");
        Greeting rod = (Greeting) context.getBean("rod");
        //执行sayGreeting()方法
        zhangGa.sayGreeting();
        rod.sayGreeting();
    }
}