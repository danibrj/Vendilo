package ir.ac.kntu.model;

import java.util.Scanner;

public class FirstSellerMenu {

    private SellerRepository sellerRepository;
    private ManageRequests manageRequests;
    private Scanner scanner = new Scanner(System.in);

    public FirstSellerMenu(SellerRepository sellerRepository, ManageRequests manageRequests) {
        this.sellerRepository = sellerRepository;
        this.manageRequests = manageRequests;
    }

    public void show() {
        RegisterSellerBugs regisSellBugs = new RegisterSellerBugs();
        CompleteRegister completeRegister = new CompleteRegister(regisSellBugs, manageRequests);
        while (true) {
            System.out.println("----------Main Seller Menu----------\n1.register  \n2.login  \n3.quit  \nselect your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    show2(completeRegister);
                    break;
                case 2:
                    SellerLoginSetuation sellLogSetuation = new SellerLoginSetuation(regisSellBugs, manageRequests, sellerRepository, completeRegister);
                    sellLogSetuation.show();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("invalid choice");
            }
        }
    }

    public void show2(CompleteRegister completeRegister){
        System.out.println("firstName: ");
        String firstName = scanner.nextLine();
        System.out.println("lastName: ");
        String lastName = scanner.nextLine();
        System.out.println("storeTitle: ");
        String storeTitle = scanner.nextLine();
        System.out.println("nationalCode: ");
        String nationalCode = scanner.nextLine();
        System.out.println("phoneNumber: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("password: ");
        String password = scanner.nextLine();
        System.out.println("provinceOfSale: ");
        String provinceOfSale = forProvince();
        Seller seller = new Seller(firstName, lastName, storeTitle, nationalCode, phoneNumber, password, provinceOfSale);
        sellerRepository.addSeller(seller);
        completeRegister.show(seller);
        System.out.println("your request sent. please wait...");
    }

    public String forProvince(){
        String provinceOfSale;
        while(true) {
            provinceOfSale = scanner.nextLine().trim();
            boolean bool = false;
            for (Province prov : Province.values()) {
                if (prov.name().equalsIgnoreCase(provinceOfSale)){
                    bool = true;
                    break;
                }
            }
            if(bool){
                break;
            }else{
                System.out.println("Invalid province. Please try again.\ncorrect province: ");
            }
        }
        return provinceOfSale;
    }
}
