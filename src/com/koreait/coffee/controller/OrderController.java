package com.koreait.coffee.controller;

import com.koreait.coffee.config.MysqlConfig;
import com.koreait.coffee.model.mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;

public class OrderController {
    public SqlSession sqlSession = MysqlConfig.mysqlConnect();
    public OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);



    // 장바구니에 담긴 모든 음식의 가격 호출 = 결제할 금액
    public Double getOrderAmount(){
        return mapper.getOrderAmount();}

    void getAllOder(){mapper.getAllOder();}

    void addOrders(){mapper.addOrders();}
}


