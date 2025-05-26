package ir.ac.kntu.model;

import java.util.Scanner;

public class SupporterMenu {
    private ManageRequests manageRequests;
    private Scanner scanner = new Scanner(System.in);

    public SupporterMenu(ManageRequests manageRequests) {
        this.manageRequests = manageRequests;
    }

    public void show() {
        boolean isGo = true;
        while (isGo) {
            System.out.println("----------MENU----------");
            System.out.println("select your goal: \n1.Authentication\n2.Requests\n3.Orders\n4.quit\nchoose your goal: ");
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
                    System.out.println("invalid choices");
            }
        }
    }
}
