package com.bdqn.mybatis.pojo;
/**
 * @ClassName: HelloSpring
 * @Description:HelloSpring实体类
 * @Author: amielhs
 * @Date 2019-06-25
 */
public class HelloSpring {
    private String name;
    private User user;//注入User实体
    private TestEntity testEntity;//注入TestEntity实体
    private Product product;//注入Product实体

    //注入构造方法
    public HelloSpring(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTestEntity(TestEntity testEntity) {
        this.testEntity = testEntity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @Description:打印方法
     * @param: []
     * @return: void
     * @Date: 2019-06-25
     */
    public void print(){
        System.out.println("hello,"+name);
        System.out.println("user id："+user.getId()+",user gender："+user.getGender()+",user phone："+user.getPhone());
        testEntity.showValue();
        product.showProduct();
    }
}
