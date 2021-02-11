package com.zf.mo.dao;

import com.zf.mo.entity.DemoEntity;
import org.springframework.stereotype.Component;

import java.util.List;
public interface UserMapper {

    List<DemoEntity> getUser();
}
