package ir.ac.kntu.model;

import java.util.Scanner;

public class ChooseProductMenu2 {

    private static final ChooseProductMenu2 CPM2 = new ChooseProductMenu2();
    private Scanner scanner = new Scanner(System.in);

    public static ChooseProductMenu2 getCpm2() {
        return CPM2;
    }

    public void show(Products prod) {
        boolean isOk = true;
        while (isOk) {
            System.out.println("1.increase inventory\n2.decrease inventory\n3.quit");
            System.out.println("choose one:");
            int sel = scanner.nextInt();
            scanner.nextLine();
            switch (sel) {
                case 1:
                    System.out.println("how much do you want to increase: ");
                    int amount1 = scanner.nextInt();
                    ProductsManager.getInstance().increaseInventory(prod, amount1);
                    break;
                case 2:
                    System.out.println("how much do you want to decrease: ");
                    int amount2 = scanner.nextInt();
                    ProductsManager.getInstance().decreaseInventory(prod, amount2);
                    break;
                case 3:
                    isOk = false;
                    break;
                default:
                    System.out.println("invalid selected!!!");
            }
        }
    }
}
