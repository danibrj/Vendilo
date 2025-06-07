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
            System.out.println(cyan + "|----------Discount Code Menu----------|\n" + red + "1." + green + "show discount codes\n" + red + "2." + green + "show code's details\n" + red + "3." + green + "quit" + purple + "choose one: \n" + reset);
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1 -> codeManager.showCodesGenerally(user);
                case 2 -> showDetails(user, codeManager);
                case 3 -> isOk = false;
                default -> System.out.println(red + "invalid select!!!" + reset);
            }
        }
    }

    public void showDetails(RegularUser user, DiscountCodeManager codeManager) {
        Map<RegularUser, List<DiscountCode>> copyUserDisCode = codeManager.getUserDisCode();
        for (RegularUser reUser : copyUserDisCode.keySet()) {
            if (reUser.equals(user)) {
                for (int i = 0; i < copyUserDisCode.get(user).size(); i++) {
                    System.out.println((i + 1) + " " + copyUserDisCode.get(user).get(i).getName());
                }
            }
        }
        System.out.println(blue + "choose one: " + reset);
        int num = scanner.nextInt();
        scanner.nextLine();
        if (num < 1 || num > copyUserDisCode.get(user).size()) {
            System.out.println(red + "invalid num" + reset);
            return;
        }
        DiscountCode disCode = copyUserDisCode.get(user).get(num - 1);
        codeManager.showCodesDetails(disCode);
    }
}
