package ir.ac.kntu.model;

import java.util.Scanner;

public class SellerLoginSetuation {

    private RegisterSellerBugs regisSellBugs;
    private ManageRequests manageRequests;
    private SellerRepository sellerRepository;
    private CompleteRegister completeRegister;
    private Scanner scanner = new Scanner(System.in);

    public SellerLoginSetuation(RegisterSellerBugs registSellBugs, ManageRequests manageRequests, SellerRepository sellerRepository, CompleteRegister completeRegister) {
        this.regisSellBugs = registSellBugs;
        this.manageRequests = manageRequests;
        this.sellerRepository = sellerRepository;
        this.completeRegister = completeRegister;
    }

    public void show() {
        System.out.println("Enter your phone number or nationality code: ");
        String input = scanner.nextLine();
        Seller foundSeller = sellerRepository.findByPhoneOrNationalCode(input);

        if (foundSeller == null) {
            System.out.println("Seller not found! Please register first.");
            return;
        }
        IsOkFromSupporter isOkFromSupporter = new IsOkFromSupporter(manageRequests, foundSeller);
        isOkFromSupporter.show();
        SellerMenuLogin sellerMenuLogin = new SellerMenuLogin(regisSellBugs, completeRegister, foundSeller);
        sellerMenuLogin.show();
    }
}
