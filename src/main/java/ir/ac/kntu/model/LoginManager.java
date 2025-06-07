package ir.ac.kntu.model;

import java.util.Scanner;

import static ir.ac.kntu.model.Color.*;
import static ir.ac.kntu.model.Color.reset;

public class LoginManager {
    private static final LoginManager lmInstanse = new LoginManager();
    private Scanner scanner = new Scanner(System.in);

    public static LoginManager getLmInstanse() {
        return lmInstanse;
    }

    public void show(HeadManagerLogin headManagerLogin, SupportersLogin supportersLogin){
        System.out.println(cyan + "|----------Manager Login----------|\n" + reset);
        System.out.println("Enter your username: ");
        String usName = scanner.nextLine();
        System.out.println("Enter your password: ");
        String pass = scanner.nextLine();
        HeadManager headManager = headManagerLogin.login(usName, pass);
        if (headManager != null) {
            System.out.println(blue + "Welcome " + reset + headManager.getUsernameHm() + green + "! you are logged to First Menu as a manager." + reset);
            HeadManagerLoginMenu.gethMlmInstanse().show(headManagerLogin,supportersLogin);
        } else {
            System.out.println(red + "invalid UserName or Password" + reset);
        }
    }
}
