package com.bdqn.mybatis.service;

import com.bdqn.mybatis.pojo.User;

/**
 * @ClassName: UserService
 * @Description:用户业务接口，定义了所需的业务方法
 * @Author: amielhs
 * @Date 2019-06-26
 */
public interface UserService {
    /**
     * @Description:添加新闻用户
     * @param: [user]
     * @return: java.lang.Integer
     * @Date: 2019-06-27
     */
    public Integer addNewUser(User user);

}
