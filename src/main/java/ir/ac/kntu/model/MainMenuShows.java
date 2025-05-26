package ir.ac.kntu.model;

import java.util.Scanner;

public class MainMenuShows {

    private static final MainMenuShows mMsInstanse = new MainMenuShows();
    private Scanner scanner = new Scanner(System.in);

    public static MainMenuShows getmMsInstanse() {
        return mMsInstanse;
    }

    public void show(SupportersLogin supportersLogin, ManageRequests manageRequests) {
        System.out.print("Enter your username: ");
        String usName = scanner.nextLine();
        System.out.println();
        System.out.println("Enter your password: ");
        String pass = scanner.nextLine();
        Supporter supporter = supportersLogin.login(usName, pass);
        if (supporter != null) {
            System.out.println("Welcome " + supporter.getFirstName() + "! you are logged as a supporter.");
            new SupporterMenu(manageRequests).show();
        } else {
            System.out.println("invalid UserName or Password");
        }
    }
}
