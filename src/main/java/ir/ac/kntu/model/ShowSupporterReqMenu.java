package ir.ac.kntu.model;

import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

public class ShowSupporterReqMenu {

    private static final ShowSupporterReqMenu sSRInstance = new ShowSupporterReqMenu();
    private Scanner scanner = new Scanner(System.in);

    public static ShowSupporterReqMenu getSSRInstance() {
        return sSRInstance;
    }


    public void show(UserSuportWorking userSuportWorking) {
        boolean isOk = true;
        while (isOk) {
            System.out.println(red + "1" + green + ".show reports\n" + red + "2" + green + ".handling reports\n" + red + "3" + green + ".quit\n" + cyan+ "choose your goal: " + reset);
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
                    System.out.println(red+"invalid goal"+reset);
            }
        }
    }
}
