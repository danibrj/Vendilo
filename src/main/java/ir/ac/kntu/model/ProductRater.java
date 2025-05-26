package ir.ac.kntu.model;

import java.util.List;
import java.util.Scanner;

public class ProductRater {

    private static final ProductRater PRInstance = new ProductRater();
    private Scanner scanner = new Scanner(System.in);

    public static ProductRater getPRInstance() {
        return PRInstance;
    }

    public void show(RegularUser user) {
        List<OrderUser> orders = user.getOrderUsers();
        if (orders.isEmpty()) {
            System.out.println("not found order for view details.");
            return;
        }
        System.out.println("select an order: ");
        for (int i = 0; i < orders.size(); i++) {
            System.out.println((i + 1) + " order date: " + orders.get(i).getOrderDate());
        }
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index < 1 || index > orders.size()) {
            System.out.println("invalid selected");
            return;
        }
        OrderUser selectedOrder = orders.get(index - 1);
        List<Products> pros = selectedOrder.getOrderedProducts();
        System.out.println("select a product to rate: ");
        for (int i = 0; i < pros.size(); i++) {
            Products prod = pros.get(i);
            System.out.println((i + 1) + " " + prod.getName() + " | Average: " + prod.getAverageRating());
        }
        show2(pros,user);
    }

    public void show2(List<Products> pros,RegularUser user){
        int num = scanner.nextInt();
        scanner.nextLine();
        if (num < 1 || num > pros.size()) {
            System.out.println("invalid select");
            return;
        }
        Products selectedProduct = pros.get(num - 1);
        if (selectedProduct.hasUserRated(user)) {
            System.out.println("You have already rated this product.");
            return;
        }
        System.out.println("Enter rating (1 to 5): ");
        int rating = scanner.nextInt();
        scanner.nextLine();

        if (rating < 1 || rating > 5) {
            System.out.println("invalid rating");
            return;
        }
        selectedProduct.addRating(user, rating);
        System.out.println("thanks for rating.");
    }
}
