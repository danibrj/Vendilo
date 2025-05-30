package ir.ac.kntu.model;

import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

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
            System.out.println(cyan+"choose one: ---(!indexNum : quit)---"+reset);
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
            System.out.println(red+"1."+green+"see all details"+reset);
            System.out.println(red+"2."+green+"delete product"+reset);
            System.out.println(red+"3."+green+"quit"+reset);
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
                    System.out.println(red+"invalid goal!!!"+reset);
            }
        }
    }
}
