package com.bdqn.mybatis.factory;
/**
 * @ClassName: PhoneFactory
 * @Description:手机工厂类
 * @Author: amielhs
 * @Date 2019-06-26
 */
public class PhoneFactory {
    private static final String IPHOE = "iphone";
    private static final String MIPHOE = "miphone";
    private static final String HUA = "huaphone";
    /**
     * @Description:生产手机
     * @param: [str]
     * @return: com.bdqn.mybatis.factory.PhoneInterface
     * @Date: 2019-06-26
     */
    public PhoneInterface producePhone(String str){
        if (str.equals(IPHOE)){//生产苹果
            return new Iphone("苹果手机");
        }else  if (str.equals(MIPHOE)){//生产小米
            return new miPhone("小米手机");
        } else  if (str.equals(HUA)){//生产小米
            return new huaPhone("华为手机");
        }else {
            return null;
        }
    }
}
