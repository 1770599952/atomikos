package com.atomikos.service.impl;

import com.atomikos.bean.User;
import com.atomikos.dao1.Test1Dao;
import com.atomikos.service.Test1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Test1ServiceImpl implements Test1Service {

    @Autowired
    private Test1Dao test1Dao;

    @Override
    public void insertTest1(User user) {
        test1Dao.insertTest1(user);
    }
}
