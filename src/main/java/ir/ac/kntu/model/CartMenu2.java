package ir.ac.kntu.model;

import java.util.Scanner;

public class CartMenu2 {

    private static final CartMenu2 cmInstance = new CartMenu2();
    private Scanner scanner = new Scanner(System.in);

    public static CartMenu2 getCm() {
        return cmInstance;
    }

    public void show(ShoppingCart shoppingCart) {
        while (true) {
            for (int i = 0; i < shoppingCart.getProOfCart().size(); i++) {
                System.out.println((i + 1) + " " + shoppingCart.getProOfCart().get(i).getType()+shoppingCart.getProOfCart().get(i).getName());
            }
            System.out.println("choose one: ---(!indexNum : quit)---");
            int num = scanner.nextInt();
            scanner.nextLine();
            if (num >= 1 && num <= shoppingCart.getProOfCart().size()) {
                show2(shoppingCart,num);
            } else {
                return;
            }
        }
    }

    public void show2(ShoppingCart shoppingCart,int num){
        boolean bool = true;
        while (bool) {
            System.out.println("1.see all details");
            System.out.println("2.delete product");
            System.out.println("3.quit");
            int goal = scanner.nextInt();
            scanner.nextLine();
            switch (goal) {
                case 1:
                    shoppingCart.showPDetails(shoppingCart.getProOfCart().get(num - 1));
                    break;
                case 2:
                    shoppingCart.removePro(shoppingCart.getProOfCart().get(num - 1));
                    break;
                case 3:
                    bool = false;
                    break;
                default:
                    System.out.println("invalid goal!!!");
            }
        }
    }
}
