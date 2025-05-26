package ir.ac.kntu.model;

import java.util.Scanner;

public class MobileMenu {

    private static final MobileMenu mobileMenu = new MobileMenu();
    private Scanner scanner = new Scanner(System.in);

    public static MobileMenu getBookMenu() {
        return mobileMenu;
    }

    public void show(Seller seller) {
        System.out.println("Enter mobile's name: ");
        String mname = scanner.nextLine();
        System.out.println("Enter mobile's price: ");
        long mprice = scanner.nextLong();
        System.out.println("Enter mobile's instanceInventory: ");
        int minstInventory = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter mobile's brand: ");
        String mbrand = scanner.nextLine();
        System.out.println("Enter mobile's internalMemorySize: ");
        int mitlMemorySize = scanner.nextInt();
        System.out.println("Enter mobile's RAMSize: ");
        int mRAMSize = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter mobile's cameraInformation: ");
        String mcamInformation = scanner.nextLine();
        System.out.println("Enter mobile's internetNetwork: ");
        String minternetNetwork = scanner.nextLine();
        Mobile mobile = new Mobile(mname, mprice, minstInventory, mbrand, mitlMemorySize, mRAMSize, mcamInformation, minternetNetwork);
        mobile.setSeller(seller);
        ProductsManager.getInstance().addProduct(seller,mobile);
        System.out.println("add book successfully");
    }
}
