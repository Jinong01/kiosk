package com.koreait.coffee.view;

import com.koreait.coffee.model.dto.User;

import java.util.Scanner;

public class UserView {
public Scanner sc = new Scanner(System.in);
    public void signIn(){
        while (true){
            System.out.println("  1.핸드폰번호 입력    2.적립안함");
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
                    System.out.println("핸드폰번호를 입력하세요:");
                    String phoneNumber = sc.next();

                    return;

                case 2:
                    User user1 = new User();
                    return;
            }

        }
    }

}



