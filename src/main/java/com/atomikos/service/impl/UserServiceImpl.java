package com.atomikos.service.impl;

import com.atomikos.bean.User;
import com.atomikos.service.Test1Service;
import com.atomikos.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class UserServiceImpl {

    @Autowired
    private Test1Service test1Service;

    @Autowired
    private TestService testService;

    @Transactional
    public String addUser() {
        testService.insertTest(new User("1", "1"));
        test1Service.insertTest1(new User("2", "2"));
        return "1";
    }
}
