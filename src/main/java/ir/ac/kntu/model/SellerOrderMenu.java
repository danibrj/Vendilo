package ir.ac.kntu.model;

import java.util.List;
import java.util.Scanner;

public class SellerOrderMenu {

    private static final SellerOrderMenu SOMInstance = new SellerOrderMenu();
    private Scanner scanner = new Scanner(System.in);
    public static SellerOrderMenu getSOMInstance() {
        return SOMInstance;
    }

    public void show(Seller seller) {
        boolean isGo = true;
        while (isGo) {
            System.out.println("---Seller Orders Menu---");
            System.out.println("1.show list of your shopping");
            System.out.println("2.see each shopping details");
            System.out.println("3.quit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    showSellerOrdersList(seller);
                    break;
                case 2:
                    showDetailsOfShopping(seller);
                    break;
                case 3:
                    isGo = false;
                    break;
                default:
                    System.out.println("invalid choices!!!");
            }

        }
    }

    public void showSellerOrdersList(Seller seller) {
        List<OrderUser> orders = OrderManager.getOMInstance().getOrderForSeller(seller);

        if (orders.isEmpty()) {
            System.out.println("not doing any shopping from you!!!");
            return;
        }

        int index = 0;
        for (OrderUser order : orders) {
            for (Products p : order.getOrderedProducts()) {
                if (p.getSeller().equals(seller)) {
                    System.out.println((index+1) + " " + p.getName() + " | Date: " + order.getOrderDate());
                    break;
                }
            }
            index++;
        }
    }

    public void showDetailsOfShopping(Seller seller) {
        List<OrderUser> orders = OrderManager.getOMInstance().getOrderForSeller(seller);

        if (orders.isEmpty()) {
            System.out.println("not doing any shopping from you!!!");
            return;
        }

        System.out.println("select number of shopping for see details: ");
        for (int i = 0; i < orders.size(); i++) {
            for (Products p : orders.get(i).getOrderedProducts()) {
                if (p.getSeller().equals(seller)) {
                    System.out.println((i + 1) + " " + p.getName() + " | Date: " + orders.get(i).getOrderDate());
                    break;
                }
            }
        }
        shows(orders,seller);
    }

    public void shows(List<OrderUser> orders,Seller seller){
        int selection = scanner.nextInt();
        scanner.nextLine();

        if (selection < 1 || selection > orders.size()) {
            System.out.println("invalid selection");
            return;
        }
        OrderUser selectedOrder = orders.get(selection - 1);
        System.out.println("----Shopping details----");
        System.out.println("Date: " + selectedOrder.getOrderDate());
        for (Products p : selectedOrder.getOrderedProducts()) {
            if (p.getSeller().equals(seller)) {
                System.out.println("name:" + p.getName() + " | price: " + p.getPrice() + " | type: " + p.getType());
            }
        }
        RegularUser buyer = selectedOrder.getBuyer();
        if (buyer != null) {
            System.out.println("buyer email: " + buyer.getEmail());
        } else {
            System.out.println("not found!!!");
        }
        System.out.println("Address: " + selectedOrder.getDeliveryAddress());
    }
}
