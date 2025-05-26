package ir.ac.kntu.model;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {

    private static final OrderManager OMInstance = new OrderManager();
    private List<OrderUser> allOrders = new ArrayList<>();

    public static OrderManager getOMInstance() {
        return OMInstance;
    }

    public List<OrderUser> getAllOrders() {
        return allOrders;
    }

    public void addOrder(OrderUser order) {
        allOrders.add(order);
    }

    public List<OrderUser> getOrderForSeller(Seller seller) {
        List<OrderUser> sellerOrder = new ArrayList<>();
        for (OrderUser order : allOrders) {
            for (Products p : order.getOrderedProducts()) {
                if (p.getSeller().equals(seller)) {
                    sellerOrder.add(order);
                    break;
                }
            }
        }
        return sellerOrder;
    }
}
