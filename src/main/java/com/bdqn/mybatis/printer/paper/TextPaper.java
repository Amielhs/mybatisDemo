package com.bdqn.mybatis.printer.paper;

import com.bdqn.mybatis.printer.printer.Paper;
/**
 * @ClassName: TextPaper
 * @Description:文本打印纸张实现。TextPaper实现Paper接口
 * @Author: amielhs
 * @Date 2019-06-26
 */
public class TextPaper implements Paper {
    private int charPerLine = 16;//每行字符数
    private int linePerPage = 5;//每页行数
    private String content = "";//纸张中内容
    private int posX = 0;//当前横向位置，从0到charPerLine-1
    private int posY = 0;//当前行数，从0到linePerPage-1
    private int posP = 1;//当前页数


    public void setCharPerLine(int charPerLine) {
        this.charPerLine = charPerLine;
    }

    public void setLinePerPage(int linePerPage) {
        this.linePerPage = linePerPage;
    }

    @Override
    public void putInChar(char c) {
        content += c;
        ++posX;
        //判断是否换行
        if (posX==charPerLine){
            content+=Paper.newline;
            posX=0;
            ++posY;
        }
        //判断是否翻页
        if (posY==linePerPage){
            content += "==第"+posP+"页==";
            content += Paper.newline+Paper.newline;
            posY=0;
            ++posP;
        }
    }

    @Override
    public String getContent() {
        String ret = this.content;
        //补齐本页空行，并显示页码
        if (!(posX==0&&posY==0)){
         int count = linePerPage-posY;
            for (int i = 0; i < count; i++) {
                ret += Paper.newline;
            }
            ret += "==第"+posP+"页==";
        }
        return ret;
    }
}
