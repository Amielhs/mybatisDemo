package com.bdqn.mybatis.service.impl;

import com.bdqn.mybatis.mapper.BillMapper;
import com.bdqn.mybatis.mapper.UserMapper;
import com.bdqn.mybatis.pojo.User;
import com.bdqn.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: UserServiceImpl
 * @Description:用户业务类，实现对User功能的业务管理
 * @Author: amielhs
 * @Date 2019-06-26
 */
/*@Component("userService")*/
@Service("userService")
public class UserServiceImpl implements UserService {
    // 声明接口类型的引用，和具体实现类解耦合
    /*@Autowired //默认按类型匹配
    @Qualifier("userMapper") //按指定名称匹配*/

    @Resource //默认按类型匹配
    @Qualifier("userMapper") //按指定名称匹配
    private UserMapper userMapper;

    //使用p标签是必须打开setUserMapper()方法
    //使用@Autowired直接为属性注入，可以省略setter方法
    //查找名为userMapper的Bean，并注入给setter方法
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserServiceImpl() {
    }

    //用userMapper属性赋值的构造方法，此时不需要用setUserMapper()方法
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Integer addNewUser(User user) {
        userMapper.insertUser(user);
        return 1;
    }

}
