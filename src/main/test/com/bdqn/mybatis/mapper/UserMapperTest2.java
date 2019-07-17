package com.bdqn.mybatis.mapper;

import com.bdqn.mybatis.pojo.Address;
import com.bdqn.mybatis.pojo.User;
import com.bdqn.mybatis.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserMapperTest
 * @Description:实现Mapper接口方式查看用户测试类
 * @Author: amielhs
 * @Date 2019-06-19
 */
public class UserMapperTest2 {
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
     * @Description:测试查询用户数量
     * @param: []
     * @return: void
     * @Date: 2019-06-19
     */
    @Test
    public void selectUserCount(){
        int count = 0;
        count = sqlSession.getMapper(UserMapper.class).selectUserCount();
        logger.debug("用户的数量："+count);
    }
    /**
     * @Description:测试查询所有用户
     * @param: []
     * @return: void
     * @Date: 2019-06-19
     */
    @Test
    public void getAllUserList() throws Exception{
        List<User> userList = new ArrayList<User>();
        //调用getMapper(UserMapper.class)执行Mapper接口方法
        userList = sqlSession.getMapper(UserMapper.class).getAllUserList();
        for (User user:
             userList) {
            logger.debug(user.toString());
        }
    }

    /**
     * @Description:测试根据用户名称查询用户列表(模糊查询)
     * @param: []
     * @return: void
     * @Date: 2019-06-19
     */
    @Test
    public void getUserListByUserName(){
        List<User> userList = new ArrayList<User>();
        userList = sqlSession.getMapper(UserMapper.class).getUserListByUserName("赵");
        for (User user:
             userList) {
            logger.debug("用户代号："+user.getUserCode()+"\t用户名："+user.getUserName());
        }
    }

    /**
     * @Description:测试查询用户列表(参数：对象入参)
     * @param: []
     * @return: void
     * @Date: 2019-06-19
     */
    @Test
    public void testGetUserList(){
        List<User> userList = new ArrayList<User>();
            User user = new User();
            user.setUserName("赵");
            user.setUserRole(3);
            //第一种方式:调用selectList方法执行查询操作
            //userList = sqlSession.selectList("com.bdqn.mybatis.mapper.UserMapper.getUserList",user);
            //第二种方式:调用getMapper(Mapper.class)执行dao接口方法来实现对数据库的查询操作
            userList = sqlSession.getMapper(UserMapper.class).getUserList(user);
        for(User user1: userList){
            logger.debug("用户代号: " + user1.getUserCode() + " \t用户名: " + user1.getUserName());
        }
    }

    /**
     * @Description:测试查询用户列表(参数：Map)
     * @param: []
     * @return: void
     * @Date: 2019-06-19
     */
    @Test
    public void testGetUserListByMap(){
        List<User> userList = new ArrayList<User>();
            Map<String, String> userMap = new HashMap<String, String>();
            userMap.put("uName", "");
            userMap.put("uRole", "3");
            //第一种方式:调用selectList方法执行查询操作
            //userList = sqlSession.selectList("com.bdqn.mybatis.mapper.UserMapper.getUserListByMap",userMap);
            //第二种方式:调用getMapper(Mapper.class)执行dao接口方法来实现对数据库的查询操作
            userList = sqlSession.getMapper(UserMapper.class).getUserListByMap(userMap);
        for(User user: userList){
            logger.debug("用户代号: " + user.getUserCode() + " \t用户名: " + user.getUserName());
        }
    }

    /**
     * @Description:通过ResultMap自定义映射查询用户列表
     * @param: []
     * @return: void
     * @Date: 2019-06-20
     */
    @Test
    public void getResultMapUserList(){
        List<User> userList = new ArrayList<User>();
        User user = new User();
        user.setUserName("赵");
        user.setUserRole(3);
        userList = sqlSession.getMapper(UserMapper.class).getResultMapUserList(user);

        /**
         * 若设置resultMap的自动映射级别为NONE，
         * 那么没有进行映射匹配的属性（比如：address等）则输出为null
         * 若不设置resultMap的自动映射级别，则不管是否进行了映射，所有的属性值均可输出
         */
        for(User user1: userList){
            logger.debug("用户代号: " + user1.getUserCode() +
                    " 用户名: " + user1.getUserName() +
                    " 用户角色: " + user1.getUserRole() +
                    " 用户角色名: " + user1.getUserRoleName() +
                    " 年龄: " + user1.getAge() +
                    " 地址: " + user1.getAddress());
        }
    }

