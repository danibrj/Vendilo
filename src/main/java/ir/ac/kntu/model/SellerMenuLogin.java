package ir.ac.kntu.model;

import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

public class SellerMenuLogin {

    private RegisterSellerBugs regisSellBugs;
    private CompleteRegister completeRegis;
    private Seller seller;
    private Scanner scanner = new Scanner(System.in);

    public SellerMenuLogin(RegisterSellerBugs registSellBugs, CompleteRegister completeRegis, Seller seller) {
        this.regisSellBugs = registSellBugs;
        this.completeRegis = completeRegis;
        this.seller = seller;
    }

    public void show() {
        SellerMenuLogin2 sellerMenuLogin2 = new SellerMenuLogin2(regisSellBugs);
        sellerMenuLogin2.show(seller);
        if (seller == null) {
            System.out.println(red+"these information are wrong"+reset);
        } else if (seller.isApproved()) {
            System.out.println(green+"LOGIN SUCCESSFULLY."+reset);
            MainSellerMenu.getMsm().show(seller);
        } else if (seller.isRejected()) {
            System.out.println("your registration was rejected.");
            System.out.println("reason: " + seller.getReason());
            System.out.println("Do you want to update your information and try again for register? (yes/no) ");
            String answer = scanner.nextLine();
            if ("yes".equalsIgnoreCase(answer)) {
                show2();
            } else {
                System.out.println(green+"ok you don't want to update your information"+reset);
            }
        } else {
            System.out.println("your registering is under review");
        }
    }

    public void show2(){
        System.out.print("firstName: ");
        String newFirstName = scanner.nextLine();
        System.out.print("lastName: ");
        String newLastName = scanner.nextLine();
        System.out.print("storeTitle: ");
        String newStoreTitle = scanner.nextLine();
        System.out.print("nationalCode: ");
        String newNationalCode = scanner.nextLine();
        System.out.print("phoneNumber: ");
        String newPhoneNumber = scanner.nextLine();
        System.out.print("password: ");
        String newPassword = scanner.nextLine();
        System.out.print("provinceOfSale: ");
        String newProvinceOfSale = scanner.nextLine();
        seller.setRejected(false);
        seller = new Seller(newFirstName, newLastName, newStoreTitle, newNationalCode, newPhoneNumber, newPassword, newProvinceOfSale);
        completeRegis.show(seller);
    }
}
