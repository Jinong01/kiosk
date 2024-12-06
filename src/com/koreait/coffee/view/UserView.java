package com.koreait.coffee.view;

import com.koreait.coffee.controller.UserController;
import com.koreait.coffee.model.dto.User;

import java.util.Scanner;

public class UserView {
public Scanner sc = new Scanner(System.in);
public UserController userController = new UserController();

    public void signIn(Double point , Double amount){
        while (true){
            System.out.println("  1.포인트 적립  2.포인트 사용  3.적립안함");
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
                    System.out.println("핸드폰번호를 입력하세요:");                      // 카페 키오스크에선 핸드폰번호로만으로 포인트 등록, 이름은 나중에 어플로
                    String phoneNumber = sc.next();
                        if (userController.getUserByPhoneNumber(phoneNumber)==null){ // 입력한 번호로 등록된 회원이 없으면
                            User user = new User();                                  // 새로운 user 를 만들어서
                            user.setPhoneNumber(phoneNumber);                        // 입력한 번호를 저장
                            user.setPoint(point);                                    // 계산 된 포인트를 저장
                            userController.addUser(user);                            // 저장된 번호와 포인트로 유저테이블에 새로 저장
                        } else {
                            userController.plusPoint(phoneNumber,point);             // 입력한 번호의 회원이 있으면 포인트 추가
                        } return;

                case 2:
                    System.out.println("핸드폰번호를 입력하세요:");
                    String phoneNumber1 = sc.next();
                    if (userController.getUserByPhoneNumber(phoneNumber1)==null){  // 등록된 회원이 없으면
                        System.out.println("동록되지 않은 회원입니다.");
                        break;
                    } else if (userController.getUserByPhoneNumber(phoneNumber1).getPoint()==null)
                    {
                        System.out.println("사용가능한 포인트가 없습니다.");
                    } else {
                        System.out.println("사용가능한 포인트 : "+userController.getUserByPhoneNumber(phoneNumber1).getPoint()+"점");
                        System.out.println("사용할 포인트 : "); Double point1 = sc.nextDouble(); // 사용할 포인트 입력
                        double amount1 = amount-point1;                                        // 총 금액 - 사용할 포인트
                        System.out.println("포인트 사용 후 결제 금액:"+amount1);
                        userController.plusPoint(phoneNumber1,-point1);                        // 갖고 있던 포인트에 사용할 포인트 차감
                    }
                    return;
                case 3:
                    return;
            }
        }
    }
}



