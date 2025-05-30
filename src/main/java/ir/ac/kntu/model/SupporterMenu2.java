package ir.ac.kntu.model;

import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

public class SupporterMenu2 {

    private ManageRequests manageRequests;
    private Scanner scanner = new Scanner(System.in);

    public SupporterMenu2(ManageRequests manageRequests) {
        this.manageRequests = manageRequests;
    }

    public void show() {
        boolean isCon = true;
        while (isCon) {
            System.out.println(red + "1" + green + ".show requests\n" + red + "2" + green + ".handle requests\n" + red + "3" + green + ".quit\n" + cyan+ "choose one: " + reset);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    manageRequests.showRequests();
                    break;
                case 2:
                    handling(manageRequests);
                    break;
                case 3:
                    isCon = false;
                    break;
                default:
                    System.out.println(red+"invalid select!!!"+reset);
            }
        }
    }

    public void handling(ManageRequests manageRequests) {
        manageRequests.showRequests();
        System.out.println("which item do you want to handle:");
        int item = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < manageRequests.getRequests().size(); i++) {
            if (i + 1 == item && manageRequests.getRequests().get(i).getStatus() == RegisterStstus.PENDING) {
                System.out.println(blue+"Do you want to approved this? (yes/No)"+reset);
                String yesOrNo = scanner.nextLine();
                if ("yes".equals(yesOrNo)) {
                    manageRequests.getRequests().get(i).setStatus(RegisterStstus.APPROVED);
                    manageRequests.getRequests().get(i).getSeller().setApproved(true);
                    manageRequests.setIsOk(true);
                } else {
                    System.out.println("whats your reason for reject this?");
                    String reasonForReject = scanner.nextLine();
                    manageRequests.getRequests().get(i).setStatus(RegisterStstus.REJECTED);
                    manageRequests.getRequests().get(i).setResponseMessage(reasonForReject);
                    manageRequests.getRequests().get(i).getSeller().setRejected(true);
                    manageRequests.getRequests().get(i).getSeller().setReason(reasonForReject);
                    manageRequests.setIsOk(false);
                }
            }
        }
    }
}
