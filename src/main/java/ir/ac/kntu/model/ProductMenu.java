package ir.ac.kntu.model;

import java.util.Scanner;

public class ProductMenu {

    private static final ProductMenu proMe = new ProductMenu();
    private Scanner scanner = new Scanner(System.in);

    public static ProductMenu getPm() {
        return proMe;
    }

    public void show(Seller seller) {
        ProductsManager prMg = ProductsManager.getInstance();
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("1.show all products\n2.add product\n3.choose product\n4.quit");
            System.out.println("choose one: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    prMg.showAllProducts(seller);
                    break;
                case 2:
                    AddProductMenu.getAddinstance().show(seller);
                    break;
                case 3:
                    ChooseProductMenu.getCpm().show();
                    break;
                case 4:
                    isTrue = false;
                    break;
                default:
                    System.out.println("invalid choice!!!");
            }
        }
    }
}
