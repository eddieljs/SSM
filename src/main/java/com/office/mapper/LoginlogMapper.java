package com.office.mapper;

import com.office.bean.Loginlog;

import java.util.List;

public interface LoginlogMapper {
    //每登录一次，向数据库插入一条登录日志记录
    int addLog(Loginlog log);
    //查询某个账号对应的登录日志（足迹）
    List<Loginlog> findMyLogs(String no);
}
