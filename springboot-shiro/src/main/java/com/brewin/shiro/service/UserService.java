package com.brewin.shiro.service;

import com.brewin.shiro.domain.User;

public interface UserService {
    User findByName(String name);
    User findById(Integer id);
}
