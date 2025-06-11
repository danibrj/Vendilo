package ir.ac.kntu.model;

import java.util.List;
import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;


public class ProductRater {

    private static final ProductRater PRInstance = new ProductRater();
    private Scanner scanner = new Scanner(System.in);

    public static ProductRater getPRInstance() {
        return PRInstance;
    }

    public void show(RegularUser user) {
        List<OrderUser> orders = user.getOrderUsers();
        if (orders.isEmpty()) {
            System.out.println(red+"not found order for ratting."+reset);
            return;
        }
        System.out.println(cyan+"select an order: "+reset);
        for (int i = 0; i < orders.size(); i++) {
            System.out.println((i + 1) + " order date: " + orders.get(i).getOrderDate());
        }
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index < 1 || index > orders.size()) {
            System.out.println(red+"invalid selected"+reset);
            return;
        }
        OrderUser selectedOrder = orders.get(index - 1);
        List<Products> pros = selectedOrder.getOrderedProducts();
        System.out.println(cyan+"select a product to rate: "+reset);
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
            System.out.println(red+"invalid select"+reset);
            return;
        }
        Products selectedProduct = pros.get(num - 1);
        if (selectedProduct.hasUserRated(user)) {
            System.out.println(red+"You have already rated this product."+reset);
            return;
        }
        System.out.println(cyan+"Enter rating (1 to 5): "+reset);
        int rating = scanner.nextInt();
        scanner.nextLine();

        if (rating < 1 || rating > 5) {
            System.out.println(red+"invalid rating"+reset);
            return;
        }
        selectedProduct.addRating(user, rating);
        System.out.println(green+"thanks for rating.\n"+ cyan+ "do you want to add comment?\n" +reset);
        String answer = scanner.nextLine();
        if("yes".equals(answer)){
            System.out.println(green+"write your comment: "+reset);
            String comment = scanner.nextLine();
            selectedProduct.addComments(user,comment);
        }
    }
}
