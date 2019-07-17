package com.bdqn.mybatis.mapper;

import com.bdqn.mybatis.pojo.Role;
import com.bdqn.mybatis.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: RoleMapperTest
 * @Description:查看角色测试类
 * @Author: amielhs
 * @Date 2019-06-19
 */
public class RoleMapperTest {
    private Logger logger = Logger.getLogger(this.getClass());
    private SqlSession sqlSession = null;
    @Before
    public void setUp() throws Exception {
        sqlSession = MyBatisUtil.createSqlSession();
    }

    @After
    public void tearDown() throws Exception {
        MyBatisUtil.closeSqlSession(sqlSession);
    }

    /**
     * @Description:测试查询订单记录数
     * @param: []
     * @return: void
     * @Date: 2019-06-23
     */
    @Test
    public void count() {
        int count = 0;
        try {
            count = sqlSession.getMapper(RoleMapper.class).count();
        } catch (Exception e) {
            e.printStackTrace();
            count = 0;
        }
        logger.debug("角色记录数：" + count);
    }

    /**
     * @Description:查询角色列表
     * @param: []
     * @return: void
     * @Date: 2019-06-23
     */
    @Test
    public void getRoleList() throws Exception {
        List<Role> roleList = new ArrayList<Role>();
        //调用getMapper(RoleMapper.class)执行Mapper接口方法
        roleList = sqlSession.getMapper(RoleMapper.class).getRoleList();
        for (Role role:
                roleList) {
            logger.debug(role.toString());
        }
    }

    /**
     * @Description:测试增加角色信息
     * @param: []
     * @return: void
     * @Date: 2019-06-23
     */
    @Test
    public void add() {
        int count = 0;
        try {
            Role role = new Role();
            role.setRoleCode("SMBMS_EMPLOYEE");
            role.setRoleName("普通员工");
            role.setCreatedBy(1);
            role.setCreationDate(new Date());
            count = sqlSession.getMapper(RoleMapper.class).add(role);
            //模拟异常，进行回滚
            //int i = 2/0;
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }
        logger.debug("增加角色的数量: " + count);
    }

    /**
     * @Description:测试修改角色信息
     * @param: []
     * @return: void
     * @Date: 2019-06-23
     */
    @Test
    public void modify() {
        int count = 0;
        try {
            Role role = new Role();
            role.setId(4);
            role.setRoleCode("你好");
            role.setRoleName("高级员工");
            role.setCreatedBy(1);
            role.setCreationDate(new Date());
            role.setModifyBy(2);
            role.setModifyDate(new Date());
            count = sqlSession.getMapper(RoleMapper.class).modify(role);
            //模拟异常，进行回滚
            //int i = 2/0;
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }
        logger.debug("修改角色的数量: " + count);
    }

    /**
     * @Description:测试根据角色ID删除角色信息
     * @param: []
     * @return: void
     * @Date: 2019-06-23
     */
    @Test
    public void deleteRoleById() {
        int count  = 0;
        Integer roleId = 4;
        count = sqlSession.getMapper(RoleMapper.class).deleteRoleById(roleId);
        try{
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }
        logger.debug("删除角色的数量："+count);
    }
}