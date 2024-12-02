package com.koreait.coffee.view;

import com.koreait.coffee.controller.CategoryController;
import com.koreait.coffee.controller.DishController;
import com.koreait.coffee.controller.OrderController;
import com.koreait.coffee.controller.ShoppingCartController;
import com.koreait.coffee.model.dto.*;

import java.util.List;
import java.util.Scanner;

public class MenuView {
    public OrderView orderView = new OrderView();
    public Scanner sc = new Scanner(System.in);
    public ShoppingCartController shoppingCartController = new ShoppingCartController();
    public CategoryController categoryController = new CategoryController();
    public DishController dishController = new DishController();
    public PayView payView = new PayView();
    public OrderController orderController = new OrderController();
    /**
     * 카테고리 보여주는 메소드
     * @param type
     */
    // 선근호 11-29 21:14 수정
    public void categoryView(Type type){
         while (true){
            System.out.println("=========================");
            System.out.println("        GH Coffee        ");
            System.out.println("=========================");
            for (Category category : categoryController.getAllCategory()) {
                System.out.println(category.getId() + ":" + category.getName());
            }
            System.out.println("번호를 입력하세요 :");
            int choose = 0;
            try {
                choose = sc.nextInt();
            } catch (Exception e) {
                System.out.println("ERROR");
                sc.nextLine();
                continue;
            }

            switch (choose){

            case 1 ,2 , 3, 4, 5, 6:
                menuView(choose);
                break;
            default:
                System.out.println("뒤로가기");
                return;
            }
        }
    }

    /**
     * 내가고른 카테고리 id : 메뉴카테고리이름을 출력하고
     * 메뉴이름 출력
     * @param categoryId
     */
    // 선근호 11-29 21:14 수정
    public void menuView(Integer categoryId){
        while (true) {
            List<Dish> dishesByCategoryId = dishController.getDishesByCategoryId(categoryId);
            Category categoryById = categoryController.getCategoryById(categoryId);
            System.out.println("==========="+ categoryById.getId()+":"+categoryById.getName() +"============");
//          // "==========="+ categoryById.getId() 카테고리번호 +":"+categoryById.getName() 카테고리이름 +"============"
            for (Dish dish : dishesByCategoryId) {
                System.out.println(dish.getId() + ":" + dish.getName());
            }
            System.out.println("100:뒤로가기");
            System.out.println("0:결제하기");
            System.out.println("번호를 입력하세요 :");
            int choose = sc.nextInt();
            switch (choose){
                case 1, 2, 3, 4 :
                    Temperature temperature = orderView.temperatureView(); // 커피 온도 설정
                    Shot shot = orderView.shotView();                      // 커피 샷 설정
                    Dish dish = dishController.getDishById(choose);        // 선택한 choose 값의 dishId 대입
                    dishController.addDishFlavor(dish,temperature,shot);   // 설정한 온도,샷,dishId로 주문할 커피 완성
                    shoppingCartController.add(dish.getId());              // 완성한 커피를 장바구니에 담기
                    break;
                case 5,6,7,8:
                    Temperature temperature1 = orderView.temperatureView();// 온도 설정 , 샷을 설정할 필요 없는 메뉴
                    Dish dish1 = dishController.getDishById(choose);
                    dishController.addDishFlavor(dish1,temperature1,Shot.NORMAL); // 커피와 같지만 샷 설정 안해서 노말
                    shoppingCartController.add(dish1.getId());                    // 장바구니에 담기
                case 9,10,11,12:
                    Dish dish2 = dishController.getDishById(choose);
                    dishController.addDishFlavor(dish2,Temperature.ICE,Shot.NORMAL); // 온도 고정 , 샷은 없음
                    shoppingCartController.add(dish2.getId());                       // 장바구니 담기
                    break;
                case 13,14,15,16:
                    Dish dish3 = dishController.getDishById(choose); // 디저트는 온도,샷 선택지가 없음
                    shoppingCartController.add(dish3.getId());       // 장바구니 담기
                    break;
                case 0:
                    shoppingCartController.getShoppingCart();
                    payView();
                    return;
                default:

                    return;
            }
        }
    }

    public void payView(){
        while (true){
            double amount = orderController.getOrderAmount(); // 장바구니에 담긴 모든 음식의 가격을 불러오기
            System.out.println("총 금액 : " + amount+"원");
            System.out.println("결제하시겠습니까? 1.OK   2.NO  *.뒤로 가기");
            int choose = sc.nextInt();
            switch (choose){
                case 1:
                    payView.pointView();    // 결제 OK 후 포인트 적립 여부 창으로
                    payView.paySuccess();   // 적립 여부 끝나면 결제 성공 창
                    payView.mainView();     // 결제성공 후 다시 메인 화면으로
                    return;
                case 2:
                    return;                 // 결제안하고 다시 메뉴 선택하러
                default:
                    return;
            }
        }
    }

}


