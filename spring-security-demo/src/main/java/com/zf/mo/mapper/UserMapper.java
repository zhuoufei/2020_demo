package com.zf.mo.mapper;

import com.zf.mo.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT * FROM users WHERE username = #{username}")
    User findByUserName(String username);

}
