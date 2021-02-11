package com.zf.mo.mybatis;

import java.util.List;

public interface SysUserMapper {

    List<SysUser> selectAll();

    SysUser selectOne(String id);
}
