package com.koreait.coffee.view;

import com.koreait.coffee.controller.DishController;
import com.koreait.coffee.controller.ShoppingCartController;

public class PayView {
    public UserView userView = new UserView();
    public ShoppingCartController shoppingCartController = new ShoppingCartController();
    DishController dishController = new DishController();

    public void pointView(){
        userView.signIn();
    }

    public void paySuccess() {
        System.out.println("결제 성공");
        shoppingCartController.deleteAllShoppingCart();// 결제성공하면 장바구니 삭제
        dishController.deleteAllDishFlavor();          // 세팅한 음료도 삭제
    }

    public void mainView(){
        MainView mainView = new MainView();
        mainView.mainView();
    }
}
