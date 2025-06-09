package ir.ac.kntu.model;

import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

public class FirstSellerMenu {
    private SellerRepository sellerRepository;
//    private ManageRequests manageRequests;
    private Scanner scanner = new Scanner(System.in);

    public FirstSellerMenu(SellerRepository sellerRepository /*, ManageRequests manageRequests*/) {
        this.sellerRepository = sellerRepository;
//        this.manageRequests = manageRequests;
    }

    public void show() {
        RegisterSellerBugs regisSellBugs = new RegisterSellerBugs();
        CompleteRegister completeRegister = new CompleteRegister(regisSellBugs/*, manageRequests*/);
        while (true) {
            System.out.println(cyan +"|----------First Seller Menu----------|\n"+ red +"1."+ green +"register  \n"+ red +"2."+ green +"login  \n" + red +"3."+ green +"quit  \nselect your choice: " + reset);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    show2(completeRegister);
                    break;
                case 2:
                    SellerLoginSetuation sellLogSetuation = new SellerLoginSetuation(regisSellBugs/*, manageRequests*/, sellerRepository, completeRegister);
                    sellLogSetuation.show();
                    break;
                case 3:
                    return;
                default:
                    System.out.println(red +"invalid choice"+ reset);
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
        System.out.println(blue + "your request sent. please wait..."+ reset);
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
                System.out.println(red +"Invalid province. Please try again.\n"+ blue +"correct province: " + reset);
            }
        }
        return provinceOfSale;
    }
}
