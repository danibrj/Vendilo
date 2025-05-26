package ir.ac.kntu.model;

import java.util.Scanner;

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
        System.out.println("add laptop successfully");
    }

    public Laptop show2() {
        System.out.println("Enter laptop's name: ");
        String lname = scanner.nextLine();
        System.out.println("Enter laptop's price: ");
        long lprice = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter laptop's instanceInventory: ");
        int lInstInventory = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter laptop's GPUModel: ");
        String lGPUModel = scanner.nextLine();
        System.out.println("Enter laptop's brand: ");
        String lbrand = scanner.nextLine();
        System.out.println("Enter laptop's internalMemorySize: ");
        int itlMemorySize = scanner.nextInt();
        System.out.println("Enter laptop's RAMSize: ");
        int lRAMSize = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter laptop's isConnectingToBul: ");
        String lisConnToBul = scanner.nextLine();
        System.out.println("Enter laptop's hasWebcam: ");
        String lhasWebcam = scanner.nextLine();
        return new Laptop(lname, lprice, lInstInventory, lbrand, itlMemorySize, lRAMSize, lGPUModel, lisConnToBul, lhasWebcam);
    }
}
