package ir.ac.kntu.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ShowWallet {

    private static final ShowWallet showWal = new ShowWallet();
    private Scanner scanner = new Scanner(System.in);
    private boolean isOkk1 = true;

    public static ShowWallet getShowWal() {
        return showWal;
    }

    public void show(RegularUser user) {
        UsersWallet usersWallet = user.getUsersWallet();
        while (isOkk1) {
            System.out.println("----------WALLET----------\n1 show inventory\n2 charge inventory\n3 show transactions\n4 filter transactions by date\n5 quit\nselect your goal: ");
            int goal = scanner.nextInt();
            scanner.nextLine();
            switch (goal) {
                case 1:
                    System.out.println("your inventory is: "+usersWallet.getInventory());
                    break;
                case 2:
                    aboutCharge(usersWallet);
                    break;
                case 3:
                    usersWallet.showAllTransaction();
                    break;
                case 4:
                    aboutFilter(usersWallet);
                    break;
                case 5:
                    isOkk1 = false;
                    break;
                default:
                    System.out.println("invalid goal");
            }
        }
    }

    public void aboutCharge(UsersWallet usersWallet) {
        System.out.print("Enter amount to charge: ");
        long amountForCharge = scanner.nextLong();
        scanner.nextLine();
        if (amountForCharge <= 0) {
            System.out.println("invalid amount!!!");
            return;
        }
        usersWallet.charge(amountForCharge);
        System.out.println("charge successfully.");
        System.out.println("your new inventory is : " + usersWallet.getInventory() + " $");

    }

    public void aboutFilter(UsersWallet usersWallet) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            System.out.println("Enter Start date: ");
            String startDate = scanner.nextLine();
            LocalDateTime start = LocalDateTime.parse(startDate, formatter);
            System.out.println("Enter end date: ");
            String endDate = scanner.nextLine();
            LocalDateTime end = LocalDateTime.parse(endDate, formatter);
            usersWallet.showTransactionsBetween(start, end);
        } catch (Exception e) {
            System.out.println("invalid date format.");
        }
    }
}
