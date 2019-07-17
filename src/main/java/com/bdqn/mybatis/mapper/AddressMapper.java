package com.bdqn.mybatis.mapper;

import com.bdqn.mybatis.pojo.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @ClassName: AddressMapper
 * @Description:基于mapper接口方式操作地址数据
 * @Author: amielhs
 * @Date 2019-06-19
 */
public interface AddressMapper {

    /**
     * @Description:查询地址记录数
     * @param: []
     * @return: int
     * @Date: 2019-06-23
     */
    public int count();

    /**
     * @Description:查询地址列表
     * @param: []
     * @return: java.util.List<com.bdqn.mybatis.pojo.Address>
     * @Date: 2019-06-19
     */
    public List<Address> getAddressList()throws Exception;

    /**
     * @Description:增加地址信息
     * @param: [address]
     * @return: int
     * @Date: 2019-06-23
     */
    public int add(Address address);

    /**
     * @Description:修改地址信息
     * @param: [address]
     * @return: int
     * @Date: 2019-06-23
     */
    public int modify(Address address);

    /**
     * @Description:根据地址ID删除地址信息
     * @param: [delId]
     * @return: int
     * @Date: 2019-06-23
     */
    public int deleteAddressById(@Param("id")Integer delId);
}
