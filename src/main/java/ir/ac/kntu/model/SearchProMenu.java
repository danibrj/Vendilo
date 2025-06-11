package ir.ac.kntu.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static ir.ac.kntu.model.Color.*;

public class SearchProMenu {

    private static final SearchProMenu SPM = new SearchProMenu();
    private Scanner scanner = new Scanner(System.in);

    public static SearchProMenu getSpm() {
        return SPM;
    }

    public void show(ShoppingCart shoppingCart, RegularUser user) {
        boolean bool1 = true;
        while (bool1) {
            System.out.println(cyan + "Enter the name of your target product: ---- (quit)" + reset);
            String proName = scanner.nextLine();
            if ("quit".equalsIgnoreCase(proName)) {
                return;
            }
            List<Products> targetList = ProductsManager.getInstance().findByName(proName);

            if (targetList.isEmpty()) {
                System.out.println(red + "No products found with the given name." + reset);
                continue;
            }
            List<Products> copyOfTList = new ArrayList<>(targetList);
            System.out.println(green + "do you want to use filter? " + blue + "(1.Ascending or 2.descending or 3.nothing)" + reset);
            int num = scanner.nextInt();
            scanner.nextLine();
            switch (num) {
                case 1 -> copyOfTList.sort(Comparator.comparing(Products::getPrice));
                case 2 -> copyOfTList.sort(Comparator.comparing(Products::getPrice).reversed());
                case 3 -> System.out.println();
                default -> System.out.println(red + "invalid num!!!" + reset);
            }
            show2(copyOfTList, shoppingCart, user);
        }
    }

    public void show2(List<Products> copyOfTList, ShoppingCart shoppingCart, RegularUser user) {
        VendiloPlus targetVend = VendiloPlusManager.getVpmInstance().findVendByUser(user);
        LocalDateTime now = LocalDateTime.now();
        System.out.println("do you want to filter by (1.rate|2.price)?");
        String answer = scanner.nextLine();
        if ("yes".equals(answer)) {
            System.out.println("choose your goal: (by 1 or 2)");
            int num = scanner.nextInt();
            scanner.nextLine();
            if (num == 1) {
                System.out.println("choose start and end of your range of rate: \nstart: ");
                double startRate = scanner.nextDouble();
                System.out.println("end: ");
                double endRate = scanner.nextDouble();
                if (targetVend != null && (targetVend.getExpirationDate().isEqual(now) || targetVend.getExpirationDate().isAfter(now))) {
                    for (int i = 0; i < copyOfTList.size(); i++) {
                        copyOfTList.get(i).setPrice(copyOfTList.get(i).getPrice() * 0.95);
                        if (copyOfTList.get(i).getAverageRating() >= startRate && copyOfTList.get(i).getAverageRating() <= endRate) {
                            System.out.println((i + 1) + " " + copyOfTList.get(i));
                        }
                    }
                } else {
                    for (int i = 0; i < copyOfTList.size(); i++) {
                        if (copyOfTList.get(i).getAverageRating() >= startRate && copyOfTList.get(i).getAverageRating() <= endRate) {
                            System.out.println((i + 1) + " " + copyOfTList.get(i));
                        }
                    }
                }
            } else if (num == 2) {
                System.out.println("choose start and end of your range of price: \nstart: ");
                double startPrice = scanner.nextDouble();
                System.out.println("end: ");
                double endPrice = scanner.nextDouble();
                if (targetVend != null && (targetVend.getExpirationDate().isEqual(now) || targetVend.getExpirationDate().isAfter(now))) {
                    for (int i = 0; i < copyOfTList.size(); i++) {
                        copyOfTList.get(i).setPrice(copyOfTList.get(i).getPrice() * 0.95);
                        if (copyOfTList.get(i).getPrice() >= startPrice && copyOfTList.get(i).getPrice() <= endPrice) {
                            System.out.println((i + 1) + " " + copyOfTList.get(i));
                        }
                    }
                } else {
                    for (int i = 0; i < copyOfTList.size(); i++) {
                        if (copyOfTList.get(i).getPrice() >= startPrice && copyOfTList.get(i).getPrice() <= endPrice) {
                            System.out.println((i + 1) + " " + copyOfTList.get(i));
                        }
                    }
                }
            }
        } else {
            if (targetVend != null && (targetVend.getExpirationDate().isEqual(now) || targetVend.getExpirationDate().isAfter(now))) {
                for (int i = 0; i < copyOfTList.size(); i++) {
                    copyOfTList.get(i).setPrice(copyOfTList.get(i).getPrice() * 0.95);
                    System.out.println((i + 1) + " " + copyOfTList.get(i));
                }
            } else {
                for (int i = 0; i < copyOfTList.size(); i++) {
                    System.out.println((i + 1) + " " + copyOfTList.get(i));
                }
            }
        }
        System.out.println(cyan + "which product do you want to add to cart? " + reset);
        int num2 = scanner.nextInt();
        scanner.nextLine();
        if (num2 < 1 || num2 > copyOfTList.size()) {
            System.out.println(red + "Invalid product number." + reset);
            return;
        }
        if (copyOfTList.get(num2 - 1).getInstanceInventory() <= 0) {
            System.out.println(red + "product doesn't has inventory.\n" + cyan + "do you want to be notified when inventory increases?ln" + reset);
            String answer2 = scanner.nextLine();
            if ("yes".equalsIgnoreCase(answer2)) {
                copyOfTList.get(num2 - 1).setLetMeKnow(user, true);
            }
        }
        if (num2 >= 1 && num2 <= copyOfTList.size() && copyOfTList.get(num2 - 1).getInstanceInventory() >= 1) {
            shoppingCart.addProToCart(copyOfTList.get(num2 - 1));
            System.out.println(green + "Product added to cart." + reset);
        }
    }
}
