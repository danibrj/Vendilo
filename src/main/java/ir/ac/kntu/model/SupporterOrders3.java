package ir.ac.kntu.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

public class SupporterOrders3 {

    private static final SupporterOrders3 SuppO3Instance = new SupporterOrders3();
    private Scanner scanner = new Scanner(System.in);

    public static SupporterOrders3 getSuppO3Instance() {
        return SuppO3Instance;
    }

    public void show(List<OrderUser> orders){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Enter Start date: ");
        String startDate = scanner.nextLine();
        LocalDateTime start = LocalDateTime.parse(startDate, formatter);
        System.out.println("Enter end date: ");
        String endDate = scanner.nextLine();
        LocalDateTime end = LocalDateTime.parse(endDate, formatter);
        boolean isFound = false;
        for (OrderUser order : orders) {
            if (!order.getOrderDate().isBefore(start) && !order.getOrderDate().isAfter(end)) {
                System.out.println(order);
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println(red+"No orders found in the selected date range."+reset);
        }
    }
}
