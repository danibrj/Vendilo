package ir.ac.kntu.model;

import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

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
            System.out.println(red+"1."+ green+"selecting each one"+reset);
            System.out.println(red+"2."+ green+"shopping"+reset);
            System.out.println(red+"3."+ green+"quit"+reset);
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
                    System.out.println(red + "invalid select"+ reset);
            }
        }
    }
}
