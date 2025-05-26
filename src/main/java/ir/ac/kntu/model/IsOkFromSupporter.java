package ir.ac.kntu.model;

public class IsOkFromSupporter {

    private ManageRequests manageRequests;
    private Seller seller;

    public IsOkFromSupporter(ManageRequests manageRequests, Seller seller) {
        this.manageRequests = manageRequests;
        this.seller = seller;
    }

    public void show() {
        if (manageRequests.isOk()) {
            CreateSpecificCodeForSeller crSpeCodeSell = new CreateSpecificCodeForSeller();
            String agencyCode = crSpeCodeSell.createUniqueCode();
            seller.setAgencyCode(agencyCode);
            System.out.println("your registering do successfully");
            System.out.println("your agencyCode is: " + seller.getAgencyCode());
        } else {
            seller.setAgencyCode(null);
            System.out.println("you cant login.your situation unknown");
        }
    }
}
