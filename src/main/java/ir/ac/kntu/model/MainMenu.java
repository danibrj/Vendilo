package ir.ac.kntu.model;

import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {
        try {
            @SuppressWarnings("PMD.CloseResource")
            Scanner scanner = new Scanner(System.in);
            ManageRequests manageRequests = ManageRequests.getMRInstance();
            SellerRepository sellerRepository = SellerRepository.getSinstance();
            SupportersLogin supportersLogin = new SupportersLogin();
            while (true) {
                System.out.println("----------Main Menu----------\nselect your Role: \n1.regular user\n2.seller\n3.supporter\n4.quit");
                int selected = scanner.nextInt();
                scanner.nextLine();
                switch (selected) {
                    case 1 -> new FirstRegularUserMenu().show();
                    case 2 -> new FirstSellerMenu(sellerRepository, manageRequests).show();
                    case 3 -> MainMenuShows.getmMsInstanse().show(supportersLogin, manageRequests);
                    case 4 -> {
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("invalid selected");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

