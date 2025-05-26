package ir.ac.kntu.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SearchProMenu {

    private static final SearchProMenu SPM = new SearchProMenu();
    private Scanner scanner = new Scanner(System.in);

    public static SearchProMenu getSpm() {
        return SPM;
    }

    public void show(ShoppingCart shoppingCart) {
        boolean bool1 = true;
        while (bool1) {
            System.out.println("Enter the name of your target product: ---- (quit)");
            String proName = scanner.nextLine();
            if ("quit".equalsIgnoreCase(proName)) {
                return;
            }
            List<Products> targetList = ProductsManager.getInstance().findByName(proName);

            if (targetList.isEmpty()) {
                System.out.println("No products found with the given name.");
                continue;
            }
            List<Products> copyOfTList = new ArrayList<>(targetList);
            System.out.println("do you want to use filter? (1.Ascending or 2.descending or 3.nothing)");
            int num = scanner.nextInt();
            scanner.nextLine();
            switch (num) {
                case 1 -> copyOfTList.sort(Comparator.comparing(Products::getPrice));
                case 2 -> copyOfTList.sort(Comparator.comparing(Products::getPrice).reversed());
                case 3 -> System.out.println();
                default -> System.out.println("invalid num!!!");
            }
            show2(copyOfTList,shoppingCart);
        }
    }

    public void show2(List<Products> copyOfTList,ShoppingCart shoppingCart){
        for (int i = 0; i < copyOfTList.size(); i++) {
            System.out.println((i + 1) + " " + copyOfTList.get(i));
        }
        System.out.println("which product do you want to add to cart? ");
        int num2 = scanner.nextInt();
        scanner.nextLine();
        if (num2 >= 1 && num2 <= copyOfTList.size()) {
            shoppingCart.addProToCart(copyOfTList.get(num2 - 1));
            System.out.println("Product added to cart.");
        } else {
            System.out.println("Invalid product number.");
        }
    }
}
