package ir.ac.kntu.model;

import java.util.Scanner;

import static ir.ac.kntu.model.Color.*;

public class MainMenu {
    public static void main(String[] args) {
        try {
            @SuppressWarnings("PMD.CloseResource")
            Scanner scanner = new Scanner(System.in);
            ManageRequests manageRequests = ManageRequests.getMRInstance();
            SellerRepository sellerRepository = SellerRepository.getSinstance();
            SupportersLogin supportersLogin = new SupportersLogin();
            HeadManagerLogin headManagerLogin = new HeadManagerLogin();
            while (true) {
                System.out.println(cyan + "|-------------Main Menu-------------|\n" + "select your Role: \n" + red + "1." + green + "regular user\n" + red + "2." + green + "seller\n" + red + "3." + green + "supporter\n" + red + "4." + green + "managers\n" + red + "5." + green + "quit\n" + purple + ":::::::::>>>>" + reset);
                int selected = scanner.nextInt();
                scanner.nextLine();
                switch (selected) {
                    case 1 -> new FirstRegularUserMenu().show();
                    case 2 -> new FirstSellerMenu(sellerRepository, manageRequests).show();
                    case 3 -> MainMenuShows.getmMsInstanse().show(supportersLogin, manageRequests);
                    case 4-> LoginManager.getLmInstanse().show(headManagerLogin,supportersLogin);
                    case 5 -> {
                        scanner.close();
                        return;
                    }
                    default ->
                            System.out.println(red + "invalid selected" + blue + "write the correct form: \n" + reset);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

