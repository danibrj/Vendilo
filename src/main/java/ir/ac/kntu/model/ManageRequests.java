//package ir.ac.kntu.model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ManageRequests {
//
//    private static final ManageRequests MRInstance = new ManageRequests();
//
//    public static ManageRequests getMRInstance() {
//        return MRInstance;
//    }
//
//    private List<Requests> requests = new ArrayList<>();
//    private boolean isOk = false;
//
//    public boolean isOk() {
//        return isOk;
//    }
//
//    public void setIsOk(boolean input) {
//        this.isOk = input;
//    }
//
//    public void addRequest(Requests request) {
//        requests.add(request);
//    }
//
//    public List<Requests> getRequests() {
//        return requests;
//    }
//
//    public void showRequests() {
//        for (Requests req : requests) {
//            System.out.println((requests.indexOf(req) + 1) + " " + req + "\n");
//        }
//    }
//}
//
