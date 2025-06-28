package ir.ac.kntu.model;

import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

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
            System.out.println(cyan + "|----------Wallet Menu----------|\nchoose one:\n" + red + "1" + green + ".show inventory\n" + red + "2" + green + ".withdraw money\n" + red + "3" + green + ".transaction\n" +red + "4" + green + ".quit" + reset);
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
                    ShowSellersTrans.getSstInstance().show(sellerWallet);
                    break;
                case 4:
                    isOk = false;
                    break;
                default:
                    System.out.println(red+"invalid select!!!"+reset);
            }
        }

    }
}
