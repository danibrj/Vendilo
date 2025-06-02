package ir.ac.kntu.model;

import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

public class MainMenuShows {
    private static final MainMenuShows mMsInstanse = new MainMenuShows();
    private Scanner scanner = new Scanner(System.in);

    public static MainMenuShows getmMsInstanse() {
        return mMsInstanse;
    }

    public void show(SupportersLogin supportersLogin, ManageRequests manageRequests) {
        System.out.println(cyan + "|----------Login----------|\n" + reset);
        System.out.print("Enter your username: ");
        String usName = scanner.nextLine();
        System.out.println();
        System.out.println("Enter your password: ");
        String pass = scanner.nextLine();
        Supporter supporter = supportersLogin.login(usName, pass);
        if (supporter != null) {
            System.out.println(blue +"Welcome " + reset + supporter.getFirstName() + green +"! you are logged as a supporter." + reset);
            new SupporterMenu(manageRequests).show();
        } else {
            System.out.println(red +"invalid UserName or Password"+ reset);
        }
    }
}
