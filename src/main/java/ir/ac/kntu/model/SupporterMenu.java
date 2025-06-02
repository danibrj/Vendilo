package ir.ac.kntu.model;

import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

public class SupporterMenu {
    private ManageRequests manageRequests;
    private Scanner scanner = new Scanner(System.in);

    public SupporterMenu(ManageRequests manageRequests) {
        this.manageRequests = manageRequests;
    }

    public void show() {
        boolean isGo = true;
        while (isGo) {
            System.out.println(cyan + "|----------MENU----------|\nselect your goal:\n" + red + "1" + green + ".Authentication\n" + red + "2" + green + ".Requests\n" + red + "3" + green + ".Orders\n" + red + "4" + green + ".quit\n" + cyan+ "choose your goal: " + reset);
            int goal = scanner.nextInt();
            scanner.nextLine();
            switch (goal) {
                case 1:
                    new SupporterMenu2(manageRequests).show();
                    break;
                case 2:
                    ShowSupporterReqMenu.getSSRInstance().show(UserSuportWorking.getWInstance());
                    break;
                case 3:
                    SupporterOrders.getSupOInstance().show();
                    break;
                case 4:
                    isGo = false;
                    break;
                default:
                    System.out.println(red+"invalid choices"+reset);
            }
        }
    }
}
