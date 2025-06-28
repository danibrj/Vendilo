package ir.ac.kntu.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import static ir.ac.kntu.model.Color.*;
import static ir.ac.kntu.model.Color.reset;

public class ShowSellersTrans {
    private static final ShowSellersTrans sstInstance = new ShowSellersTrans();
    private Scanner scanner = new Scanner(System.in);
    public static ShowSellersTrans getSstInstance(){
        return sstInstance;
    }

    public void show(SellerWallet sellerWallet){
        boolean isGo = true;
        while(isGo) {
            System.out.println(cyan + "|----------Transaction Menu----------|\nchoose one:\n" + red + "1" + green + ".show transaction\n" + red + "2" + green + ".show by filter\n" + red + "3" + green + ".quit" + reset);
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1 -> sellerWallet.showAllTransaction();
                case 2 -> filterTrans(sellerWallet);
                case 3 -> isGo = false;
                default -> System.out.println(red + "invalid select!!!"+reset);
            }
        }
    }

    public void filterTrans(SellerWallet sellerWallet){
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
                    sellerWallet.showTransactionsBetween(start, end);
                } catch (DateTimeParseException e){
                    System.out.println(red +"invalid date format"+ reset);
                }
            }
        } catch (Exception e) {
            System.out.println(red+"invalid date format."+reset);
        }
    }

}
