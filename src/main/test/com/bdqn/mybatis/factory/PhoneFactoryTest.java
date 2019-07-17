package com.bdqn.mybatis.factory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneFactoryTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void producePhone() {
        PhoneFactory phoneFactory = new PhoneFactory();
        PhoneInterface phoneInterface = null;
        //phoneInterface = phoneFactory.producePhone("miphone");
        //phoneInterface = phoneFactory.producePhone("iphone");
        phoneInterface = phoneFactory.producePhone("huaphone");
        phoneInterface.playGame();
        phoneInterface.call();
    }
}