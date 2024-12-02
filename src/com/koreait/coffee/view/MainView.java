package com.koreait.coffee.view;

import com.koreait.coffee.controller.CategoryController;
import com.koreait.coffee.controller.DishController;
import com.koreait.coffee.controller.ShoppingCartController;
import com.koreait.coffee.model.dto.Type;
import java.util.Scanner;
public class MainView {
    public MenuView menuView = new MenuView();
    public Scanner sc = new Scanner(System.in);
    public static Type type = null;

    // 선근호 11-29 21:14 수정
    public void mainView() {
        while (true){
            System.out.println("=========================");
            System.out.println("        GH Coffee        ");
            System.out.println("=========================");
            System.out.println("  1.매장식사    2.포장주문  ");
            System.out.print("번호를 입력하세요 :");
            int choose = 0;
            try {
                choose = sc.nextInt();
            } catch (Exception e) {
                System.out.println("ERROR");
                sc.nextLine();
                continue;
            }
            switch (choose){
            case 1:
                type = Type.FOR_HERE;
                menuView.categoryView(type);
                break;
            case 2:
                type = Type.TO_GO;
                menuView.categoryView(type);
                break;
            default:
                System.out.println("종료");
                return;
            }
        }
    }
}
