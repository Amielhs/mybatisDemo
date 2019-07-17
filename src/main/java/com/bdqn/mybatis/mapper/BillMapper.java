package com.bdqn.mybatis.mapper;

import com.bdqn.mybatis.pojo.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @ClassName: BillMapper
 * @Description:基于mapper接口方式操作账单数据
 * @Author: amielhs
 * @Date 2019-06-19
 */
public interface BillMapper {

    /**
     * @Description:查询订单记录数
     * @param: []
     * @return: int
     * @Date: 2019-06-23
     */
    public int count();

    /**
     * @Description:查询账单列表
     * @param: []
     * @return: java.util.List<com.bdqn.mybatis.pojo.Bill>
     * @Date: 2019-06-19
     */
    public List<Bill> getBillList();

    /**
     * @Description:通过供货商名，供货商Id，是否支付查询
     * @param: [bill]
     * @return: java.util.List<com.bdqn.mybatis.pojo.Bill>
     * @Date: 2019-06-21
     */
    public List<Bill> getBillList1(Bill bill);

    /**
     * @Description:根据条件查询订单表(供货商名，供货商Id，是否支付查询)association方法
     * @param: [productName, providerId, isPayment]
     * @return: java.util.List<com.bdqn.mybatis.pojo.Bill>
     * @Date: 2019-06-23
     */
    public List<Bill> getBillList2(@Param("productName")String productName,
                                  @Param("providerId")Integer providerId,
                                  @Param("isPayment")Integer isPayment);

    /**
     * @Description:增加订单信息
     * @param: [bill]
     * @return: int
     * @Date: 2019-06-23
     */
    public int add(Bill bill);

    /**
     * @Description:修改订单信息
     * @param: [bill]
     * @return: int
     * @Date: 2019-06-23
     */
    public int modify(Bill bill);

    /**
     * @Description:根据订单ID删除订单信息
     * @param: [delId]
     * @return: int
     * @Date: 2019-06-23
     */
    public int deleteBillById(@Param("id")Integer delId);
}
