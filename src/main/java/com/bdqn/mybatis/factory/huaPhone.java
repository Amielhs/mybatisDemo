package com.bdqn.mybatis.factory;

public class huaPhone implements PhoneInterface {
    private String name;

    public huaPhone() {
    }

    public huaPhone(String name) {
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
        System.out.println(this.name+"可以玩英雄联盟");
    }

    @Override
    public void call() {
        System.out.println(this.name+"可以用6G网络打电话");
    }
}
