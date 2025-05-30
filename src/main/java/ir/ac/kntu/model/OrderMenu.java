package ir.ac.kntu.model;

import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

public class OrderMenu {

    private static final OrderMenu OInstance = new OrderMenu();
    private Scanner scanner = new Scanner(System.in);

    public static OrderMenu getOInstance() {
        return OInstance;
    }

    public void show(RegularUser user) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(cyan+"\n----------order management----------\n"+reset);
            System.out.println(red + "1." + green + "show all orders\n" + red + "2." + green + "view order details\n" + red + "3." + green + "rate a product in an order\n" + red + "4." + green + "quit\n" + cyan+"choose an option: " + reset);
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
