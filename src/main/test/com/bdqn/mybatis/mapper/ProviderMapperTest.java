package com.bdqn.mybatis.mapper;

import com.bdqn.mybatis.pojo.Bill;
import com.bdqn.mybatis.pojo.Provider;
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
 * @ClassName: ProviderMapperTest
 * @Description:查看供货商测试类
 * @Author: amielhs
 * @Date 2019-06-19
 */
public class ProviderMapperTest {
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
     * @Description:查询供应商表记录数
     * @param: []
     * @return: void
     * @Date: 2019-06-21
     */
    @Test
    public void count() {
        int count = 0;
        try {
            count = sqlSession.getMapper(ProviderMapper.class).count();
        } catch (Exception e) {
            e.printStackTrace();
            count = 0;
        }
        logger.debug("供应商表记录数：" + count);
    }

    /**
     * @Description:查询供应商列表
     * @param: []
     * @return: void
     * @Date: 2019-06-21
     */
    @Test
    public void getProviderList(){
        List<Provider> providerList = new ArrayList<Provider>();
        //调用getMapper(ProviderMapper.class)执行Mapper接口方法
        providerList = sqlSession.getMapper(ProviderMapper.class).getProviderList();
        for (Provider provider:
                providerList) {
            logger.debug(provider.toString());
        }
    }

    /**
     * @Description:根据供应商名称查询供应商列表(模糊查询)
     * @param: []
     * @return: void
     * @Date: 2019-06-21
     */
    @Test
    public void getProviderListByProName() {
        List<Provider> providerList = new ArrayList<Provider>();
        try {
            //第一种方式:调用selectList方法执行查询操作
            //providerList = sqlSession.selectList("cn.smbms.dao.provider.ProviderMapper.getProviderListByProName","北京");

            //第二种方式:调用getMapper(Mapper.class)执行dao接口方法来实现对数据库的查询操作
            providerList = sqlSession.getMapper(ProviderMapper.class).getProviderListByProName("北京");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(Provider provider: providerList){
            logger.debug("供应商名称代号: " + provider.getProCode() + " ，供应商名: " + provider.getProName());
        }
    }

    /**
     * @Description:测试增加供货商
     * @param: []
     * @return: void
     * @Date: 2019-06-23
     */
    @Test
    public void add() {
        int count = 0;
        try {
            Provider provider = new Provider();
            provider.setProCode("BJ_GYS111");
            provider.setProName("供应商测试");
            provider.setProContact("张三");
            provider.setProAddress("供应商测试地址");
            provider.setProPhone("13566667777");
            provider.setCreatedBy(1);
            provider.setCreationDate(new Date());
            provider.setProFax("010-588876565");
            provider.setProDesc("供应商测试描述");
            count = sqlSession.getMapper(ProviderMapper.class).add(provider);
            //模拟异常，进行回滚
            //int i = 2/0;
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }
        logger.debug("增加供货商的数量: " + count);
    }

    /**
     * @Description:测试修改供应商信息
     * @param: []
     * @return: void
     * @Date: 2019-06-23
     */
    @Test
    public void modify() {
        int count = 0;
        try {
            Provider provider = new Provider();
            provider.setId(16);
            provider.setProCode("BJ_GYS123");
            provider.setProName("供应商测试修改");
            provider.setProContact("李四");
            provider.setProAddress("供应商测试地址修改");
            provider.setProPhone("13500002222");
            provider.setModifyBy(1);
            provider.setModifyDate(new Date());
            provider.setProFax("010-588876565");
            provider.setProDesc("供应商测试描述修改");
            count = sqlSession.getMapper(ProviderMapper.class).modify(provider);
            //模拟异常，进行回滚
            //int i = 2/0;
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }
        logger.debug("修改供货商的数量: " + count);
    }

    /**
     * @Description:测试根据供应商ID删除供应商信息
     * @param: []
     * @return: void
     * @Date: 2019-06-23
     */
    @Test
    public void deleteProviderById() {
        Integer delId = 16;
        int count = 0;
        try {
            count = sqlSession.getMapper(ProviderMapper.class).deleteProviderById(delId);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }
        logger.debug("删除供货商的数量："+count);
    }

    /**
     * @Description:测试获取指定供应商的订单列表(collection)
     * @param: []
     * @return: void
     * @Date: 2019-06-23
     */
    @Test
    public void getBillListByProviderId() {
        Provider provider = null;
        Integer providerId = 1;
        provider = sqlSession.getMapper(ProviderMapper.class).getBillListByProviderId(providerId);
        if (provider!=null){
            logger.debug("供货商代号："+provider.getProCode()+"，供货商名："+provider.getProName()+"，供货商联系人："+provider.getProContact()+"，供货商电话："+provider.getProPhone());
            if (provider.getBillList().size()>0){
                for (Bill bill:provider.getBillList()){
                    logger.debug("订单Id："+bill.getId()+"，订单代号："+bill.getBillCode()+"，商品名："+bill.getProductName()+"，总价格："+bill.getTotalPrice()+"，是否支付："+bill.getIsPayment());
                }
            }else {
                logger.debug("该供应商下无订单");
            }
        }else {
            logger.debug("查无此供应商！");
        }
    }
}