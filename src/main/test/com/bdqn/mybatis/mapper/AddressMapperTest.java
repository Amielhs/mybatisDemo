package com.bdqn.mybatis.mapper;

import com.bdqn.mybatis.pojo.Address;
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
 * @ClassName: AddressMapperTest
 * @Description:查看地址测试类
 * @Author: amielhs
 * @Date 2019-06-19
 */
public class AddressMapperTest {
    private Logger logger = Logger.getLogger(this.getClass());
    private SqlSession sqlSession = null;

    @Before
    public void setUp() throws Exception{
        sqlSession = MyBatisUtil.createSqlSession();
    }

    @After
    public void tearDown() throws Exception{
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
            count = sqlSession.getMapper(AddressMapper.class).count();
        } catch (Exception e) {
            e.printStackTrace();
            count = 0;
        }
        logger.debug("地址记录数：" + count);
    }

    /**
     * @Description:查询地址列表
     * @param: []
     * @return: void
     * @Date: 2019-06-23
     */
    @Test
    public void getAddressList() throws Exception{
        List<Address> addressList = new ArrayList<Address>();
        //调用getMapper(Address.class)执行Mapper接口方法
        addressList = sqlSession.getMapper(AddressMapper.class).getAddressList();
        for (Address address:
                addressList) {
            logger.debug(address.toString());
        }
    }

    /**
     * @Description:测试增加地址信息
     * @param: []
     * @return: void
     * @Date: 2019-06-23
     */
    @Test
    public void add() {
        int count = 0;
        try {
            Address address = new Address();
            address.setContact("amielhs");
            address.setAddressDesc("青岛");
            address.setPostCode("10086");
            address.setTel("12343567890");
            address.setCreatedBy(1);
            address.setCreationDate(new Date());
            address.setUserId(4);
            count = sqlSession.getMapper(AddressMapper.class).add(address);
            //模拟异常，进行回滚
            //int i = 2/0;
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }
        logger.debug("增加地址的数量: " + count);
    }

    /**
     * @Description:测试修改地址信息
     * @param: []
     * @return: void
     * @Date: 2019-06-23
     */
    @Test
    public void modify() {
        int count = 0;
        try {
            Address address = new Address();
            address.setId(7);
            address.setContact("amielhs");
            address.setAddressDesc("山东");
            address.setPostCode("10086");
            address.setTel("45673567890");
            address.setCreatedBy(1);
            address.setCreationDate(new Date());
            address.setModifyBy(1);
            address.setModifyDate(new Date());
            address.setUserId(3);
            count = sqlSession.getMapper(AddressMapper.class).modify(address);
            //模拟异常，进行回滚
            //int i = 2/0;
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }
        logger.debug("修改地址的数量: " + count);
    }

    /**
     * @Description:测试根据地址ID删除地址信息
     * @param: []
     * @return: void
     * @Date: 2019-06-23
     */
    @Test
    public void deleteAddressById() {
        int count  = 0;
        Integer addressId = 7;
        count = sqlSession.getMapper(AddressMapper.class).deleteAddressById(addressId);
        try{
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }
        logger.debug("删除地址的数量："+count);
    }
}