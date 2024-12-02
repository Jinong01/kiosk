package com.koreait.coffee.model.mapper;

import com.koreait.coffee.model.dto.ShoppingCart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface ShoppingCartMapper {

    // 선택한 메뉴 옵션 설정하여 장바구니에 추가
    void insertShoppingCart(ShoppingCart shoppingCart);

    //update
    void updateShoppingCartByDishId(ShoppingCart shoppingCart);

    @Delete("delete from shopping_cart where dish_id = #{dishId}")
    void deleteShoppingCartByDishId(Integer dishId);

    @Delete("delete from shopping_cart where id =#{id}")
    void deleteShoppingCartById(Integer id);

    @Select("select * from shopping_cart")
    List<ShoppingCart> selectShoppingCart();

    // shopping_cart 에 음식가격 x 수량한 가격 대입
    void updateAmount(Integer ShoppingCartId,Integer dishId);

    // shopping_cart 에 담긴 음식이름 , 수량 , 같은 음식 의 가격합산 호출
    List<ShoppingCart> getShoppingCart();

    // shopping_cart 의 id 가 0보다 큰 값 삭제 = 일괄 장바구니 삭제
    @Delete("delete from shopping_cart where id>0")
    void deleteAllShoppingCart();
}
