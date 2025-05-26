package ir.ac.kntu.model;

public class ManageUserSupport {
    private KindOfReport kindOfReport;
    private String message;
    private ReportStatuse reportStatuse;

    public ManageUserSupport(KindOfReport kindOfReport,String message){
        this.kindOfReport = kindOfReport;
        this.message = message;
        this.reportStatuse = ReportStatuse.REGISTERED;
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
    public String toString(){
        return "Kind of report:"+ kindOfReport + " | status: "+ reportStatuse +" | message: "+ message;
    }
}
