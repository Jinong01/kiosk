package com.koreait.coffee.model.mapper;

import com.koreait.coffee.model.dto.Order;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {

    @Select("select * from orders")
    List<Order> getAllOder();

    // 장바구니에 담긴 모든 음식의 총 가격 호출 = 결제할 금액
    Double getOrderAmount();

    void addOrders();

}
