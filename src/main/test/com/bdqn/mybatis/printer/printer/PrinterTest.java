package com.bdqn.mybatis.printer.printer;

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

public class PrinterTest {
    ApplicationContext context = null;
    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void print() {
        //通过Printer bean 的id来获取Printer实例
        Printer printer = (Printer) context.getBean("printer");
        String content = "曾经有一份真挚的感情放在我的面前，我没有好好的珍惜，等到失去后，" +
                "我才后悔莫急！人世间最痛苦的事莫过于此。如果老天能再给我一次机会的话，我会" +
                "对那女孩说三个字：“我爱你！”如果非要加上一个期限的话，我希望是一万年！";
        printer.print(content);
        /*printer.print("Long long ago, there was a sincer cordial emotion in front of me, " +
                "but I didn't cherish it. Until it lost, I just regreted at that time. It is" +
                " only the most suffering thing in the world. If the grandfather of heaven give " +
                "me the last opportunity. I will say three words to that girl:\"I love you!\" If it has" +
                " to add an alloted time. I hope it is 10,000 years.");*/
    }

}