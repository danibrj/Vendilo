package ir.ac.kntu.model;

import java.util.Scanner;

import static ir.ac.kntu.model.Color.cyan;
import static ir.ac.kntu.model.Color.green;
import static ir.ac.kntu.model.Color.red;
import static ir.ac.kntu.model.Color.reset;

public class AddProductMenu {

    private static final AddProductMenu Addinstance = new AddProductMenu();
    private Scanner scanner = new Scanner(System.in);

    public static AddProductMenu getAddinstance() {
        return Addinstance;
    }

    public void show(Seller seller) {
        boolean bool = true;
        while (bool) {
            System.out.println(cyan + "choose your type of products: " + reset);
            System.out.println(red + "1" + green + ".book\n" + red + "2" + green + ".laptop\n" + red + "3" + green + ".mobile\n" + red + "4" + green + ".quit" + reset);
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
                    System.out.println(red+"invalid select!!!"+reset);
            }
        }
    }
}
