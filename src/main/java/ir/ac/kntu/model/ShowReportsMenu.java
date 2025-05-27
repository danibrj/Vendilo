package ir.ac.kntu.model;

import java.util.Scanner;

public class ShowReportsMenu {
    private static final ShowReportsMenu SRMInstance = new ShowReportsMenu();
    private Scanner scanner = new Scanner(System.in);

    public static ShowReportsMenu getSRMInstance() {
        return SRMInstance;
    }

    public void show(RegularUser user) {
        boolean iscont = true;
        while (iscont) {
            System.out.println("----------REPORTS----------");
            System.out.println("1.add report");
            System.out.println("2.show report");
            System.out.println("3.quit");
            System.out.println("select: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    ShowReportsMenu2.getSRM2Instance().show(user);
                    break;
                case 2:
                    user.getUserSuportWorking().showManageUserSupports();
                    break;
                case 3:
                    iscont = false;
                    break;
                default:
                    System.out.println("invalid choices");
            }
        }
    }
}
