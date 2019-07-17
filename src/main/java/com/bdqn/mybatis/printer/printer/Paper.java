package com.bdqn.mybatis.printer.printer;
/**
 * @ClassName: Paper
 * @Description:纸张接口
 * @Author: amielhs
 * @Date 2019-06-26
 */
public interface Paper {

    public static final String newline = "\r\n";

    /**
     * @Description:输出一个字符到纸张
     * @param: [c]
     * @return: void
     * @Date: 2019-06-26
     */
    public void putInChar(char c);

    /**
     * @Description:得到输出到纸张上的内容
     * @param: []
     * @return: java.lang.String
     * @Date: 2019-06-26
     */
    public String getContent();
}
