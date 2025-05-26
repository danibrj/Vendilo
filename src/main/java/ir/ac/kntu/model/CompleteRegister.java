package ir.ac.kntu.model;

public class CompleteRegister {
    private RegisterSellerBugs regisSellBugs;
    private ManageRequests manageRequests;
    public CompleteRegister(RegisterSellerBugs regisSellBugs,ManageRequests manageRequests) {
        this.regisSellBugs = regisSellBugs;
        this.manageRequests = manageRequests;

    }

    public void show(Seller seller) {
        if (regisSellBugs.registerSeller(seller)) {
            Requests requests = new Requests(seller);
            manageRequests.addRequest(requests);
        }else{
            System.out.println("invalid information");
        }

    }
}
