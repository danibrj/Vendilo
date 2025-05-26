package ir.ac.kntu.model;

import java.util.List;
import java.util.Scanner;

public class ChooseProductMenu {

    private static final ChooseProductMenu cpmInstance = new ChooseProductMenu();
    private Scanner scanner = new Scanner(System.in);

    public static ChooseProductMenu getCpm() {
        return cpmInstance;
    }

    public void show() {
        System.out.println("Enter the name of your target product: ");
        String pName = scanner.nextLine();
        List<Products> ofSameName = ProductsManager.getInstance().findByName(pName);
        if (ofSameName.isEmpty()) {
            System.out.println("not found!!!");
            return;
        }
        if (ofSameName.size() == 1) {
            Products prds = ofSameName.get(0);
            ProductsManager.getInstance().showProductsDetails(prds);
            ChooseProductMenu2.getCpm2().show(prds);
        } else {
            System.out.println("the products with same name: ");
            for (int i = 0; i < ofSameName.size(); i++) {
                System.out.println((i + 1) + " " + ofSameName.get(i));
            }
            System.out.println("choose one: ");
            int num = scanner.nextInt();

            if (num >= 1 && num <= ofSameName.size()) {
                Products prds2 = ofSameName.get(num - 1);
                ProductsManager.getInstance().showProductsDetails(prds2);
                ChooseProductMenu2.getCpm2().show(prds2);
            } else {
                System.out.println("invalid selected!!!");
            }
        }
    }
}
