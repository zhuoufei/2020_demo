package com.zf.mo.mybatis;

public class AppTest {

    public static void main(String[] args) {

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        sqlSession.selectOne("com.zf.mo.mybatis.SysUserMapper.selectOne","1");
        //-----------------------------------------------------------------
        SysUserMapper mapper = sqlSession.getMapper(SysUserMapper.class);
        mapper.selectOne("1");

    }
}
