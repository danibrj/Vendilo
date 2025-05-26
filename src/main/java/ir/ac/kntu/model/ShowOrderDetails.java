package ir.ac.kntu.model;

import java.util.List;
import java.util.Scanner;

public class ShowOrderDetails {

    private static final ShowOrderDetails SODInstance = new ShowOrderDetails();
    private Scanner scanner = new Scanner(System.in);

    public static ShowOrderDetails getSODInstance() {
        return SODInstance;
    }

    public void show(RegularUser user) {
        List<OrderUser> orders = user.getOrderUsers();
        if (orders.isEmpty()) {
            System.out.println("not found order for view details.");
            return;
        }

        ShowOrders.getSOInstance().show(user);
        System.out.println("select one: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > orders.size()) {
            System.out.println("invalid selected");
            return;
        }

        OrderUser selectedOrder = orders.get(index - 1);
        System.out.println("----Order Details----");
        System.out.println("Date: " + selectedOrder.getOrderDate());
        System.out.println("Address: " + selectedOrder.getDeliveryAddress());
        System.out.println("Total price: " + selectedOrder.getTotalPrice() + " $");
        System.out.println("Products:");
        for (int i = 0; i < selectedOrder.getOrderedProducts().size(); i++) {
            Products prod = selectedOrder.getOrderedProducts().get(i);
            System.out.println(" " + (i + 1) + " " + prod.getName() + " | Seller: " + prod.getSeller().getFirstName() + " " + prod.getSeller().getLastName() + " | Average rating: " + prod.getAverageRating());
        }
    }
}
