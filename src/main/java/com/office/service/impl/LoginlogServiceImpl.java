package com.office.service.impl;

import com.office.bean.Loginlog;
import com.office.mapper.LoginlogMapper;
import com.office.service.LoginlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginlogServiceImpl implements LoginlogService {
    @Autowired
    LoginlogMapper loginlogMapper;
    @Override
    public int addLog(Loginlog log){
        return loginlogMapper.addLog(log);
    }
    @Override
    public List<Loginlog> findMyLogs(String no){
        return loginlogMapper.findMyLogs(no);
    }

}
