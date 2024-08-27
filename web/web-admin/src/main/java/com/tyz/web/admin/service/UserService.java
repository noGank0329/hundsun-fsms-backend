package com.tyz.web.admin.service;

import com.tyz.model.entity.User;

public interface UserService{

    String userLogin(User user);

    void userRegister(User user);
}