package com.bdqn.mybatis.printer.printer;
/**
 * @ClassName: printer
 * @Description:打印机程序
 * @Author: amielhs
 * @Date 2019-06-26
 */
public class Printer {
    //面向接口编程，而不是具体的实现类
    private Ink ink = null;
    private Paper paper = null;

    public Ink getInk() {
        return ink;
    }

    public void setInk(Ink ink) {
        this.ink = ink;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    /**
     * @Description:打印机打印方法
     * @param: [str]
     * @return: void
     * @Date: 2019-06-26
     */
    public void print(String str){
        //输出颜色标记
        System.out.println("使用"+ink.getColor(255,200,0)+"颜色打印:\n");
        //逐字符输出到纸张
        for (int i = 0; i < str.length(); i++) {
            paper.putInChar(str.charAt(i));
        }
        //将纸张的内容输出
        System.out.println(paper.getContent());
    }
}


