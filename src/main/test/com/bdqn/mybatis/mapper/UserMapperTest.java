package com.bdqn.mybatis.mapper;

import com.bdqn.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;
/**
 * @ClassName: UserMapperTest
 * @Description:使用sqlSession查看用户测试类
 * @Author: amielhs
 * @Date 2019-06-19
 */
public class UserMapperTest {
    private Logger logger = Logger.getLogger(this.getClass());
    private InputStream is = null;
    private SqlSession sqlSession = null;
    @Before
    public void setUp() throws Exception{
        logger.debug("setUp()方法执行了...");
        //1、读取全局配置文件mybatis-config.xml
        String resource = "mybatis/mybatis-config.xml";
        //获取mybatis-config.xml文件的输入流
        is = Resources.getResourceAsStream(resource);
    }

    @After
    public void tearDown() throws Exception{
        logger.debug("tearDown()方法执行了...");
        //4、关闭SqlSession对象
        sqlSession.close();
    }

    @Test
    public void selectUserCount() throws Exception{
        logger.debug("selectUserCount()方法执行了...");
        //2、创建SqlSessionFactory对象，此对象可以完成对配置文件的读取
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //用户的记录数
        int count = 0;
        //3、创建mybatis三大核心对象之一SqlSession
        sqlSession = factory.openSession();
        //MyBatis通过mapper文件的namespace和子元素的id来找到相应的SQL，从而执行查询操作
        /*count = sqlSession.selectOne("com.bdqn.mybatis.mapper.selectUserCount");
        logger.debug("用户记录数："+count);*/

        //查询所有用户
        List<User> userlist = sqlSession.selectList("com.bdqn.mybatis.mapper.UserMapper.selectUsers");
        for (User user:userlist) {
            logger.debug(user.toString());
        }
    }
}