    /**
     * @Description:通过多条件查询用户(包含用户角色信息)对象入参
     * @param: []
     * @return: void
     * @Date: 2019-06-20
     */
    @Test
    public void getUserListUnion() {
        List<User> userList = new ArrayList<User>();
        User user = new User();
        user.setUserName("系");
        user.setUserRole(1);
        userList = sqlSession.getMapper(UserMapper.class).getUserListUnion(user);
        for(User user1: userList){
            logger.debug(user1.toString());
        }
    }

    /**
     * @Description:通过多条件查询用户(包含用户角色信息)对象入参,进行分页查询
     * @param: []
     * @return: void
     * @Date: 2019-06-20
     */
    @Test
    public void getUserListUnionPage() {
        List<User> userList = new ArrayList<User>();
        User user1 = new User();
        user1.setUserName("孙");
        user1.setUserRole(3);
        Integer currentPageNo = 0;
        Integer pageSize = 5;
        userList = sqlSession.getMapper(UserMapper.class).getUserListUnionPage(user1,currentPageNo,pageSize);
        for(User user: userList){
            logger.debug(
                    " 用户代号: " + user.getUserRole() +
                    " ，用户名:  " + user.getUserName() +
                    " ，用户角色名:  " + user.getRole().getRoleName() +
                    " ，用户角色代号:  " + user.getRole().getRoleCode()
              );
        }
    }

    /**
     * @Description:添加用户
     * @param: []
     * @return: void
     * @Date: 2019-06-20
     */
    @Test
    public void add() throws ParseException {
        int count = 0;
        try {
            User user = new User();
            user.setUserCode("test001");
            user.setUserName("测试用户001");
            user.setUserPassword("1234567");
            Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse("1984-12-12");
            user.setBirthday(birthday);
            user.setCreationDate(new Date());
            user.setAddress("地址测试");
            user.setGender(1);
            user.setPhone("13688783697");
            user.setUserRole(1);
            user.setCreatedBy(1);
            user.setCreationDate(new Date());
            count = sqlSession.getMapper(UserMapper.class).add(user);
            //模拟异常，进行回滚
            //int i = 2/0;
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }
        logger.debug("添加用户的数量: " + count);
    }

    /**
     * @Description:通过用户id，修改用户
     * @param: []
     * @return: void
     * @Date: 2019-06-20
     */
    @Test
    public void modify() {
        int count = 0;
        try {
            User user = new User();
            user.setId(18);
            user.setUserCode("admin");
            user.setUserName("测试用户修改");
            user.setUserPassword("0000000");
            Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse("1980-10-10");
            user.setBirthday(birthday);
            user.setCreationDate(new Date());
            user.setAddress("地址测试修改");
            user.setGender(2);
            user.setPhone("13600002222");
            user.setUserRole(2);
            user.setModifyBy(1);
            user.setModifyDate(new Date());
            count = sqlSession.getMapper(UserMapper.class).modify(user);
            //模拟异常，进行回滚
            //int i = 2/0;
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }
        logger.debug("修改用户的数量: " + count);
    }

    /**
     * @Description:通过用户id，修改用户密码
     * @param: []
     * @return: void
     * @Date: 2019-06-20
     */
    @Test
    public void updatePwd() {
        String pwd = "8888888";
        Integer id = 1;
        int count = 0;
        try {
            count = sqlSession.getMapper(UserMapper.class).updatePwd(id, pwd);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }
        logger.debug("修改用户密码的数量： " + count);
    }

    /**
     * @Description:通过用户id，删除用户
     * @param: []
     * @return: void
     * @Date: 2019-06-20
     */
    @Test
    public void deleteUserById() {
        Integer delId = 16;
        int count = 0;
        try{
            count = sqlSession.getMapper(UserMapper.class).deleteUserById(delId);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }
        logger.debug("删除用户的数量:"+count);
    }

