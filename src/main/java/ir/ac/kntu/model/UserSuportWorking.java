package ir.ac.kntu.model;

import java.util.*;
import java.util.concurrent.*;

public class UserSuportWorking {

    private static final UserSuportWorking Winstance = new UserSuportWorking();
    private List<ManageUserSupport> mgUSupports = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Map<Supporter, Set<KindOfReport>> types = new HashMap<>();
    private Map<Supporter, List<ManageUserSupport>> ownReq = new HashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);


    public static UserSuportWorking getWInstance() {
        return Winstance;
    }

    public void addReport(KindOfReport kindOfReport, Seller seller) {
        String text = "";
        if (kindOfReport.equals(KindOfReport.AUTHENTICATION)) {
            text = "register seller";
            ManageUserSupport mus = new ManageUserSupport(kindOfReport, text, seller);
            mgUSupports.add(mus);
        }
    }

    public void addReport(KindOfReport kindOfReport, RegularUser user) {
        System.out.println("Enter your text: ");
        String text = scanner.nextLine();
        ManageUserSupport mus = new ManageUserSupport(kindOfReport, text, user);
        mgUSupports.add(mus);
        scheduler.schedule(() -> {
            if (mus.getReportStatuse() == ReportStatuse.REGISTERED) {
                mus.setMessage("Still under review. Please be patient.");
            }
        }, 1, TimeUnit.MINUTES);
    }

    public Map<Supporter, Set<KindOfReport>> getTypes() {
        return types;
    }

    public void setTypes(Map<Supporter, Set<KindOfReport>> types) {
        this.types = types;
    }

    public void addTo(Supporter supporter, Set<KindOfReport> kindOfReport) {
        types.put(supporter, kindOfReport);
    }

    public List<ManageUserSupport> getManageUserSupports() {
        return mgUSupports;
    }

    public Map<Supporter, List<ManageUserSupport>> getOwnReq() {
        return ownReq;
    }

    public void showManageUserSupports(RegularUser user) {
        int index =0;
        for (ManageUserSupport str : mgUSupports) {
            if (str.getUser().equals(user)) {
                System.out.println((index + 1) + " " + str + "\n");
                index++;
            }
        }
    }

    public void showSupportOwnReports(Supporter supporter) {
        List<ManageUserSupport> requ = new ArrayList<>();
        if (types.get(supporter) == null) {
            int index1 = 0;
            for (ManageUserSupport str : mgUSupports) {
                System.out.println((index1 + 1) + " " + str + "\n");
                requ.add(str);
                index1++;
            }
        } else {
            int index2 = 0;
            for (ManageUserSupport str : mgUSupports) {
                if (!types.get(supporter).contains(str.getKindOfReport())) {
                    System.out.println((index2 + 1) + " " + str + "\n");
                    requ.add(str);
                    index2++;
                }
            }
        }
        ownReq.put(supporter, requ);
    }

//    public void setManageUserSupports(List<ManageUserSupport> manageUserSupports) {
//        this.manageUserSupports = manageUserSupports;
//    }
}
