package com.xzit.salesmanagement.util;

import java.util.List;

public class PageUtil {
    private int currentPageNum; //当前要看哪一页
    private int pageSize = 10;  //一页的记录条数
    private int totalSize;      //总记录条数
    private int startIndex;     //查询开始记录的索引 limit ？ ？
    private int totalPageNum;   //总页数
    private int prePageNum;     //上一页
    private int nextPageNum;    //下一页
    private List records;       //当前页的记录集


    //用于页面显示导航的页号  用户可自定义
    private int startPageNum;
    private int endPageNum;
    private String url;


    public PageUtil(int currentPageNum, int totalSize) {
        this.currentPageNum = currentPageNum;
        this.totalSize = totalSize;
        //计算开始记录索引
        startIndex = (currentPageNum-1)*pageSize;
        //计算总页数
        //...
    }
}
