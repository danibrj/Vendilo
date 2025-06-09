package ir.ac.kntu.model;

import java.util.Scanner;

import static ir.ac.kntu.model.Color.*;

public class MainMenuShows {
    private static final MainMenuShows mMsInstanse = new MainMenuShows();
    private Scanner scanner = new Scanner(System.in);

    public static MainMenuShows getmMsInstanse() {
        return mMsInstanse;
    }

    public void show(SupportersLogin supportersLogin /*, ManageRequests */) {
        System.out.println(cyan + "|----------Supporter Login----------|\n" + reset);
        System.out.println("Enter your username: ");
        String usName = scanner.nextLine();
        System.out.println("Enter your password: ");
        String pass = scanner.nextLine();
        Supporter supporter = supportersLogin.login(usName, pass);
        if (supporter == null) {
            System.out.println(red + "not found!!!" + reset);
            return;
        }
        if (supporter.getSupIsBlock().equals(IsBlock.YES)) {
            System.out.println(red + "you blocked by manager" + reset);
            return;
        }
        System.out.println(blue + "Welcome " + reset + supporter.getFirstName() + green + "! you are logged as a supporter." + reset);
        new SupporterMenu(/*manageRequests*/).show(supportersLogin,supporter);

    }
}
