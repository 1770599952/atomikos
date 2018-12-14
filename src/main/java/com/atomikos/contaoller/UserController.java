package com.atomikos.contaoller;

import com.atomikos.bean.User;
import com.atomikos.service.Test1Service;
import com.atomikos.service.TestService;
import com.atomikos.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/add")
    public String addUser() {
        userService.addUser();
        return "success";
    }
}
