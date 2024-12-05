package com.koreait.coffee.controller;

import com.koreait.coffee.config.MysqlConfig;
import com.koreait.coffee.model.mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;

public class OrderController {
    public SqlSession sqlSession = MysqlConfig.mysqlConnect();
    public OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

    void getAllOder(){mapper.getAllOder();}

    void addOrders(){mapper.addOrders();}
}


