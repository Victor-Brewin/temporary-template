package com.brewin.shiro.dao;

import org.apache.ibatis.annotations.Select;

import com.brewin.shiro.domain.User;

public interface UserMapper {
    @Select("select * from user where name = #{name}")
    public User findByName(String name);

    @Select("select * from user where id = #{id}")
    public User findById(Integer id);
}
