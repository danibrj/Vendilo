package ir.ac.kntu.model;

import java.util.Scanner;

public class AddProductMenu {

    private static final AddProductMenu Addinstance = new AddProductMenu();
    private Scanner scanner = new Scanner(System.in);

    public static AddProductMenu getAddinstance() {
        return Addinstance;
    }

    public void show(Seller seller) {
        boolean bool = true;
        while (bool) {
            System.out.println("choose your type of products: ");
            System.out.println("1.book\n2.laptop\n3.mobile\n4.quit");
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1:
                    BookMenu.getBookMenu().show(seller);
                    break;
                case 2:
                    LaptopMenu.getLaptopMenu().show(seller);
                    break;
                case 3:
                    MobileMenu.getBookMenu().show(seller);
                    break;
                case 4:
                    bool = false;
                    break;
                default:
                    System.out.println("invalid select!!!");
            }
        }
    }
}
