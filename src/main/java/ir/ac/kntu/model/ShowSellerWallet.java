package ir.ac.kntu.model;

import java.util.Scanner;

public class ShowSellerWallet {

    private static final ShowSellerWallet SSWInstance = new ShowSellerWallet();
    private Scanner scanner = new Scanner(System.in);

    public static ShowSellerWallet getSSWInstance() {
        return SSWInstance;
    }

    public void show(Seller seller) {
        SellerWallet sellerWallet = seller.getSellerWallet();
        boolean isOk = true;
        while (isOk) {
            System.out.println("choose one: \n1.show inventory\n2.withdraw money\n3.quit");
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1:
                    System.out.println("your inventory is: " + sellerWallet.getInventory() + " $");
                    break;
                case 2:
                    System.out.println("how much money do you want to withdraw?");
                    double money = scanner.nextDouble();
                    sellerWallet.getMoney(money);
                    break;
                case 3:
                    isOk = false;
                    break;
                default:
                    System.out.println("invalid select!!!");
            }
        }

    }
}
