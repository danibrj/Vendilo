package ir.ac.kntu.model;

import java.util.List;
import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

public class ShowSupporterReqMenu2 {

    private static final ShowSupporterReqMenu2 SSR2Instance = new ShowSupporterReqMenu2();
    private Scanner scanner = new Scanner(System.in);

    public static ShowSupporterReqMenu2 getSSR2Instance() {
        return SSR2Instance;
    }

    public void show(UserSuportWorking userSuportWorking,Supporter supporter) {
        List<ManageUserSupport> mgU1 = userSuportWorking.getOwnReq().get(supporter);
        userSuportWorking.showSupportOwnReports(supporter);
        System.out.println("which report do you want to handle: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        if (num < 1 || num > mgU1.size()) {
            System.out.println(red+"invalid num!!!"+reset);
            return;
        }
        show2(mgU1,scanner,num);
    }

    public void show2(List<ManageUserSupport> mgU1,Scanner scanner,int num){
        if (mgU1 != null) {
            for (int i = 0; i < mgU1.size(); i++) {
                if (i + 1 == num && mgU1.get(i).getReportStatuse().equals(ReportStatuse.REGISTERED)) {
                    if(mgU1.get(i).getKindOfReport().equals(KindOfReport.AUTHENTICATION)){
                        System.out.println(blue+"Do you want to Ok this? (yes/No)"+reset);
                        String yesOrNo = scanner.nextLine();
                        if ("yes".equals(yesOrNo)) {
                            mgU1.get(i).setReportStatuse(ReportStatuse.OK);
                            mgU1.get(i).getSeller2().setApproved(true);
                            mgU1.get(i).getSeller2().setRejected(false);
                            mgU1.get(i).setMessage("you can login");
                        } else {
                            System.out.println("whats your reason for reject this?");
                            String reasonForReject = scanner.nextLine();
                            mgU1.get(i).setReportStatuse(ReportStatuse.CLOSED);
                            mgU1.get(i).getSeller2().setApproved(false);
                            mgU1.get(i).getSeller2().setRejected(true);
                            mgU1.get(i).setMessage(reasonForReject);
                            mgU1.get(i).getSeller2().setReason(reasonForReject);
                        }
                    }else {
                        System.out.println(mgU1.get(i));
                        mgU1.get(i).setReportStatuse(ReportStatuse.INPROGRESS);
                        System.out.println("your message: ");
                        String message = scanner.nextLine();
                        mgU1.get(i).setMessage(message);
                        System.out.println("do you want to close this report?");
                        String yOrN = scanner.nextLine();
                        if ("yes".equalsIgnoreCase(yOrN)) {
                            mgU1.get(i).setReportStatuse(ReportStatuse.CLOSED);
                            System.out.println("your new message: ");
                            String closeMessage = scanner.nextLine();
                            mgU1.get(i).setMessage(closeMessage);
                        }
                    }
                }
            }
        } else {
            System.out.println(red+"not found!!!"+reset);
        }
    }
}
