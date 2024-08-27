package com.tyz.web.admin.mapper;

import com.tyz.model.entity.User;

public interface UserMapper{

    User selectOneByUsername(String userName);

    int addUser(User user);
}
