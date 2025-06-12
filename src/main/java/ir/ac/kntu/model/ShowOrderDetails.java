package ir.ac.kntu.model;

import java.util.List;
import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

public class ShowOrderDetails {

    private static final ShowOrderDetails SODInstance = new ShowOrderDetails();
    private Scanner scanner = new Scanner(System.in);

    public static ShowOrderDetails getSODInstance() {
        return SODInstance;
    }

    public void show(RegularUser user) {
        List<OrderUser> orders = user.getOrderUsers();
        if (orders.isEmpty()) {
            System.out.println(red+"not found order for view details."+reset);
            return;
        }

        ShowOrders.getSOInstance().show(user);
        System.out.println("select one: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index > orders.size()) {
            System.out.println(red+"invalid selected"+reset);
            return;
        }

        OrderUser selectedOrder = orders.get(index - 1);
        System.out.println(cyan+"----Order Details----"+reset);
        System.out.println("Date: " + selectedOrder.getOrderDate());
        System.out.println("Address: " + selectedOrder.getDeliveryAddress());
        System.out.println("Total price: " + selectedOrder.getTotalPrice() + " $");
        System.out.println("Products:");
        for (int i = 0; i < selectedOrder.getOrderedProducts().size(); i++) {
            Products prod = selectedOrder.getOrderedProducts().get(i);
            System.out.println(" " + (i + 1) + " " + prod.getName() + " | Seller: " + prod.getSeller().getFirstName() + " " + prod.getSeller().getLastName() + " | Average rating: " + prod.getAverageRating());
            System.out.println("comments: ");
            prod.getUserComments();
        }
    }
}
