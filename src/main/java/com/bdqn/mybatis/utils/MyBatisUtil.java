package com.bdqn.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName: MyBatisUtil
 * @Description:MyBatis工具类
 * @Author: amielhs
 * @Date 2019-06-19
 */
public class MyBatisUtil {
    private static SqlSessionFactory factory;
    //在静态代码块中，factory只会被加载一次
    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description:获取SqlSession对象
     * @param: []
     * @return: org.apache.ibatis.session.SqlSession
     * @Date: 2019-06-19
     */
    public static SqlSession createSqlSession(){
        return  factory.openSession(false);//true为自动提交事务
    }

    /**
     * @Description:关闭SqlSession对象
     * @param: [sqlSession]
     * @return: void
     * @Date: 2019-06-19
     */
    public static void closeSqlSession(SqlSession sqlSession){
        if (null!=sqlSession){
            sqlSession.close();
        }
    }
}
