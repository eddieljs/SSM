package com.office.service;

import com.office.bean.Loginlog;

import java.util.List;

public interface LoginlogService {
    //新增登录日志
    int addLog(Loginlog log);
    List<Loginlog> findMyLogs(String no);
}
