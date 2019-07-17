package com.bdqn.mybatis.printer.ink;

import com.bdqn.mybatis.printer.printer.Ink;

import java.awt.*;

/**
 * @ClassName: ColorInk
 * @Description:彩色墨盒。ColorInk实现Ink接口
 * @Author: amielhs
 * @Date 2019-06-26
 */
public class ColorInk implements Ink {
    /**
     * @Description:打印采用彩色
     * @param: [r, g, b]
     * @return: java.lang.String
     * @Date: 2019-06-26
     */
    @Override
    public String getColor(int r, int g, int b) {
        Color color = new Color(r,g,b);
        return "#"+Integer.toHexString(color.getRGB()).substring(2);
    }
}
