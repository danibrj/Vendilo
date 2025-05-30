package ir.ac.kntu.model;

import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;


public class LaptopMenu {

    private static final LaptopMenu laptopMenu = new LaptopMenu();
    private Scanner scanner = new Scanner(System.in);

    public static LaptopMenu getLaptopMenu() {
        return laptopMenu;
    }

    public void show(Seller seller) {
        Laptop laptop = show2();
        laptop.setSeller(seller);
        ProductsManager.getInstance().addProduct(seller,laptop);
        System.out.println(green+"add laptop successfully"+reset);
    }

    public Laptop show2() {
        System.out.println(blue+"Enter laptop's name: "+reset);
        String lname = scanner.nextLine();
        System.out.println(blue+"Enter laptop's price: "+reset);
        long lprice = scanner.nextLong();
        scanner.nextLine();
        System.out.println(blue+"Enter laptop's instanceInventory: "+reset);
        int lInstInventory = scanner.nextInt();
        scanner.nextLine();
        System.out.println(blue+"Enter laptop's GPUModel: "+reset);
        String lGPUModel = scanner.nextLine();
        System.out.println(blue+"Enter laptop's brand: "+reset);
        String lbrand = scanner.nextLine();
        System.out.println(blue+"Enter laptop's internalMemorySize: "+reset);
        int itlMemorySize = scanner.nextInt();
        System.out.println(blue+"Enter laptop's RAMSize: "+reset);
        int lRAMSize = scanner.nextInt();
        scanner.nextLine();
        System.out.println(blue+"Enter laptop's isConnectingToBul: "+reset);
        String lisConnToBul = scanner.nextLine();
        System.out.println(blue+"Enter laptop's hasWebcam: "+reset);
        String lhasWebcam = scanner.nextLine();
        return new Laptop(lname, lprice, lInstInventory, lbrand, itlMemorySize, lRAMSize, lGPUModel, lisConnToBul, lhasWebcam);
    }
}
