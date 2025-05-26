package ir.ac.kntu.model;

import java.util.Scanner;

public class ShowSupporterReqMenu {

    private static final ShowSupporterReqMenu sSRInstance = new ShowSupporterReqMenu();
    private Scanner scanner = new Scanner(System.in);

    public static ShowSupporterReqMenu getSSRInstance() {
        return sSRInstance;
    }


    public void show(UserSuportWorking userSuportWorking) {
        boolean isOk = true;
        while (isOk) {
            System.out.println("1.show reports");
            System.out.println("2.handling reports");
            System.out.println("3.quit");
            System.out.println("choose your goal: ");
            int goal = scanner.nextInt();
            scanner.nextLine();
            switch (goal) {
                case 1:
                    userSuportWorking.showManageUserSupports();
                    break;
                case 2:
                    ShowSupporterReqMenu2.getSSR2Instance().show(userSuportWorking);
                    break;
                case 3:
                    isOk = false;
                    break;
                default:
                    System.out.println("invalid goal");
            }
        }
    }
}
