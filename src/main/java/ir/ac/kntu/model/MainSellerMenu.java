package ir.ac.kntu.model;

import java.util.Scanner;

public class MainSellerMenu {

    private static final MainSellerMenu msmInstance = new MainSellerMenu();
    private Scanner scanner = new Scanner(System.in);

    public static MainSellerMenu getMsm() {
        return msmInstance;
    }

    public void show(Seller seller) {
        boolean bool = true;
        while (bool) {
            System.out.println("1.products\n2.wallet\n3.orders\n4.quit\nchoose one: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    ProductMenu.getPm().show(seller);
                    break;
                case 2:
                    ShowSellerWallet.getSSWInstance().show(seller);
                    break;
                case 3:
                    SellerOrderMenu.getSOMInstance().show(seller);
                    break;
                case 4:
                    bool = false;
                    break;
                default:
                    System.out.println("invalid choice");
            }
        }
    }
}
