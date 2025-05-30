package ir.ac.kntu.model;

import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;
public class BookMenu {

    private static final BookMenu bookMenu = new BookMenu();
    private Scanner scanner = new Scanner(System.in);

    public static BookMenu getBookMenu() {
        return bookMenu;
    }

    public void show(Seller seller) {
        System.out.println(blue+"Enter book's name: "+reset);
        String bname = scanner.nextLine();
        System.out.println(blue+"Enter book's price: "+reset);
        long bprice = scanner.nextLong();
        scanner.nextLine();
        System.out.println(blue+"Enter book's instanceInventory: "+reset);
        int binsInventory = scanner.nextInt();
        scanner.nextLine();
        System.out.println(blue+"Enter book's authorName: "+reset);
        String bauthorName = scanner.nextLine();
        System.out.println(blue+"Enter book's pageCount: "+reset);
        int bpageCount = scanner.nextInt();
        scanner.nextLine();
        System.out.println(blue+"Enter book's genre: "+reset);
        String bgenre = scanner.nextLine();
        System.out.println(blue+"Enter book's ageGroup: "+reset);
        String bageGroup = scanner.nextLine();
        System.out.println(blue+"Enter book's ISBNid: "+reset);
        String bISBNid = scanner.nextLine();

        BookProducts book = new BookProducts(bname, bprice, binsInventory, bauthorName, bpageCount, bgenre, bageGroup, bISBNid);
        book.setSeller(seller);
        ProductsManager.getInstance().addProduct(seller,book);
        System.out.println(green +"add book successfully"+ reset);
    }
}
