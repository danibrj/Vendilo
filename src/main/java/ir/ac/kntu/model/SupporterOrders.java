package ir.ac.kntu.model;

import java.util.List;
import java.util.Scanner;

public class SupporterOrders {
    private static final SupporterOrders SupOInstance = new SupporterOrders();
    private Scanner scanner = new Scanner(System.in);

    public static SupporterOrders getSupOInstance() {
        return SupOInstance;
    }


    public void show() {
        boolean isContinue = true;
        while (isContinue) {
            List<OrderUser> orders = OrderManager.getOMInstance().getAllOrders();
            System.out.println("1.show all orders\n2.show order's product's details\n3.show orders by filter\n4.quit\nselect one: ");
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1:
                    for (OrderUser order : orders) {
                        order.showOrderDetails();
                    }
                    break;
                case 2:
                    SupporterOrders2.getSuppO2Instance().show(orders);
                    break;
                case 3:
                    SupporterOrders3.getSuppO3Instance().show(orders);
                    break;
                case 4:
                    isContinue = false;
                    break;
                default:
                    System.out.println("invalid select!!!");
            }
        }
    }
}