    /**
     * @Description:测试根据roleId获取用户列表(association)
     * @param: []
     * @return: void
     * @Date: 2019-06-21
     */
    @Test
    public void getUserListByRoleId() {
        List<User> userList = new ArrayList<User>();
        Integer roleId = 3;
        userList = sqlSession.getMapper(UserMapper.class).getUserListByRoleId(roleId);
        logger.debug("通过角色Id查询到角色的数量："+userList.size());
        for (User user:
             userList) {
           logger.debug("用户名："+user.getUserName()+"\t角色Id："+user.getRole().getId()+"\t角色代号："+user.getRole().getRoleCode()+"\t角色名："+user.getRole().getRoleName());
        }
    }

    /**
     * @Description:测试根据roleId获取用户列表(此方法可以进行role结果映射复用)
     * @param: []
     * @return: void
     * @Date: 2019-06-21
     */
    @Test
    public void getUserListByRoleIdFuYong() {
        List<User> userList = new ArrayList<User>();
        Integer roleId = 3;
        userList = sqlSession.getMapper(UserMapper.class).getUserListByRoleIdFuYong(roleId);
        logger.debug("通过角色Id查询到角色的数量："+userList.size());
        for (User user:
                userList) {
            logger.debug("用户名："+user.getUserName()+"\t角色Id："+user.getRole().getId()+"\t角色代号："+user.getRole().getRoleCode()+"\t角色名："+user.getRole().getRoleName());
        }
    }

