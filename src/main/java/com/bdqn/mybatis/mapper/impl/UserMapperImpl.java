package com.bdqn.mybatis.mapper.impl;

import com.bdqn.mybatis.mapper.UserMapper;
import com.bdqn.mybatis.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserMapperImpl
 * @Description:用户实体映射接口实现类
 * @Author: amielhs
 * @Date 2019-06-27
 */
/*@Component("UserMapper")*/
@Repository("userMapper")
public class UserMapperImpl implements UserMapper {
    private static final Logger log = Logger.getLogger(UserMapperImpl.class);

    @Override
    public int selectUserCount() {
        return 0;
    }

    @Override
    public List<User> getAllUserList() {
        return null;
    }

    @Override
    public List<User> getUserListByUserName(String userName) {
        return null;
    }

    @Override
    public List<User> getUserList(User user) {
        return null;
    }

    @Override
    public List<User> getUserListByMap(Map<String, String> userMap) {
        return null;
    }

    @Override
    public List<User> getResultMapUserList(User user) {
        return null;
    }

    @Override
    public List<User> getUserListUnion(User user) {
        return null;
    }

    @Override
    public List<User> getUserListUnionPage(User user, Integer currentPageNo, Integer pageSize) {
        return null;
    }

    @Override
    public int add(User user) {
        return 0;
    }

    @Override
    public int modify(User user) {
        return 0;
    }

    @Override
    public int updatePwd(Integer id, String pwd) {
        return 0;
    }

    @Override
    public int deleteUserById(Integer delId) {
        return 0;
    }

    @Override
    public List<User> getUserListByRoleId(Integer roleId) {
        return null;
    }

    @Override
    public List<User> getUserListByRoleIdFuYong(Integer roleId) {
        return null;
    }

    @Override
    public List<User> getAddressListByUserId(Integer userId) {
        return null;
    }

    @Override
    public List<User> getAddressListByUserIdFuYong(Integer userId) {
        return null;
    }

    @Override
    public User getAddressListByUserIdTest(Integer userId) {
        return null;
    }

    @Override
    public List<User> getUserListByuserNameAnduserRole(String userName, Integer userRole) {
        return null;
    }

    @Override
    public int modifyBySuiJi(User user) {
        return 0;
    }

    @Override
    public List<User> getUserByRoleId_foreach_array(Integer[] roleIds) {
        return null;
    }

    @Override
    public List<User> getUserByRoleId_foreach_list(List<Integer> roleList) {
        return null;
    }

    @Override
    public List<User> getUserByConditionMap_foreach_map(Map<String, Object> conditionMap) {
        return null;
    }

    @Override
    public List<User> getUserByRoleId_foreach_map(Map<String, Object> roleMap) {
        return null;
    }

    @Override
    public List<User> getUserList_choose(String userName, Integer roleId, String userCode, Date creationDate) {
        return null;
    }

    @Override
    public List<User> getUserListByPage(String userName, Integer roleId, Integer currentPageNo, Integer pageSize) {
        return null;
    }

    @Override
    public Integer insertUser(User user) {
        log.debug("模拟添加新用户成功");
        //throw new RuntimeException("为测试程序运行效果抛出的异常");
        return 1;
    }
}
