package ir.ac.kntu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserSuportWorking {

    private static final UserSuportWorking Winstance = new UserSuportWorking();
    private List<ManageUserSupport> mgUSupports = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static UserSuportWorking getWInstance() {
        return Winstance;
    }

    public void addReport(KindOfReport kindOfReport) {
        System.out.println("Enter your text: ");
        String text = scanner.nextLine();
        ManageUserSupport mus = new ManageUserSupport(kindOfReport, text);
        mgUSupports.add(mus);
    }

    public List<ManageUserSupport> getManageUserSupports() {
        return mgUSupports;
    }

    public void showManageUserSupports() {
        for (ManageUserSupport str : mgUSupports) {
            System.out.println((mgUSupports.indexOf(str) + 1) + " " + str + "\n");
        }
    }

//    public void setManageUserSupports(List<ManageUserSupport> manageUserSupports) {
//        this.manageUserSupports = manageUserSupports;
//    }
}
