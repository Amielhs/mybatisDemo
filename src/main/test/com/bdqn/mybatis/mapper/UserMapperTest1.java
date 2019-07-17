package com.bdqn.mybatis.mapper;

import com.bdqn.mybatis.pojo.User;
import com.bdqn.mybatis.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @ClassName: UserMapperTest
 * @Description:查看用户测试类
 * @Author: amielhs
 * @Date 2019-06-19
 */
public class UserMapperTest1 {
    private Logger logger = Logger.getLogger(this.getClass());
    private SqlSession sqlSession = null;

    @Before
    public void setUp() throws Exception{
        logger.debug("setUp()方法执行了...");
        sqlSession = MyBatisUtil.createSqlSession();
    }

    @After
    public void tearDown() throws Exception{
        logger.debug("tearDown()方法执行了...");
        MyBatisUtil.closeSqlSession(sqlSession);
    }

    @Test
    public void selectUserById() throws Exception{
        logger.debug("selectUserCount()方法执行了...");
        User user = sqlSession.selectOne("com.bdqn.mybatis.mapper.UserMapper.selectUserById");
        logger.debug(user.toString());
    }
}
