package ir.ac.kntu.model;

import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

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
            System.out.println(cyan +  "|----------Product Menu----------|\n"+red + "1" + green + ".show all products\n" + red + "2" + green + ".add product\n" + red + "3" + green + ".choose product\n" + red + "4" + green + ".quit" + reset);
            System.out.println(cyan+"choose one: "+reset);
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
                    System.out.println(red+"invalid choice!!!"+reset);
            }
        }
    }
}
