package ir.ac.kntu.model;

import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

public class SellerMenuLogin2 {
    private RegisterSellerBugs registSellBugs;
    private Scanner scanner = new Scanner(System.in);

    public SellerMenuLogin2(RegisterSellerBugs registSellBugs/*,Seller seller*/) {
        this.registSellBugs = registSellBugs;
    }

    public void show(Seller seller) {
        System.out.println(blue+"Enter your agencyCode: "+reset);
        String agCode = scanner.nextLine();
        System.out.println(blue+"Enter your password: "+reset);
        String pass = scanner.nextLine();
        for (Seller sl : registSellBugs.getSellers()) {
            if (sl.getAgencyCode() != null && sl.getAgencyCode().equals(agCode) && sl.getPassword().equals(pass)) {
                seller = sl;
                break;
            }
        }
    }
}
