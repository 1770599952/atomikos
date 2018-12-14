package com.atomikos.service.impl;

import com.atomikos.bean.User;
import com.atomikos.dao.TestDao;
import com.atomikos.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    @Transactional
    public void insertTest(User user) {
        testDao.insertTest(user);
    }
}
