package ir.ac.kntu.model;

import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

public class SupporterMenu {
    private Scanner scanner = new Scanner(System.in);

    public SupporterMenu() {
    }

    public void show(SupportersLogin supportersLogin,Supporter supporter) {
        boolean isGo = true;
        while (isGo) {
            System.out.println(cyan + "|----------MENU----------|\nselect your goal:\n"+ red + "1" + green + ".Requests\n" + red + "2" + green + ".Orders\n" + red + "3" + green + ".quit\n" + cyan+ "choose your goal: " + reset);
            int goal = scanner.nextInt();
            scanner.nextLine();
            switch (goal) {
                case 1:
                    ShowSupporterReqMenu.getSSRInstance().show(UserSuportWorking.getWInstance(),supportersLogin,supporter);
                    break;
                case 2:
                    SupporterOrders.getSupOInstance().show();
                    break;
                case 3:
                    isGo = false;
                    break;
                default:
                    System.out.println(red+"invalid choices"+reset);
            }
        }
    }
}
