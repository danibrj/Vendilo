package ir.ac.kntu.model;

import java.util.List;
import static ir.ac.kntu.model.Color.*;

public class ShowOrders {

    private static final ShowOrders SOInstance = new ShowOrders();

    public static ShowOrders getSOInstance() {
        return SOInstance;
    }

    public void show(RegularUser user) {
        List<OrderUser> orders = user.getOrderUsers();
        if (orders.isEmpty()) {
            System.out.println(red+"not found order"+reset);
            return;
        }
        System.out.println("Orders: ");
        for (int i = 0; i < orders.size(); i++) {
            System.out.println((i + 1) + " order date: " + orders.get(i).getOrderDate() + " | total price: " + orders.get(i).getTotalPrice() + " $");
        }
    }
}
