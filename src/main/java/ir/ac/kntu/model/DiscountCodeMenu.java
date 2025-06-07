package ir.ac.kntu.model;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static ir.ac.kntu.model.Color.*;

public class DiscountCodeMenu {
    private static final DiscountCodeMenu discInstance = new DiscountCodeMenu();
    private Scanner scanner = new Scanner(System.in);

    public static DiscountCodeMenu getDiscInstance() {
        return discInstance;
    }

    public void show(RegularUser user) {
        DiscountCodeManager codeManager = DiscountCodeManager.getDisManInstance();
        boolean isOk = true;
        while (isOk) {
            System.out.println(cyan + "|----------Discount Code Menu----------|\n" + red + "1." + green + "show discount codes\n" + red + "2." + green + "show code's details\n" + red + "3." + green + "quit\n" + purple + "choose one: \n" + reset);
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1 -> codeManager.showCodesGenerally(user);
                case 2 -> ShowCodeDetails.getScdInstance().showDetails(user,codeManager);
                case 3 -> isOk = false;
                default -> System.out.println(red + "invalid select!!!" + reset);
            }
        }
    }


}
