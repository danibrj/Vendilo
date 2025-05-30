package ir.ac.kntu.model;

import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

public class MobileMenu {

    private static final MobileMenu mobileMenu = new MobileMenu();
    private Scanner scanner = new Scanner(System.in);

    public static MobileMenu getBookMenu() {
        return mobileMenu;
    }

    public void show(Seller seller) {
        System.out.println(blue+"Enter mobile's name: "+reset);
        String mname = scanner.nextLine();
        System.out.println(blue+"Enter mobile's price: "+reset);
        long mprice = scanner.nextLong();
        System.out.println(blue+"Enter mobile's instanceInventory: "+reset);
        int minstInventory = scanner.nextInt();
        scanner.nextLine();
        System.out.println(blue+"Enter mobile's brand: "+reset);
        String mbrand = scanner.nextLine();
        System.out.println(blue+"Enter mobile's internalMemorySize: "+reset);
        int mitlMemorySize = scanner.nextInt();
        System.out.println(blue+"Enter mobile's RAMSize: "+reset);
        int mRAMSize = scanner.nextInt();
        scanner.nextLine();
        System.out.println(blue+"Enter mobile's cameraInformation: "+reset);
        String mcamInformation = scanner.nextLine();
        System.out.println(blue+"Enter mobile's internetNetwork: "+reset);
        String minternetNetwork = scanner.nextLine();
        Mobile mobile = new Mobile(mname, mprice, minstInventory, mbrand, mitlMemorySize, mRAMSize, mcamInformation, minternetNetwork);
        mobile.setSeller(seller);
        ProductsManager.getInstance().addProduct(seller,mobile);
        System.out.println(green+"add book successfully"+reset);
    }
}
