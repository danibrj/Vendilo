package ir.ac.kntu.model;

import java.util.Scanner;

public class CartMenu {

    private static final CartMenu CART_MENU = new CartMenu();
    private Scanner scanner = new Scanner(System.in);

    public static CartMenu getCartMenu() {
        return CART_MENU;
    }

    public void show(ShoppingCart shoppingCart, RegularUser user) {
        shoppingCart.showAllProOfCart();
        boolean isCon = true;
        while (isCon) {
            System.out.println("1.selecting each one");
            System.out.println("2.shopping");
            System.out.println("3.quit");
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1:
                    CartMenu2.getCm().show(shoppingCart);
                    break;
                case 2:
                    ShoppingMenu.getShoppMenu().show(shoppingCart, user);
                    break;
                case 3:
                    isCon = false;
                    break;
                default:
                    System.out.println("invalid select");
            }
        }
    }
}
