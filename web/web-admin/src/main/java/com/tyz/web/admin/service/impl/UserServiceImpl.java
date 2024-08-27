package com.tyz.web.admin.service.impl;


import com.tyz.common.exception.LeaseException;
import com.tyz.common.result.ResultCodeEnum;
import com.tyz.common.utils.JwtUtil;
import com.tyz.model.entity.User;
import com.tyz.web.admin.mapper.UserMapper;
import com.tyz.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tangyizuo
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2024-08-19 17:41:55
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public String userLogin(User user) {


        //判断用户名是否存在
        User loginUser = userMapper.selectOneByUsername(user.getUserName());

        if(loginUser == null){
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_NOT_EXIST_ERROR);
        }

        //判断密码是否正确
        if(!loginUser.getPassword().equals(user.getPassword())){
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_ERROR);
        }

        //创建token
        return JwtUtil.createToken(Long.valueOf(loginUser.getUserId()),loginUser.getUserName());
    }

    @Override
    public void userRegister(User user) {
        User userRegister = userMapper.selectOneByUsername(user.getUserName());

        if(userRegister != null){
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_EXIST_ERROR);
        }

        int result = userMapper.addUser(user);
        if(result == 0){
            throw new LeaseException(ResultCodeEnum.ILLEGAL_REQUEST);
        }
    }
}




