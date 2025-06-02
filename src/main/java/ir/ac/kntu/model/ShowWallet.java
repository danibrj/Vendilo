package ir.ac.kntu.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

public class ShowWallet {
    private static final ShowWallet showWal = new ShowWallet();
    private Scanner scanner = new Scanner(System.in);

    public static ShowWallet getShowWal() {
        return showWal;
    }

    public void show(RegularUser user) {
        UsersWallet usersWallet = user.getUsersWallet();
        boolean isOkk1 = true;
        while (isOkk1) {
            System.out.println(cyan + "|----------WALLET----------|\n" + red + "1" + green + " show inventory\n" + red + "2" + green + " charge inventory\n" + red + "3" + green + " show transactions\n" + red + "4" + green + " filter transactions by date\n" + red + "5" + green + " quit\n" + "select your goal: " + reset);
            int goal = scanner.nextInt();
            scanner.nextLine();
            switch (goal) {
                case 1 -> System.out.println(blue +"your inventory is: "+ reset + usersWallet.getInventory()+ " $\n");
                case 2 -> aboutCharge(usersWallet);
                case 3 -> usersWallet.showAllTransaction();
                case 4 -> aboutFilter(usersWallet);
                case 5 -> {
                    isOkk1 = false;
                }
                default -> System.out.println(red +"invalid goal" + reset);
            }
        }
    }

    public void aboutCharge(UsersWallet usersWallet) {
        System.out.print("Enter amount to charge: ");
        long amountForCharge = scanner.nextLong();
        scanner.nextLine();
        if (amountForCharge <= 0) {
            System.out.println(red +"invalid amount!!!"+ reset);
            return;
        }
        usersWallet.charge(amountForCharge);
        System.out.println(green+"charge successfully."+ reset);
        System.out.println(blue + "your new inventory is : "+ reset + usersWallet.getInventory()+ " $");

    }

    public void aboutFilter(UsersWallet usersWallet) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime start = null;
            LocalDateTime end = null;
            while(start == null || end == null) {
                System.out.println("Enter Start date: ");
                String startDate = scanner.nextLine();
                System.out.println("Enter end date: ");
                String endDate = scanner.nextLine();
                try {
                    start = LocalDateTime.parse(startDate, formatter);
                    end = LocalDateTime.parse(endDate, formatter);
                    usersWallet.showTransactionsBetween(start, end);
                } catch (DateTimeParseException e){
                    System.out.println(red +"invalid date format"+ reset);
                }
            }
        } catch (Exception e) {
            System.out.println(red+"invalid date format."+reset);
        }
    }
}
