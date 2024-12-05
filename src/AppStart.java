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


        mainView.mainView();

    }
}
