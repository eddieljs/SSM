package com.office.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageUtils <T>{
    private long pageIndex;
    private long pageSize;
    private long pageCount;
    private long totalCount;
    private List<T> records;

    private long numberStart=1;
    private long numberEnd;
    private List<Long> numbers=new ArrayList<Long>();

    public PageUtils(long pageIndex,long pageSize,long totalCount,List<T>records){
        this.pageIndex=pageIndex;
        this.pageSize=pageSize;
        this.totalCount=totalCount;
        this.records=records;
        //计算总页数
        this.pageCount=(this.totalCount%this.pageSize==0?this.totalCount/this.pageSize:this.totalCount/this.pageSize+1);
        //设置开始序号 结束序号 和页码集合
        //假设每一个显示10个页码
        if (this.pageCount<10){
            this.numberStart=1;
            this.numberEnd=pageCount;
        }else{
            this.numberStart=pageIndex-4;
            this.numberEnd=pageIndex+5;
            if (this.numberStart<1){
                this.numberStart=1;
                this.numberEnd=10;
            }else if (this.numberEnd>pageCount){
                this.numberStart=pageCount-9;
                this.numberEnd=pageCount;
            }
        }
        for (long i=numberStart;i<=numberEnd;i++){
            numbers.add(i);
        }
    }
}
