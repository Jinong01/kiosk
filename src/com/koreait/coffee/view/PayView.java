package com.koreait.coffee.view;

import com.koreait.coffee.controller.DishController;
import com.koreait.coffee.controller.ShoppingCartController;
import com.koreait.coffee.model.dto.DishFlavor;
import com.koreait.coffee.model.dto.ShoppingCart;

import java.util.List;
import java.util.Map;

public class PayView {
    public UserView userView = new UserView();
    public ShoppingCartController shoppingCartController = new ShoppingCartController();
    DishController dishController = new DishController();

    public void pointView(Double point, Double amount) {
        userView.signIn(point , amount);
    }

    public void paySuccess() {
        System.out.println("결제 성공");
        shoppingCartController.deleteAllShoppingCart();// 결제성공하면 장바구니 삭제
        dishController.deleteAllDishFlavor();          // 세팅한 음료도 삭제
    }

    public void mainView(){                             // 다시 초기화면으로
        MainView mainView = new MainView();
        shoppingCartController.deleteAllShoppingCart(); // 장바구니 삭제
        dishController.deleteAllDishFlavor();           // 세팅한 음료 삭제
        mainView.mainView();
    }
}
