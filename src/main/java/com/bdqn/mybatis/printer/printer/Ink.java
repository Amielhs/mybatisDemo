package com.bdqn.mybatis.printer.printer;
/**
 * @ClassName: ink
 * @Description:墨盒接口
 * @Author: amielhs
 * @Date 2019-06-26
 */
public interface Ink {

    /**
     * @Description:定义打印采用的颜色的方法
     * @param: [r, g, b]
     * @return: java.lang.String
     * @Date: 2019-06-26
     */
    public String getColor(int r,int g,int b);
}
