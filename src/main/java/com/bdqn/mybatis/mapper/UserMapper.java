package com.bdqn.mybatis.mapper;

import com.bdqn.mybatis.pojo.Address;
import com.bdqn.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserMapper
 * @Description:基于mapper接口方式操作用户数据
 * @Author: amielhs
 * @Date 2019-06-19
 */
public interface UserMapper {

    /**
     * @Description:查询用户表记录数
     * @param: []
     * @return: int
     * @Date: 2019-06-19
     */
    public int selectUserCount();

    /**
     * @Description:查询用户列表
     * @param: []
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-06-19
     */
    public List<User> getAllUserList();

    /**
     * @Description:根据用户名称查询用户列表(模糊查询)
     * @param: [userName]
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-06-19
     */
    public List<User> getUserListByUserName(String userName);

    /**
     * @Description:多条件查询用户列表(参数：对象入参)
     * @param: [user]
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-06-19
     */
    public List<User> getUserList(User user);

    /**
     * @Description:查询用户列表(参数：Map)
     * @param: [userMap]
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-06-19
     */
    public List<User> getUserListByMap(Map<String,String> userMap);


    /**
     * @Description:通过ResultMap自定义映射查询用户列表
     * @param: []
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-06-20
     */
    public List<User> getResultMapUserList(User user);

    /**
     * @Description:通过多条件查询用户(包含用户角色信息)对象入参
     * @param: [user]
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-06-20
     */
    public List<User> getUserListUnion(User user);

    /**
     * @Description:通过多条件查询用户(包含用户角色信息)对象入参,进行分页查询
     * @param: [user, currentPageNo, pageSize]
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-06-25
     */
    public List<User> getUserListUnionPage(@Param("user") User user,@Param("from") Integer currentPageNo,@Param("pageSize") Integer pageSize);

    /**
     * @Description:添加用户
     * @param: [user]
     * @return: int
     * @Date: 2019-06-20
     */
    public int add(User user);

    /**
     * @Description:通过用户id，修改用户
     * @param: [user]
     * @return: int
     * @Date: 2019-06-20
     */
    public int modify(User user);

    /**
     * @Description:通过用户id，修改用户密码
     * @param: [id, pwd]
     * @return: int
     * @Date: 2019-06-20
     */
    public int updatePwd(@Param("id")Integer id, @Param("userPassword")String pwd);

    /**
     * @Description:通过用户id，删除用户
     * @param: [delId]
     * @return: int
     * @Date: 2019-06-20
     */
    public int deleteUserById(@Param("id")Integer delId);

    /**
     * @Description:根据roleId获取用户列表(association)
     * @param: [roleId]
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-06-21
     */
    public List<User> getUserListByRoleId(@Param("userRole")Integer roleId);

    /**
     * @Description:根据roleId获取用户列表(此方法可以进行role结果映射复用)
     * @param: [roleId]
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-06-21
     */
    public List<User> getUserListByRoleIdFuYong(@Param("userRole")Integer roleId);

    /**
     * @Description:获取指定用户的地址列表(collection)
     * @param: [userId]
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-06-21
     */
    public List<User> getAddressListByUserId(@Param("id")Integer userId);

    /**
     * @Description:获取指定用户的地址列表(collection)(此方法可以进行address结果映射复用)
     * @param: [userId]
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-06-21
     */
    public List<User> getAddressListByUserIdFuYong(@Param("id")Integer userId);

    /**
     * @Description:resultMap自动映射级别(需配置<setting name="autoMappingBehavior" value="FULL"/>显示密码和用户Id)
     * 获取指定用户的地址列表(user表-address表：1对多关系)
     * @param: [userId]
     * @return: com.bdqn.mybatis.pojo.User
     * @Date: 2019-06-21
     */
    public User getAddressListByUserIdTest(@Param("id")Integer userId);

    /**
     * @Description:通过用户名和用户角色查询用户列表
     * @param: [userName, userRole]
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-06-23
     */
    public List<User> getUserListByuserNameAnduserRole(@Param("userName")String userName,
                                  @Param("userRole")Integer userRole);

    /**
     * @Description:随机修改用户信息，不修改的则为原来的
     * @param: [user]
     * @return: int
     * @Date: 2019-06-23
     */
    public int modifyBySuiJi(User user);

    /**
     * @Description:根据用户角色列表，获取该角色列表下用户列表信息-foreach_array
     * @param: [roleId]
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-06-24
     */
    public List<User> getUserByRoleId_foreach_array(Integer[] roleIds);

    /**
     * @Description:根据用户角色列表，获取该角色列表下用户列表信息-foreach_list
     * @param: [roleList]
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-06-24
     */
    public List<User> getUserByRoleId_foreach_list(List<Integer> roleList);

    /**
     * @Description:根据用户角色列表和性别(多参数)，获取该角色列表下指定性别的用户列表信息-foreach_map
     * @param: [conditionMap]
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-06-24
     */
    public List<User> getUserByConditionMap_foreach_map(Map<String,Object> conditionMap);

    /**
     * @Description:根据用户角色列表，获取该角色列表下用户列表信息-foreach_map(单参数封装成map)
     * @param: [roleMap]
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-06-24
     */
    public List<User> getUserByRoleId_foreach_map(Map<String,Object> roleMap);

    /**
     * @Description:查询用户列表(choose)
     * @param: [userName, roleId, userCode, creationDate]
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-06-24
     */
    public List<User> getUserList_choose(@Param("userName")String userName,
                                         @Param("userRole")Integer roleId,
                                         @Param("userCode")String userCode,
                                         @Param("creationDate") Date creationDate);

    /**
     * @Description:查询用户列表(分页显示)
     * @param: [userName, roleId, currentPageNo, pageSize]
     * @return: java.util.List<com.bdqn.mybatis.pojo.User>
     * @Date: 2019-06-24
     */
    public List<User> getUserListByPage(@Param("userName")String userName,
                                  @Param("userRole")Integer roleId,
                                  @Param("from")Integer currentPageNo,
                                  @Param("pageSize")Integer pageSize);

    /**
     * @Description:模拟插入一条用户数据
     * @param: [user]
     * @return: java.lang.Integer
     * @Date: 2019-06-27
     */
    public Integer insertUser(User user);

}
