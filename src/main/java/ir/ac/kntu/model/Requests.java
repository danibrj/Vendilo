//package ir.ac.kntu.model;
//
//public class Requests {
//    private Seller seller;
//    private RegisterStstus status;
//    private String responseMessage;
//
//    public Requests(Seller seller) {
//        this.seller = seller;
//        this.status = RegisterStstus.PENDING;
//    }
//
//    public Seller getSeller() {
//        return seller;
//    }
//
//    public void setSeller(Seller seller) {
//        this.seller = seller;
//    }
//
//    public RegisterStstus getStatus() {
//        return status;
//    }
//
//    public void setStatus(RegisterStstus status) {
//        this.status = status;
//        seller.setStatus(status);
//        System.out.println("setStatus");
//    }
//
//    public String getResponseMessage() {
//        return responseMessage;
//    }
//
//    public void setResponseMessage(String responseMessage) {
//        this.responseMessage = responseMessage;
//        seller.setReason(responseMessage);
//    }
//
//    public void settingIsApproved(boolean input) {
//        seller.setApproved(input);
//    }
//
//    public void settingIsRejected(boolean input) {
//        seller.setRejected(input);
//    }
//
//    @Override
//    public String toString(){
//        return "Seller: " +seller.getFirstName()+"-"+seller.getLastName()+"-"+seller.getNationalCode()+"-"+seller.getPhoneNumber()+"-"+seller.getStoreTitle()+"-"+seller.getProvinceOfSale()+"-"+seller.getPassword()+"-"+
//                "\nStatus:" + status+
//                "\nMessage: " + (responseMessage != null ? responseMessage : "no message yet");
//    }
//}
