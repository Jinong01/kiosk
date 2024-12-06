package com.koreait.coffee.view;

import com.koreait.coffee.controller.CategoryController;
import com.koreait.coffee.controller.DishController;
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

            case 1 ,2 , 3, 4 :
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
            System.out.println("99:장바구니");
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
                    shoppingCartController.add(dish);                      // 완성한 커피를 장바구니에 담기
                    break;
                case 5,6,7,8:
                    Temperature temperature1 = orderView.temperatureView();// 온도 설정 , 샷을 설정할 필요 없는 메뉴
                    Dish dish1 = dishController.getDishById(choose);
                    dishController.addDishFlavor(dish1,temperature1,Shot.NORMAL); // 커피와 같지만 샷 설정 안해서 노말
                    shoppingCartController.add(dish1);                    // 장바구니에 담기
                case 9,10,11,12:
                    Dish dish2 = dishController.getDishById(choose);
                    dishController.addDishFlavor(dish2,Temperature.ICE,Shot.NORMAL); // 온도 고정 , 샷은 없음
                    shoppingCartController.add(dish2);                       // 장바구니 담기
                    break;
                case 13,14,15,16:
                    Dish dish3 = dishController.getDishById(choose); // 디저트는 온도,샷 선택지가 없음
                    shoppingCartController.add(dish3);       // 장바구니 담기
                    break;
                case 99:
                    // 장바구니 출력
                    List<DishFlavor> dishFlavors = dishController.dishFlavorMapper.allDishFlavor(); // 세팅한 음식들 불러오기
                    List<ShoppingCart> shoppingCarts = shoppingCartController.getAllShoppingCart(); // 장바구니에 담은 것들 불러오기
                    if (shoppingCarts==null || dishFlavors == null) { // 장바구니가 세팅한 음식이 없으면
                        System.out.println("장바구니가 비었습니다.");
                    } else {
                        System.out.printf("%-10s%-5s%-5s%-4s%-10s\n","이름","온도","샷","수량","가격");
                        for (int i =0; i <= shoppingCarts.size()-1; i++){
                            System.out.printf("%-10s%-5s%-5s%-4d%-10s\n",
                                    dishFlavors.get(i).getName(),
                                    dishFlavors.get(i).getTemperature(),
                                    dishFlavors.get(i).getShot(),
                                    shoppingCarts.get(i).getNumber(),
                                    shoppingCarts.get(i).getAmount());
                        }
                    }
                    return;
                case 0:
                    if (shoppingCartController.getAllShoppingCart()==null || shoppingCartController.getOrderAmount()==null){
                        // 장바구니가 비었거나 선택한 음식의 총 금액의 값이 없으면
                        System.out.println("선택한 음식이 없습니다.");
                    } else {payView();}
                    return;
                default:
                    return;
            }
        }
    }

    public void payView(){
        while (true){
            Double amount = shoppingCartController.getOrderAmount(); // 장바구니에 담긴 모든 음식의 가격을 불러오기
            Double point = (amount / 10);                     // 총 가격의 10%를 포인트로
            System.out.println("총 금액 : " + amount+"원");
            System.out.println("결제하시겠습니까? 1.OK   2.NO  0.처음화면으로");
            int choose = sc.nextInt();
            switch (choose){
                case 1:
                    payView.pointView(point,amount);    // 결제 OK 후 포인트 적립 여부 창으로 , 계산 된 포인트와 총 가격 변수로
                    payView.paySuccess();   // 적립 여부 끝나면 결제 성공 창
                    payView.mainView();     // 결제성공 후 다시 메인 화면으로
                    return;
                case 2:
                    return;                 // 결제안하고 다시 메뉴 선택하러
                case 0:
                    payView.mainView();     // 선택사항 다 초기화 하고 처음화면으로
                    return;
            }
        }
    }
}


