package ir.ac.kntu.model;

import java.util.Scanner;

import static ir.ac.kntu.model.Color.*;

public class ShoppingMenu {

    private static final ShoppingMenu shoppMenu = new ShoppingMenu();
    private Scanner scanner = new Scanner(System.in);

    public static ShoppingMenu getShoppMenu() {
        return shoppMenu;
    }

    public void show(ShoppingCart shoppingCart, RegularUser user) {
        if (user.getUsersAddress().getAddresses() == null) {
            show3(shoppingCart, user);
        } else if(user.getUsersAddress().getAddresses() != null && !user.getUsersAddress().getAddresses().isEmpty()) {
            for (int i = 0; i < user.getUsersAddress().getAddresses().size(); i++) {
                System.out.println((i + 1) + " " + user.getUsersAddress().getAddresses().get(i));
            }
            System.out.println("choose one : ");
            int num = scanner.nextInt();
            scanner.nextLine();
            show2(shoppingCart, user, num);
        }
    }

    public void show2(ShoppingCart shoppingCart, RegularUser user, int num) {
        if (num >= 1 && num <= user.getUsersAddress().getAddresses().size()) {
            Address selAddres = user.getUsersAddress().getAddresses().get(num - 1);
            shoppingCart.costOfSend(selAddres, user);
        } else {
            System.out.println(red + "invalid num!!!" + reset);
        }
    }

    public void show3(ShoppingCart shoppingCart, RegularUser user) {
        System.out.println("+Address:");
        System.out.println("Enter  title:");
        String aTitle = scanner.nextLine();
        System.out.println("Enter  province:");
        String aProvince = scanner.nextLine();
        System.out.println("Enter  city:");
        String aCity = scanner.nextLine();
        System.out.println("Enter  information:");
        String aInfo = scanner.nextLine();
        Address adress = new Address(aTitle, aProvince, aCity, aInfo);
        user.getUsersAddress().addAddresses(adress);
        shoppingCart.costOfSend(adress, user);
    }
}
