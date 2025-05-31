package ir.ac.kntu.model;

import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

public class MainRegularUserMenu {
    private static final MainRegularUserMenu mrumInstance = new MainRegularUserMenu();
    private Scanner scanner = new Scanner(System.in);

    public static MainRegularUserMenu getMrum(){
        return mrumInstance;
    }

    public void show(RegularUser user) {
        ShoppingCart shoppingCart = ShoppingCart.getSpInstance();
        while (true) {
//            System.out.println("select your item: \n1.WALLET\n2.SETTING\n3.ADDRESSES\n4.SEARCH PRODUCTS\n5.CART\n6.ORDER\n7.SUPPORT\n8.quit");
            System.out.println(cyan + "|----------Main Seller Menu----------|\nselect your item: \n" + red + "1" + green + ".WALLET\n" + red + "2" + green + ".SETTING\n" + red + "3" + green + ".ADDRESSES\n" + red + "4" + green + ".SEARCH PRODUCTS\n" + red + "5" + green + ".CART\n" + red + "6" + green + ".ORDER\n" + red + "7" + green + ".SUPPORT\n" + red + "8" + green + ".quit" + reset);

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> ShowWallet.getShowWal().show(user);
                case 2 -> ShowSetting.getShowSet().show();
                case 3 -> ShowAddresses.getShowAdd().show(user );
                case 4 -> SearchProMenu.getSpm().show(shoppingCart);
                case 5 -> CartMenu.getCartMenu().show(shoppingCart,user);
                case 6 -> OrderMenu.getOInstance().show(user);
                case 7 -> ShowReportsMenu.getSRMInstance().show(user);
                case 8 -> {
                    return;
                }
                default -> System.out.println(red +"invalid choice"+ reset);
            }
        }
    }
}
