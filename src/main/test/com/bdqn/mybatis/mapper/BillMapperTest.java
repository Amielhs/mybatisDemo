package com.bdqn.mybatis.mapper;

import com.bdqn.mybatis.pojo.Bill;
import com.bdqn.mybatis.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @ClassName: BillMapperTest
 * @Description:查看账单测试类
 * @Author: amielhs
 * @Date 2019-06-19
 */
public class BillMapperTest {
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
            count = sqlSession.getMapper(BillMapper.class).count();
        } catch (Exception e) {
            e.printStackTrace();
            count = 0;
        }
        logger.debug("订单记录数：" + count);
    }

    /**
     * @Description:查询账单列表
     * @param: []
     * @return: void
     * @Date: 2019-06-21
     */
    @Test
    public void getBillList(){
        List<Bill> billList = new ArrayList<Bill>();
        //调用getMapper(BillMapper.class)执行Mapper接口方法
        billList = sqlSession.getMapper(BillMapper.class).getBillList();
        for (Bill bill:
                billList) {
            logger.debug(bill.toString());
        }
    }

    /**
     * @Description:通过供货商名，供货商Id，是否支付查询
     * @param: []
     * @return: void
     * @Date: 2019-06-21
     */
    @Test
    public void getBillList1() {
        List<Bill> billList = new ArrayList<Bill>();
        try {
            Bill bill = new Bill();
            bill.setIsPayment(2);
            bill.setProductName("油");
            bill.setProviderId(7);
            billList = sqlSession.getMapper(BillMapper.class).getBillList1(bill);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(Bill bill: billList){
            logger.debug("订单Id: " + bill.getId() +
                    " 订单代号: " + bill.getBillCode() +
                    " 商品名: " + bill.getProductName() +
                    " 总价格: " + bill.getTotalPrice() +
                    " 供货商名: " + bill.getProvider().getProName()+
                    " 是否付款(1：未支付 2：已支付): " + bill.getIsPayment()+
                    " 创建时间:" + new SimpleDateFormat("yyyy-MM-dd").format(bill.getCreationDate()));
        }
    }

    /**
     * @Description:测试根据条件查询订单表(供货商名，供货商Id，是否支付查询)
     * @param: []
     * @return: void
     * @Date: 2019-06-23
     */
    @Test
    public void getBillList2() {
        List<Bill> billList = new ArrayList<Bill>();
        Integer count = 0;
        try {
            String productName = "油";
            int providerId = 7;
            int isPayment = 2;
            billList = sqlSession.getMapper(BillMapper.class).getBillList2(productName,providerId,isPayment);
        } catch (Exception e) {
            e.printStackTrace();
            count = 0;
        }
        for(Bill bill: billList){
            logger.debug("订单Id: " + bill.getId() +
                    " 订单代号: " + bill.getBillCode() +
                    " 商品名: " + bill.getProductName() +
                    " 总价格: " + bill.getTotalPrice() +
                    " 是否付款(1：未支付 2：已支付): " + bill.getIsPayment() +
                    " 供货商Id: " + bill.getProvider().getId() +
                    " 供货商代号:" + bill.getProvider().getProCode() +
                    " 供货商名: " + bill.getProvider().getProName()+
                    " 供货商联系人:" + bill.getProvider().getProContact()+
                    " 供货商电话:" + bill.getProvider().getProPhone());
        }
    }

    /**
     * @Description:增加订单信息
     * @param: []
     * @return: void
     * @Date: 2019-06-23
     */
    @Test
    public void add() {
        int count = 0;
        try {
            Bill bill = new Bill();
            bill.setBillCode("nihao");
            bill.setProductName("香油");
            bill.setProductDesc("年后");
            bill.setProductUnit("斤");
            bill.setProductCount(BigDecimal.valueOf(1200));
            bill.setTotalPrice(BigDecimal.valueOf(2400));
            bill.setIsPayment(1);
            bill.setCreatedBy(1);
            bill.setCreationDate(new Date());
            bill.setProviderId(1);
            count = sqlSession.getMapper(BillMapper.class).add(bill);
            //模拟异常，进行回滚
            //int i = 2/0;
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }
        logger.debug("增加订单的数量: " + count);
    }

    /**
     * @Description:修改订单信息
     * @param: []
     * @return: void
     * @Date: 2019-06-23
     */
    @Test
    public void modify() {
        int count = 0;
        try {
            Bill bill = new Bill();
            bill.setId(19);
            bill.setBillCode("啦啦啦");
            bill.setProductName("香油");
            bill.setProductDesc("ami");
            bill.setProductUnit("元");
            bill.setProductCount(BigDecimal.valueOf(2400));
            bill.setTotalPrice(BigDecimal.valueOf(4000));
            bill.setIsPayment(1);
            bill.setCreatedBy(1);
            bill.setCreationDate(new Date());
            bill.setModifyBy(1);
            bill.setModifyDate(new Date());
            bill.setProviderId(2);
            count = sqlSession.getMapper(BillMapper.class).modify(bill);
            //模拟异常，进行回滚
            //int i = 2/0;
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }
        logger.debug("修改订单的数量: " + count);
    }

    /**
     * @Description:根据订单ID删除订单信息
     * @param: []
     * @return: void
     * @Date: 2019-06-23
     */
    @Test
    public void deleteBillById() {
        int count  = 0;
        Integer billId = 19;
        count = sqlSession.getMapper(BillMapper.class).deleteBillById(billId);
        try{
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }
        logger.debug("删除订单的数量："+count);
    }
}