package com.zf.mo.service.impl;

import com.zf.mo.dao.UserMapper;
import com.zf.mo.entity.DemoEntity;
import com.zf.mo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<DemoEntity> getUser() {
        return userMapper.getUser();
    }
}
