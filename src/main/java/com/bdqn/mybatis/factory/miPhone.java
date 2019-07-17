package com.bdqn.mybatis.factory;
/**
 * @ClassName: miPhone
 * @Description:小米手机类
 * @Author: amielhs
 * @Date 2019-06-26
 */
public class miPhone implements PhoneInterface{
    private String name;

    public miPhone() {
    }

    public miPhone(String name) {
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
        System.out.println(this.name+"可以玩和平精英");
    }

    @Override
    public void call() {
        System.out.println(this.name+"可以用5G网络打电话");
    }
}
