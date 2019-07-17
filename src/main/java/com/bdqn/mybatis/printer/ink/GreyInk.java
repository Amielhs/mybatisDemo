package com.bdqn.mybatis.printer.ink;

import com.bdqn.mybatis.printer.printer.Ink;

import java.awt.*;

/**
 * @ClassName: GreyInk
 * @Description:灰色墨盒。GreyInk实现Ink接口
 * @Author: amielhs
 * @Date 2019-06-26
 */
public class GreyInk implements Ink {
    /**
     * @Description:打印采用灰色
     * @param: [r, g, b]
     * @return: java.lang.String
     * @Date: 2019-06-26
     */
    @Override
    public String getColor(int r, int g, int b) {
        int c = (r+g+b)/3;
        Color color = new Color(c,c,c);
        return "#"+Integer.toHexString(color.getRGB()).substring(2);
    }
}
