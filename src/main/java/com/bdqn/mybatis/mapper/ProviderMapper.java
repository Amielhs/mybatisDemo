package com.bdqn.mybatis.mapper;

import com.bdqn.mybatis.pojo.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @ClassName: ProviderMapper
 * @Description:基于mapper接口方式操作供货商数据
 * @Author: amielhs
 * @Date 2019-06-19
 */
public interface ProviderMapper {

    /**
     * @Description:查询供应商表记录数
     * @param: []
     * @return: int
     * @Date: 2019-06-21
     */
    public int count();

    /**
     * @Description:查询供应商列表
     * @param: []
     * @return: java.util.List<com.bdqn.mybatis.pojo.Provider>
     * @Date: 2019-06-19
     */
    public List<Provider> getProviderList();

    /**
     * @Description:根据供应商名称查询供应商列表(模糊查询)
     * @param: [proName]
     * @return: java.util.List<com.bdqn.mybatis.pojo.Provider>
     * @Date: 2019-06-21
     */
    public List<Provider> getProviderListByProName(String proName);

    /**
     * @Description:增加供应商
     * @param: [provider]
     * @return: int
     * @Date: 2019-06-23
     */
    public int add(Provider provider);

    /**
     * @Description:修改供应商信息
     * @param: [provider]
     * @return: int
     * @Date: 2019-06-23
     */
    public int modify(Provider provider);

    /**
     * @Description:根据供应商ID删除供应商信息
     * @param: [delId]
     * @return: int
     * @Date: 2019-06-23
     */
    public int deleteProviderById(@Param("id")Integer delId);

    /**
     * @Description:获取指定供应商的订单列表(collection)
     * @param: [providerId]
     * @return: com.bdqn.mybatis.pojo.Provider
     * @Date: 2019-06-23
     */
    public Provider getBillListByProviderId(@Param("id")Integer providerId);
}
