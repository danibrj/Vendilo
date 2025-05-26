package ir.ac.kntu.model;

import java.util.List;

public class ShowOrders {

    private static final ShowOrders SOInstance = new ShowOrders();

    public static ShowOrders getSOInstance() {
        return SOInstance;
    }

    public void show(RegularUser user) {
        List<OrderUser> orders = user.getOrderUsers();
        if (orders.isEmpty()) {
            System.out.println("not found order");
            return;
        }
        System.out.println("Orders: ");
        for (int i = 0; i < orders.size(); i++) {
            System.out.println((i + 1) + " order date: " + orders.get(i).getOrderDate() + " | total price: " + orders.get(i).getTotalPrice() + " $");
        }
    }
}
