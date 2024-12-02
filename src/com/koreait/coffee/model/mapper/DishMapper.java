package com.koreait.coffee.model.mapper;

import com.koreait.coffee.model.dto.Dish;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DishMapper {
    @Select("select * from dish")
    List<Dish> getAllDishes();

    // 키오스크에서 선택한 카테고리의 음식들을 보여주기
    @Select("select * from dish where category_id = #{categoryId}")
    List<Dish> getDishesByCategoryId(int categoryId);

    @Select("select * from dish where id = #{dishId}")
    Dish getDishById(int dishId);
}
