package com.bdqn.mybatis.pojo;
/**
 * @ClassName: Product
 * @Description:产品实体类
 * @Author: amielhs
 * @Date 2019-06-27
 */
public class Product {
    private String productName;
    private String brand;

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void showProduct(){
        System.out.println("productName:"+this.productName+",brand:"+this.brand);
    }
}
