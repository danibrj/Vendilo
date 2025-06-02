package ir.ac.kntu.model;

import ir.ac.kntu.report.SellerReportGenerator;
import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

public class MainSellerMenu {
    private static final MainSellerMenu msmInstance = new MainSellerMenu();
    private Scanner scanner = new Scanner(System.in);

    public static MainSellerMenu getMsm() {
        return msmInstance;
    }

    public void show(Seller seller) {
        boolean bool = true;
        while (bool) {
            System.out.println(cyan + "|----------Main Seller Menu----------|\n" + red + "1" + green + ".products\n" + red + "2" + green + ".wallet\n" + red + "3" + green + ".orders\n" + red + "4" + green + ".reports\n" + red + "5" + green + ".quit\n" + cyan + "choose one: " + reset);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> ProductMenu.getPm().show(seller);
                case 2 -> ShowSellerWallet.getSSWInstance().show(seller);
                case 3 -> SellerOrderMenu.getSOMInstance().show(seller);
                case 4 -> {
                    SellerReportGenerator reportGenerator = new SellerReportGenerator();
                    reportGenerator.generateReport();
                    System.out.println(green + "build successfully."+ reset);
                }
                case 5 -> {
                    bool = false;
                }
                default -> System.out.println(red + "invalid choice" + reset);
            }
        }
    }
}
