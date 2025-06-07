package ir.ac.kntu.model;

import java.util.Scanner;

import static ir.ac.kntu.model.Color.*;

public class HeadManagerLoginMenu {
    private static final HeadManagerLoginMenu hMlmInstanse = new HeadManagerLoginMenu();
    private Scanner scanner = new Scanner(System.in);

    public static HeadManagerLoginMenu gethMlmInstanse() {
        return hMlmInstanse;
    }

    public void show(HeadManagerLogin headManagerLogin, SupportersLogin supportersLogin) {
        boolean isContinue = true;
        while (isContinue) {
            System.out.println(cyan + "|----------First Manager Menu----------|\n" + red + "1." + green + "Add Manager\n" + red + "2." + green + "Add Supporter\n" + red + "3." + green + "Login Manager to Main Menu\n" + red + "4." + green + "quit\n" + purple + "choose one: \n" + reset);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> addManagerShow(headManagerLogin);
                case 2 -> addSupporterShow(supportersLogin);
                case 3 -> HeadManagerMenu.getHeadInstance().show();
                case 4 -> isContinue = false;
                default -> System.out.println(red + "invalid choice!!!" + reset);
            }
        }
    }

    private void addSupporterShow(SupportersLogin supportersLogin) {
        System.out.println(cyan + "|----------Supporter Adding----------|\n" + reset);
        System.out.println("name: ");
        String supName = scanner.nextLine();
        System.out.println("username: ");
        String supUsName = scanner.nextLine();
        System.out.println("password: ");
        String supPass = scanner.nextLine();
        Supporter supporter = new Supporter(supName, supUsName, supPass);
        supportersLogin.addSupper(supporter);
    }

    private void addManagerShow(HeadManagerLogin headManagerLogin) {
        System.out.println(cyan + "|----------Manager Adding----------|\n" + reset);
        System.out.println("Enter your username: ");
        String manUsName = scanner.nextLine();
        System.out.println("Enter your password: ");
        String manPass = scanner.nextLine();
        HeadManager headManager = new HeadManager(manUsName, manPass);
        headManagerLogin.addManager(headManager);
    }

}
