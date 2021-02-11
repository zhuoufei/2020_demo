package com.zf.mo.controller;

import com.zf.mo.entity.DemoEntity;
import com.zf.mo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public List<DemoEntity> getUser(){
        List<DemoEntity> result = userService.getUser();
        return result;
    }


}
