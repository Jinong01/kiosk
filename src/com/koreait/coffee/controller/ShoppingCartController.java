package com.koreait.coffee.controller;

import com.koreait.coffee.config.MysqlConfig;
import com.koreait.coffee.model.dto.Dish;
import com.koreait.coffee.model.dto.DishFlavor;
import com.koreait.coffee.model.dto.ShoppingCart;
import com.koreait.coffee.model.mapper.DishFlavorMapper;
import com.koreait.coffee.model.mapper.ShoppingCartMapper;
import org.apache.ibatis.session.SqlSession;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


public class ShoppingCartController {
    public SqlSession sqlSession = MysqlConfig.mysqlConnect();
    public ShoppingCartMapper mapper = sqlSession.getMapper(ShoppingCartMapper.class);
    public DishFlavorMapper dishFlavorMapper = sqlSession.getMapper(DishFlavorMapper.class);
    public ShoppingCart shoppingCart = new ShoppingCart();

    public void selectShoppingCart(){mapper.selectShoppingCart();}

    public void add(Dish dish){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setDishId(dish.getId());
        if (shoppingCart.getNumber()==null){                     // 장바구니의 수량이 처음엔 null 인데 null 은 연산이 안되므로
            shoppingCart.setNumber(1);                           // 음식을 처음 담을 때 수량을 +1이 아닌 null -> 1로 바꿈
        } else {
            shoppingCart.setNumber(shoppingCart.getNumber()+1);} // null 이 아니면 1증가
        shoppingCart.setCreateTime(LocalDateTime.now());         // 장바구니에 선택한 시간 저장
        mapper.insertShoppingCart(shoppingCart);                 // 장바구니에 선택한 음식 저장git
        mapper.updateAmount(shoppingCart.getId(),dish.getId());            // 장바구니에 선택한 음식가격과 수량 계산해서 값 대입
    }

    public void updateByDishId(ShoppingCart shoppingCart){
        shoppingCart.setNumber(shoppingCart.getNumber()+1);
        shoppingCart.setNumber(shoppingCart.getNumber()-1);
        mapper.updateShoppingCartByDishId(shoppingCart);
    }

    public void deleteByDishId(Integer dishId){
        mapper.deleteShoppingCartByDishId(dishId);
    }

    public void deleteById(Integer id){
        mapper.deleteShoppingCartById(id);
    }

    public void deleteAllShoppingCart(){
        mapper.deleteAllShoppingCart();
    }

    // 세팅하여 주문한 음식이름 / 수량 / 같은 음료 연산한 가격 보여주기
////    public List<Map<DishFlavor , ShoppingCart>> getShoppingCart(List<DishFlavor> dishFlavors, List<ShoppingCart> shoppingCarts){
//         return mapper.getShoppingCart();
//    }

    public List<ShoppingCart> getAllShoppingCart(){
        return mapper.selectShoppingCart();
    }
}
