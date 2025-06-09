package ir.ac.kntu.model;

import static ir.ac.kntu.model.Color.*;

public class IsOkFromSupporter {

//    private ManageRequests manageRequests;
    private Seller seller;

    public IsOkFromSupporter(/*ManageRequests manageRequests,*/ Seller seller) {
//        this.manageRequests = manageRequests;
        this.seller = seller;
    }

    public void show() {

        if (seller.isApproved()) {
            CreateSpecificCodeForSeller crSpeCodeSell = new CreateSpecificCodeForSeller();
            String agencyCode = crSpeCodeSell.createUniqueCode();
            seller.setAgencyCode(agencyCode);
            System.out.println(green + "your registering do successfully" + reset);
            System.out.println(blue + "your agencyCode is: " + reset + seller.getAgencyCode());
        } else {
            seller.setAgencyCode(null);
            System.out.println(red + "you cant login.your situation unknown" + reset);
            return;
        }
        System.out.println();
    }
}
