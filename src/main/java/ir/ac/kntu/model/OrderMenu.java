package ir.ac.kntu.model;

import java.util.Scanner;

public class OrderMenu {

    private static final OrderMenu OInstance = new OrderMenu();
    private Scanner scanner = new Scanner(System.in);

    public static OrderMenu getOInstance() {
        return OInstance;
    }

    public void show(RegularUser user) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n----order management----");
            System.out.println("\n1.show all orders\n2.view order details\n3.rate a product in an order\n4.quit\nchoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    ShowOrders.getSOInstance().show(user);
                    break;
                case 2:
                    ShowOrderDetails.getSODInstance().show(user);
                    break;
                case 3:
                    ProductRater.getPRInstance().show(user);
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("invalid choices");
            }
        }
    }
}
