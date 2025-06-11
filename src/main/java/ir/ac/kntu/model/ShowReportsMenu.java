package ir.ac.kntu.model;

import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

public class ShowReportsMenu {
    private static final ShowReportsMenu SRMInstance = new ShowReportsMenu();
    private Scanner scanner = new Scanner(System.in);

    public static ShowReportsMenu getSRMInstance() {
        return SRMInstance;
    }

    public void show(RegularUser user) {
        boolean iscont = true;
        while (iscont) {
            System.out.println(cyan + "|----------REPORTS----------|\n" + red + "1" + green + ".add report\n" + red + "2" + green + ".show report\n" + red + "3" + green + ".quit\n" + cyan+ "select: " + reset);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    ShowReportsMenu2.getSRM2Instance().show(user);
                    break;
                case 2:
                    user.getUserSuportWorking().showManageUserSupports(user);
                    break;
                case 3:
                    iscont = false;
                    break;
                default:
                    System.out.println(red+"invalid choices"+reset);
            }
        }
    }
}
