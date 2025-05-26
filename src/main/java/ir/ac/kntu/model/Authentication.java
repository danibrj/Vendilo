//package ir.ac.kntu.model;
//
//public class Authentication {
//    ManageRequests manageRequests = ManageRequests.getMRInstance();
//
//    public void Authentications() {
//        if (manageRequests.getRequests() != null) {
//            for (Requests info : manageRequests.getRequests()) {
//                if (info.getStatus().equals(RegisterStstus.PENDING)) {
//                    RegisterSellerBugs registerSellerBugs = new RegisterSellerBugs();
//                    if (registerSellerBugs.registerSeller(info.getSeller())) {
//                        info.setStatus(RegisterStstus.APPROVED);
//                        info.setResponseMessage("your registering do successfully");
////                    System.out.println(info.getResponseMessage());
//                        info.settingIsApproved(true);
//                        info.settingIsRejected(false);
//                        manageRequests.setIsOk(true);
//                    } else {
//                        info.setStatus(RegisterStstus.REJECTED);
//                        info.setResponseMessage("your registering rejected");
////                    System.out.println(info.getResponseMessage());
//                        info.settingIsApproved(false);
//                        info.settingIsRejected(true);
//                        manageRequests.setIsOk(false);
//
//                    }
//                }
//            }
//        }
//    }
//
//}
