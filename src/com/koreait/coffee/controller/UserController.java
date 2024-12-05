package com.koreait.coffee.controller;

import com.koreait.coffee.config.MysqlConfig;
import com.koreait.coffee.model.dto.ShoppingCart;
import com.koreait.coffee.model.dto.User;
import com.koreait.coffee.model.mapper.UserMapper;

public class UserController {
    public UserMapper mapper = MysqlConfig.mysqlConnect().getMapper(UserMapper.class);


    public void addUser(User user) {
        mapper.insertUser(user);
    }

    public void updateUserByPhoneNumber(User user) {mapper.updateUserByPhoneNumber(user);}

    public User getUserByPhoneNumber(String phoneNumber){return mapper.getUserByPhoneNumber(phoneNumber);}

    public void plusPoint(String phoneNumber , Double point){
        User user = getUserByPhoneNumber(phoneNumber);
        user.setPoint(user.getPoint()+point);
        updateUserByPhoneNumber(user);
    }
}