    /**
     * @Description:resultMap自动映射级别(需配置<setting name="autoMappingBehavior" value="FULL"/>显示密码)
     * @param: []
     * @return: void
     * @Date: 2019-06-21
     */
    @Test
    public void getUserListByRoleIdTest(){
        List<User> userList = new ArrayList<User>();
        Integer roleId = 3;
        try {
            userList = sqlSession.getMapper(UserMapper.class).getUserListByRoleIdFuYong(roleId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug("通过角色Id查询到角色的数量：" + userList.size());
        for(User user:userList){
            logger.debug("用户名: " + user.getUserName()
                    +", <未做映射字段>用户密码：" + user.getUserPassword()
                    + ", 角色： " + user.getRole().getId() + " 角色代号： "
                    + user.getRole().getRoleCode() +" 角色名： " + user.getRole().getRoleName());
        }
    }

    /**
     * @Description:获取指定用户的地址列表(collection)
     * @param: []
     * @return: void
     * @Date: 2019-06-21
     */
    @Test
    public void getAddressListByUserId() {
        List<User> userList = new ArrayList<User>();
        Integer userId = 1;
        userList = sqlSession.getMapper(UserMapper.class).getAddressListByUserId(userId);
        for (User user: userList ) {
            logger.debug("用户角色(包含地址)："+user.getUserCode()+"\t用户名："+user.getUserName());
            for (Address address:user.getAddressList()
                 ) {
                logger.debug("地址Id："+address.getId()+"\t联系人："+address.getContact()+"\t详细地址："+address.getAddressDesc()+"\t电话："+address.getTel()+"\t邮政编码："+address.getPostCode());
            }
        }
    }

    /**
     * @Description:测试获取指定用户的地址列表(collection)(此方法可以进行address结果映射复用)
     * @param: []
     * @return: void
     * @Date: 2019-06-21
     */
    @Test
    public void getAddressListByUserIdFuYong() {
        List<User> userList = new ArrayList<User>();
        Integer userId = 1;
        userList = sqlSession.getMapper(UserMapper.class).getAddressListByUserIdFuYong(userId);
        for (User user: userList ) {
            logger.debug("用户角色(包含地址)："+user.getUserCode()+"\t用户名："+user.getUserName());
            for (Address address:user.getAddressList()
            ) {
                logger.debug("地址Id："+address.getId()+"\t联系人："+address.getContact()+"\t详细地址："+address.getAddressDesc()+"\t电话："+address.getTel()+"\t邮政编码："+address.getPostCode());
            }
        }
    }

    /**
     * @Description:resultMap自动映射级别(需配置<setting name="autoMappingBehavior" value="FULL"/>显示密码和用户Id)
     * 获取指定用户的地址列表(user表-address表：1对多关系)
     * @param: []
     * @return: void
     * @Date: 2019-06-21
     */
    @Test
    public void getAddressListByUserIdTest(){
        User user = null;
        Integer userId = 1;
        try {
            user = sqlSession.getMapper(UserMapper.class).getAddressListByUserIdTest(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
            if(null != user){
                logger.debug("用户角色：" + user.getUserCode() + ", 用户名: " + user.getUserName()
                        +", <未做映射字段>用户密码: " + user.getUserPassword());
                if(user.getAddressList().size() > 0){
                    for(Address address : user.getAddressList()){
                        logger.debug("地址Id: " + address.getId() + ", 联系人: " + address.getContact()
                                + ", 详细地址: " + address.getAddressDesc() + ", 电话: " + address.getTel()
                                + ", 邮政编码: " + address.getPostCode() + ", <未做映射字段>用户Id: " + address.getUserId());
                    }
                }else{
                    logger.debug("该用户下无地址列表！");
                }
            }else{
                logger.debug("查无此用户！");
            }
    }

    /**
     * @Description:测试通过用户名和用户角色查询用户列表
     * @param: []
     * @return: void
     * @Date: 2019-06-23
     */
    @Test
    public void getUserListByuserNameAnduserRole() {
        List<User> userList = new ArrayList<User>();
        //用户输全所有条件的情况
        /*String userName = "孙";
        Integer roleId = 3;*/
        //模拟用户没有输全所有条件的情况
        /*String userName = "孙";
        Integer roleId = null;*/
        //模拟用户没有输全所有条件的情况
        /*String userName = "";
        Integer roleId = 3;*/
        //模拟用户没有输全所有条件的情况
        String userName = "";
        Integer roleId = null;
        userList = sqlSession.getMapper(UserMapper.class).getUserListByuserNameAnduserRole(userName,roleId);
        for(User user: userList){
            logger.debug("用户Id: " + user.getId() +
                    "用户代号: " + user.getUserCode() +
                    " 用户名: " + user.getUserName() +
                    " 用户角色: " + user.getUserRole() +
                    " 用户角色名: " + user.getUserRoleName() +
                    " 年龄: " + user.getAge() +
                    " 电话: " + user.getPhone() +
                    " 性别: " + user.getGender());
        }
    }

    /**
     * @Description:测试随机修改用户信息，不修改的则为原来的
     * @param: []
     * @return: void
     * @Date: 2019-06-23
     */
    @Test
    public void modifyBySuiJi() {
        int count = 0;
        try {
            User user = new User();
            user.setId(16);
            user.setUserCode("你好年后");
            user.setUserPassword("00000000");
            user.setModifyDate(new Date());
            count = sqlSession.getMapper(UserMapper.class).modifyBySuiJi(user);
            //模拟异常，进行回滚
            //int i = 2/0;
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
            count = 0;
        }
        logger.debug("修改用户的数量: " + count);
    }

    /**
     * @Description:测试根据用户角色列表，获取该角色列表下用户列表信息-foreach_array
     * @param: []
     * @return: void
     * @Date: 2019-06-24
     */
    @Test
    public void getUserByRoleId_foreach_array() {
        List<User> userList = new ArrayList<User>();
        Integer[] roleIds = {2,3};
        userList = sqlSession.getMapper(UserMapper.class).getUserByRoleId_foreach_array(roleIds);
        for (User user: userList ) {
            logger.debug("用户Id："+user.getId()+",用户代号："+user.getUserCode()+",用户名："+user.getUserName()+",用户角色："+user.getUserRole());
        }
    }

    /**
     * @Description:测试根据用户角色列表，获取该角色列表下用户列表信息-foreach_list
     * @param: []
     * @return: void
     * @Date: 2019-06-24
     */
    @Test
    public void getUserByRoleId_foreach_list() {
        List<User> userList = new ArrayList<User>();
        List<Integer> roleList = new ArrayList<Integer>();
        roleList.add(2);
        roleList.add(3);
        userList = sqlSession.getMapper(UserMapper.class).getUserByRoleId_foreach_list(roleList);
        for (User user: userList ) {
            logger.debug("用户Id："+user.getId()+",用户代号："+user.getUserCode()+",用户名："+user.getUserName()+",用户角色："+user.getUserRole());
        }
    }

    /**
     * @Description:根据用户角色列表和性别(多参数)，获取该角色列表下指定性别的用户列表信息-foreach_map
     * @param:
     * @return:
     * @Date: 2019-06-24
     */
    @Test
    public void getUserByConditionMap_foreach_map(){
        List<User> userList = new ArrayList<User>();
        Map<String, Object> conditionMap = new HashMap<String,Object>();
        List<Integer> roleList = new ArrayList<Integer>();
        roleList.add(2);
        roleList.add(3);
        conditionMap.put("gender", 1);
        conditionMap.put("roleIds",roleList);
        try {
            userList = sqlSession.getMapper(UserMapper.class).getUserByConditionMap_foreach_map(conditionMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug("查出来的个数： ----> " + userList.size());
        for(User user : userList){
            logger.debug("用户id: " + user.getId()+
                    ", 用户代号: " + user.getUserCode() +
                    ", 用户名: " + user.getUserName() +
                    ", 用户性别: " + user.getGender() +
                    ", 用户角色: " + user.getUserRole());
        }
    }

    /**
     * @Description:根据用户角色列表，获取该角色列表下用户列表信息-foreach_map(单参数封装成map)
     * @param: []
     * @return: void
     * @Date: 2019-06-24
     */
    @Test
    public void getUserByRoleId_foreach_map() {
        List<User> userList = new ArrayList<User>();
        List<Integer> roleList = new ArrayList<Integer>();
        roleList.add(2);
        roleList.add(3);
        Map<String, Object> roleMap = new HashMap<String,Object>();
        roleMap.put("rKey", roleList);
        try {
            userList = sqlSession.getMapper(UserMapper.class).getUserByRoleId_foreach_map(roleMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug("查出来的个数： ----> " + userList.size());
        for(User user : userList){
            logger.debug("用户id: " + user.getId()+
                    ", 用户代号: " + user.getUserCode() +
                    ", 用户名: " + user.getUserName() +
                    ", 用户角色: " + user.getUserRole());
        }
    }

    /**
     * @Description:查询用户列表(choose)
     * @param: []
     * @return: void
     * @Date: 2019-06-24
     */
    @Test
    public void getUserList_choose() {
        List<User> userList = new ArrayList<User>();
        try {
            String userName = "";
            Integer roleId = null;
            String userCode = "";
            Date creationDate = new SimpleDateFormat("yyyy-MM-dd").parse("2015-01-01");
            userList = sqlSession.getMapper(UserMapper.class).getUserList_choose(userName,roleId,userCode,creationDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug("查询到的个数----> " + userList.size());
        for(User user: userList){
            logger.debug("用户id: " + user.getId() +
                    " ，用户代号: " + user.getUserCode() +
                    "，用户名: " + user.getUserName() +
                    " ，用户角色:  " + user.getUserRole() +
                    " ，创建时间:  " + new SimpleDateFormat("yyyy-MM-dd").format(user.getCreationDate()));
        }
    }

    /**
     * @Description:查询用户列表(分页显示)
     * @param: []
     * @return: void
     * @Date: 2019-06-24
     */
    @Test
    public void getUserListByPage() {
        List<User> userList = new ArrayList<User>();
        try {
            String userName = "";
            Integer roleId = null;
            Integer currentPageNo = 0;
            Integer pageSize = 5;
            userList = sqlSession.getMapper(UserMapper.class).getUserListByPage(userName,roleId,currentPageNo,pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.debug("查到的个数 " + userList.size());
        for(User user: userList){
            logger.debug("用户id: " + user.getId() +
                    " ，用户代码: " + user.getUserCode() +
                    " ，用户名:  " + user.getUserName() +
                    " ，用户角色:  " + user.getUserRole() +
                    " ，用户角色名:  " + user.getUserRoleName() +
                    " ，用户年龄:  " + user.getAge() +
                    " ，用户电话:  " + user.getPhone() +
                    " ，用户性别: " + user.getGender()+
                    " ，创建时间: " + new SimpleDateFormat("yyyy-MM-dd").format(user.getCreationDate()));
        }
    }
}
