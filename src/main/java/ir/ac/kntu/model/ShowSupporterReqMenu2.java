package ir.ac.kntu.model;

import java.util.List;
import java.util.Scanner;

public class ShowSupporterReqMenu2 {

    private static final ShowSupporterReqMenu2 SSR2Instance = new ShowSupporterReqMenu2();
    private Scanner scanner = new Scanner(System.in);

    public static ShowSupporterReqMenu2 getSSR2Instance() {
        return SSR2Instance;
    }

    public void show(UserSuportWorking userSuportWorking) {
        List<ManageUserSupport> mgU1 = userSuportWorking.getManageUserSupports();
        userSuportWorking.showManageUserSupports();
        System.out.println("which report do you want to handle: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        if (num < 1 || num > mgU1.size()) {
            System.out.println("invalid num!!!");
            return;
        }
        show2(mgU1,scanner,num);
    }

    public void show2(List<ManageUserSupport> mgU1,Scanner scanner,int num){
        if (mgU1 != null) {
            for (int i = 0; i < mgU1.size(); i++) {
                if (i + 1 == num && mgU1.get(i).getReportStatuse().equals(ReportStatuse.REGISTERED)) {
                    System.out.println(mgU1.get(i));
                    mgU1.get(i).setReportStatuse(ReportStatuse.INPROGRESS);
                    System.out.println("your message: ");
                    String message = scanner.nextLine();
                    mgU1.get(i).setMessage(message);
                    System.out.println("do you want to close this report?");
                    String yOrN = scanner.nextLine();
                    if ("yes".equalsIgnoreCase(yOrN)) {
                        mgU1.get(i).setReportStatuse(ReportStatuse.CLOSED);
                        System.out.println("your message: ");
                        String closeMessage = scanner.nextLine();
                        mgU1.get(i).setMessage(closeMessage);
                    }
                }
            }
        } else {
            System.out.println("not found!!!");
        }
    }
}
