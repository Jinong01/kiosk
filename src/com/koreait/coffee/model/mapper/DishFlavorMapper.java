package com.koreait.coffee.model.mapper;

import com.koreait.coffee.model.dto.Dish;
import org.apache.ibatis.annotations.Delete;

public interface DishFlavorMapper {

    // 내가 선택한 dishId 에 맞는 음식의 온도와 샷을 설정해서 객체화하기
    void addDishFlavor(Dish dish);

    void allDishFlavor();

    // 설정한 세팅을 없애는 코드 = 장바구니와 동일
    @Delete("delete from dish_flavor where id>0")
    void deleteAllDishFlavor();
}
