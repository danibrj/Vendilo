package ir.ac.kntu.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
        LocalDateTime start = null;
        LocalDateTime end = null;
        while(start == null || end == null) {
            System.out.println("Enter Start date: ");
            String startDate = scanner.nextLine();
            System.out.println("Enter end date: ");
            String endDate = scanner.nextLine();
            try {
                start = LocalDateTime.parse(startDate, formatter);
                end = LocalDateTime.parse(endDate, formatter);
            } catch (DateTimeParseException e){
                System.out.println(red + "invalid date format" + reset);
            }
        }
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
