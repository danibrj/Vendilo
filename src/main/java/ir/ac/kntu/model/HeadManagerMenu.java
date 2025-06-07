package ir.ac.kntu.model;

import java.util.List;
import java.util.Scanner;

import static ir.ac.kntu.model.Color.*;

public class HeadManagerMenu {
    private static final HeadManagerMenu headInstance = new HeadManagerMenu();
    private Scanner scanner = new Scanner(System.in);

    public static HeadManagerMenu getHeadInstance() {
        return headInstance;
    }

    public void show() {
        System.out.println(cyan + "|----------Head Manager Menu----------|\n" + red + "3." + green + "user performance review\n" + blue + "choose one: \n" + reset);
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
//            case 1 ->
//            case 2 ->
            case 3 -> {
                List<RegularUser> users = RegularUserRepository.getRinstance().getAllUsers();
                for (int i = 0; i < users.size(); i++) {
                    System.out.println((i + 1) + " " + users.get(i));
                }
                System.out.println("select one: ");
                int num = scanner.nextInt();
                scanner.nextLine();
                if (num < 1 || num > users.size()) {
                    System.out.println(red + "invalid num" + reset);
                    return;
                }
                RegularUser user = users.get(num - 1);
                perfReviewMenu(user);
            }
            default -> System.out.println(red + "invalid choice!!!" + reset);

        }
    }

    public void perfReviewMenu(RegularUser user) {
        boolean isOk = true;
        while (isOk) {
            System.out.println(cyan + "welcome to " + user.getFirstName() + " " + user.getLastName() + "menu\n" + red + "1." + green + "put discount code\n" + red + "2." + green + "quit\n" + purple +"choose one: \n" + reset);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> putCodeShow(user);

                default -> System.out.println(red + "invalid choice!!!" + reset);
            }
        }
    }

    private void putCodeShow(RegularUser user) {
        System.out.println(cyan + "type of code: \n" + reset);
        KindsOfCode[] items = KindsOfCode.values();
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + " " + items[i]);
        }
        System.out.println("choose one: ");
        int choice2 = scanner.nextInt();
        scanner.nextLine();
        KindsOfCode kindsOfCode = items[choice2 - 1];
        System.out.println("name: ");
        String name = scanner.nextLine();
        System.out.println("code: ");
        String code = scanner.nextLine();
        System.out.println("discountValue: ");
        int discountValue = scanner.nextInt();
        scanner.nextLine();
        System.out.println("numbsOfTimesOfUse: ");
        int numbsOfTimesOfUse = scanner.nextInt();
        scanner.nextLine();
        DiscountCode discountCode = new DiscountCode(name, code, discountValue, numbsOfTimesOfUse, kindsOfCode);
        DiscountCodeManager.getDisManInstance().addCode(user, discountCode);
    }
}
