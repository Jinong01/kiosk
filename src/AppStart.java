import com.koreait.coffee.controller.DishController;
import com.koreait.coffee.controller.ShoppingCartController;
import com.koreait.coffee.model.dto.Dish;
import com.koreait.coffee.model.dto.ShoppingCart;
import com.koreait.coffee.view.MainView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AppStart {
    public static void main (String[] args) {
        MainView mainView = new MainView();
        ShoppingCartController shoppingCartController = new ShoppingCartController();
        DishController dishController = new DishController();
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                // 일정시간 뒤 장바구니 다 지우고 초기화면으로
                dishController.deleteAllDishFlavor();
                shoppingCartController.deleteAllShoppingCart();
                mainView.mainView();
            }
        };
        int i =100000;
        timer.schedule(timerTask,i); // 시간은 100초 설정
        System.out.println((i/1000)+"초 후 초기화면으로 돌아갑니다."); // 1초마다 시간 줄어드는 건 못하겠음...
        mainView.mainView();

    }
}
