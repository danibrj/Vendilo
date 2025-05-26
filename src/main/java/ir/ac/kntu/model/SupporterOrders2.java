package ir.ac.kntu.model;

import java.util.List;
import java.util.Scanner;

public class SupporterOrders2 {

    private static final SupporterOrders2 SuppO2Instance = new SupporterOrders2();
    private Scanner scanner = new Scanner(System.in);

    public static SupporterOrders2 getSuppO2Instance() {
        return SuppO2Instance;
    }

    public void show(List<OrderUser> orders) {
        for (int i = 0; i < orders.size(); i++) {
            OrderUser order = orders.get(i);
            System.out.println((i + 1) + " .order by: " + order.getBuyer().getEmail() + " | Date: " + order.getOrderDate() + " | Total: " + order.getTotalPrice());
        }
        System.out.println("choose one: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index < 1 || index > orders.size()) {
            System.out.println("invalid index!!!");
            return;
        }
        OrderUser selectedOrder = orders.get(index - 1);
        show2(selectedOrder);
    }

    public void show2(OrderUser selectedOrder){
        List<Products> products = selectedOrder.getOrderedProducts();
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + " " + products.get(i).getName());
        }
        System.out.println("choose one to see details: ");
        int index2 = scanner.nextInt();
        scanner.nextLine();
        if (index2 < 1 || index2 > products.size()) {
            System.out.println("invalid index2!!!");
            return;
        }
        if (products == null || products.isEmpty()) {
            System.out.println("this order hasn't products.");
            return;
        }
        Products selectedProduct = products.get(index2 - 1);
        selectedProduct.showDetails();
    }
}
