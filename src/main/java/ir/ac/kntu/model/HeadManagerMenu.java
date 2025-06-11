package ir.ac.kntu.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import static ir.ac.kntu.model.Color.*;


public class HeadManagerMenu {
    private static final HeadManagerMenu headInstance = new HeadManagerMenu();
    private Scanner scanner = new Scanner(System.in);

    public static HeadManagerMenu getHeadInstance() {
        return headInstance;
    }

    public void show(HeadManagerLogin headManagerLogin, SupportersLogin supportersLogin, HeadManager headManager) {
        List<RegularUser> users = RegularUserRepository.getRinstance().getAllUsers();
        boolean isOk1 = true;
        while (isOk1) {
            System.out.println(cyan + "|----------Head Manager Menu----------|\n" + red + "1." + green + "User Management\n" + red + "2." + green + "Seller performance review\n" + red + "3." + green + "user performance review\n" + red + "4." + green + "Create Public Discount Code\n" + red + "5." + green + "Create Public message\n" + red + "6." + green + "quit\n" + blue + "choose one: \n" + reset);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> UserManagement.getUmInstance().show(headManagerLogin, supportersLogin, headManager);
                case 2 -> {
                    List<Seller> sellers = SellerRepository.getSinstance().getAllSellers();
                    boolean iscon = true;
                    while (iscon) {
                        System.out.println(red + "1." + green + "see seller performance usually\n" + red + "2." + green + "see seller performance by personality code\n" + red + "3." + green + "quit\n" + "choose one: \n" + reset);
                        int select = scanner.nextInt();
                        scanner.nextLine();
                        switch (select) {
                            case 1 -> {
                                for (int i = 0; i < sellers.size(); i++) {
                                    System.out.println((i + 1) + " " + sellers.get(i));
                                }
                                System.out.println("select one: ");
                                int num1 = scanner.nextInt();
                                scanner.nextLine();
                                if (num1 < 1 || num1 > sellers.size()) {
                                    System.out.println(red + "invalid num" + reset);
                                    return;
                                }
                                LocalDateTime today = LocalDateTime.now();
                                LocalDateTime minetsAgo = today.minusMinutes(5);
                                Seller seller = sellers.get(num1 - 1);
                                List<OrderUser> orders = OrderManager.getOMInstance().getOrderForSeller(seller);
                                double sum = 0;
                                for (OrderUser order : orders) {
                                    LocalDateTime date = order.getOrderDate();
                                    if (date.isAfter(minetsAgo) && date.isBefore(today) || date.isEqual(today)) {
                                        System.out.println(order);
                                        sum += (order.getTotalPrice() * 0.9);
                                    }
                                }
                                System.out.println(green + "sum of seller's sales are : " + reset + sum);
                            }
                            case 2 -> {
                                for (int i = 0; i < sellers.size(); i++) {
                                    System.out.println((i + 1) + " " + sellers.get(i).getFirstName() + " " + sellers.get(i).getLastName() + "Agency Code: " + sellers.get(i).getAgencyCode());
                                }
                                System.out.println(cyan + "Enter the agency code to found seller: " + reset);
                                String agenCode = scanner.nextLine();
                                for (Seller seller : sellers) {
                                    if (seller.getAgencyCode().equalsIgnoreCase(agenCode)) {
                                        System.out.println(seller.getFirstName() + " | " + seller.getLastName() + " | " + seller.getPhoneNumber() + " | total sales : " + seller.getSellerWallet().getTotal());
                                        System.out.println(cyan + "do you want to give reward to seller?" + reset);
                                        String yesOrNo = scanner.nextLine();
                                        if ("yes".equalsIgnoreCase(yesOrNo)) {
                                            System.out.println(cyan + "how much money do you want to give it?" + reset);
                                            double reward = scanner.nextDouble();
                                            scanner.nextLine();
                                            seller.getSellerWallet().increaseInventory(reward);
                                        }
                                    }
                                }
                            }
                            case 3 -> iscon = false;
                            default -> System.out.println(red + "invalid select!!!" + reset);
                        }
                    }
                }
                case 3 -> {
                    for (int i = 0; i < users.size(); i++) {
                        System.out.println((i + 1) + " " + users.get(i));
                    }
                    System.out.println("select one: ");
                    int num2 = scanner.nextInt();
                    scanner.nextLine();
                    if (num2 < 1 || num2 > users.size()) {
                        System.out.println(red + "invalid num" + reset);
                        return;
                    }
                    RegularUser user = users.get(num2 - 1);
                    perfReviewMenu(user);
                }
                case 4 -> {
                    System.out.println(cyan + "----------Public Code----------\n" + green + "create: \n" + reset);
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
                    float discountValue = scanner.nextFloat();
                    scanner.nextLine();
                    int numbsOfTimesOfUse = 1;
                    System.out.println("numbsOfTimesOfUse: " + numbsOfTimesOfUse);
                    for (RegularUser user : users) {
                        DiscountCode discountCode = new DiscountCode(name, code, discountValue, numbsOfTimesOfUse, kindsOfCode);
                        DiscountCodeManager.getDisManInstance().addCode(user, discountCode);
                    }
                }
                case 5 -> {
                    System.out.println(cyan + "----------Public Message----------\n" + green + "enter your message: \n" + reset);
                    String message = scanner.nextLine();
                    LocalDateTime nowDate = LocalDateTime.now();
                    Subject subject = Subject.PUBLICMESSAGE;
                    NotifValueManage.getNotValManInstance().addPubMessNotif(nowDate, message);
                    for (RegularUser user : users) {
                        Notification notification = new Notification(user, nowDate, subject, NotifValueManage.getNotValManInstance().getNotifValue1(nowDate));
                        NotificationManager.getNotManInstance().addNotif(notification);
                    }
                }
                case 6 -> isOk1 = false;
                default -> System.out.println(red + "invalid choice!!!" + reset);
            }
        }
    }

    public void perfReviewMenu(RegularUser user) {
        boolean isOk2 = true;
        while (isOk2) {
            System.out.println(cyan + "welcome to " + reset + user.getFirstName() + " " + user.getLastName() + cyan + " menu\n" + red + "1." + green + "put discount code\n" + red + "2." + green + "user performance\n" + red + "3." + green + "register to Vendilo+\n" + red + "4." + green + "quit\n" + purple + "choose one: \n" + reset);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> putCodeShow(user);
                case 2 -> {
                    LocalDateTime today2 = LocalDateTime.now();
                    LocalDateTime minetsAgo2 = today2.minusMinutes(5);
                    List<Userstransaction> userTrans = user.getUsersWallet().getUserstransactions();
                    double sum = 0;
                    for (Userstransaction trans : userTrans) {
                        LocalDateTime date = trans.getTransactionDate();
                        if ("Shopping".equals(trans.getType()) && (date.isAfter(minetsAgo2) && date.isBefore(today2) || date.isEqual(today2))) {
                            sum += trans.getAmount();
                        }
                    }
                    System.out.println(green + "sum of user's shopping are : " + reset + sum);
                }
                case 3 -> {
                    System.out.println("|----------register to Vendilo+----------|");
                    LocalDateTime today1 = null;
                    LocalDateTime someLater = null;
                    System.out.println("how much (1.day/2.month/3.year/4.quit) do you want to use for that user?");
                    int num = scanner.nextInt();
                    scanner.nextLine();
                    switch (num) {
                        case 1 -> {
                            System.out.println("how much? ");
                            int num2 = scanner.nextInt();
                            today1 = LocalDateTime.now();
                            someLater = today1.plusDays(num2);
                        }
                        case 2 -> {
                            System.out.println("how much? ");
                            int num3 = scanner.nextInt();
                            today1 = LocalDateTime.now();
                            someLater = today1.plusMonths(num3);
                        }
                        case 3 -> {
                            System.out.println("how much? ");
                            int num4 = scanner.nextInt();
                            today1 = LocalDateTime.now();
                            someLater = today1.plusYears(num4);
                        }
                        case 4 -> {
                            System.out.println();
                        }
                        default -> System.out.println(red + "invalid num!!!" + reset);
                    }
                    if (today1 != null) {
                        VendiloPlus newVendiloPlus1 = new VendiloPlus(user, today1, someLater);
                        VendiloPlusManager.getVpmInstance().addToVendiloPlus(newVendiloPlus1);
                    }
                }
                case 4 -> isOk2 = false;
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
        float discountValue = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("numbsOfTimesOfUse: ");
        int numbsOfTimesOfUse = scanner.nextInt();
        scanner.nextLine();
        DiscountCode discountCode = new DiscountCode(name, code, discountValue, numbsOfTimesOfUse, kindsOfCode);
        DiscountCodeManager.getDisManInstance().addCode(user, discountCode);
        LocalDateTime createCodeDate = LocalDateTime.now();
        Subject subject = Subject.DISCOUNTCODE;
        NotifValueManage.getNotValManInstance().addCodeNotif(user, discountCode);
        Notification notification = new Notification(user, createCodeDate, subject, NotifValueManage.getNotValManInstance().getNotifValue2(user));
        NotificationManager.getNotManInstance().addNotif(notification);
    }
}
