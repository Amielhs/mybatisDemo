package com.bdqn.mybatis.mapper;

import com.bdqn.mybatis.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @ClassName: RoleMapper
 * @Description:基于mapper接口方式操作角色数据
 * @Author: amielhs
 * @Date 2019-06-19
 */
public interface RoleMapper {

    /**
     * @Description:查询角色记录数
     * @param: []
     * @return: int
     * @Date: 2019-06-23
     */
    public int count();

    /**
     * @Description:查询角色列表
     * @param: []
     * @return: java.util.List<com.bdqn.mybatis.pojo.Role>
     * @Date: 2019-06-19
     */
    public List<Role> getRoleList();

    /**
     * @Description:增加角色信息
     * @param: [role]
     * @return: int
     * @Date: 2019-06-23
     */
    public int add(Role role);

    /**
     * @Description:修改角色信息
     * @param: [role]
     * @return: int
     * @Date: 2019-06-23
     */
    public int modify(Role role);

    /**
     * @Description:根据角色ID删除角色信息
     * @param: [delId]
     * @return: int
     * @Date: 2019-06-23
     */
    public int deleteRoleById(@Param("id")Integer delId);
}
