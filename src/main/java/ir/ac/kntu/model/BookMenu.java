package ir.ac.kntu.model;

import java.util.Scanner;

public class BookMenu {

    private static final BookMenu bookMenu = new BookMenu();
    private Scanner scanner = new Scanner(System.in);

    public static BookMenu getBookMenu() {
        return bookMenu;
    }

    public void show(Seller seller) {
        System.out.println("Enter book's name: ");
        String bname = scanner.nextLine();
        System.out.println("Enter book's price: ");
        long bprice = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter book's instanceInventory: ");
        int binsInventory = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter book's authorName: ");
        String bauthorName = scanner.nextLine();
        System.out.println("Enter book's pageCount: ");
        int bpageCount = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter book's genre: ");
        String bgenre = scanner.nextLine();
        System.out.println("Enter book's ageQroup: ");
        String bageQroup = scanner.nextLine();
        System.out.println("Enter book's ISBNid: ");
        String bISBNid = scanner.nextLine();

        BookProducts book = new BookProducts(bname, bprice, binsInventory, bauthorName, bpageCount, bgenre, bageQroup, bISBNid);
        book.setSeller(seller);
        ProductsManager.getInstance().addProduct(seller,book);
        System.out.println("add book successfully");
    }
}
