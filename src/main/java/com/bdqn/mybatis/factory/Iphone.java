package com.bdqn.mybatis.factory;
/**
 * @ClassName: Iphone
 * @Description:苹果手机类
 * @Author: amielhs
 * @Date 2019-06-26
 */
public class Iphone implements PhoneInterface{
    private String name;

    public Iphone() {
    }

    public Iphone(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void playGame() {
        System.out.println(this.name+"可以玩王者");
    }

    @Override
    public void call() {
        System.out.println(this.name+"可以用4G网络打电话");
    }
}
