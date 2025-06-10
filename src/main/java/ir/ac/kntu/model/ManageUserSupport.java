package ir.ac.kntu.model;

import java.util.HashSet;
import java.util.Set;

public class ManageUserSupport {
    private KindOfReport kindOfReport;
    private String message;
    private ReportStatuse reportStatuse;
    private Seller seller;
    private RegularUser user;

    public ManageUserSupport(KindOfReport kindOfReport, String message, RegularUser user) {
        this.kindOfReport = kindOfReport;
        this.message = message;
        this.reportStatuse = ReportStatuse.REGISTERED;
        this.user = user;
    }

    public ManageUserSupport(KindOfReport kindOfReport, String message, Seller seller) {
        this.kindOfReport = kindOfReport;
        this.message = message;
        this.reportStatuse = ReportStatuse.REGISTERED;
        this.seller = seller;
    }

    public RegularUser getUser() {
        return user;
    }

    public void setUser(RegularUser user) {
        this.user = user;
    }

    public Seller getSeller2() {
        return seller;
    }

    public void setSeller2(Seller seller) {
        this.seller = seller;
    }

    public KindOfReport getKindOfReport() {
        return kindOfReport;
    }

    public void setKindOfReport(KindOfReport kindOfReport) {
        this.kindOfReport = kindOfReport;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ReportStatuse getReportStatuse() {
        return reportStatuse;
    }

    public void setReportStatuse(ReportStatuse reportStatuse) {
        this.reportStatuse = reportStatuse;
    }

    @Override
    public String toString() {
        return "Kind of report:" + kindOfReport + " | status: " + reportStatuse + " | message: " + message;
    }
}
