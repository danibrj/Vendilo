package ir.ac.kntu.model;

public class Seller {
    private String firstName;
    private String lastName;
    private String storeTitle;
    private String nationalCode;
    private String phoneNumber;
    private String password;
    private String provinceOfSale;
    private RegisterStstus status;
    private String agencyCode;
    private boolean isApproved;
    private boolean isRejected;
    private String reason;
    private SellerWallet sellerWallet = new SellerWallet();
    public Seller(String firstName, String lastName, String storeTitle, String nationalCode, String phoneNumber, String password, String provinceOfSale) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.storeTitle = storeTitle;
        this.nationalCode = nationalCode;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.provinceOfSale = provinceOfSale;
        this.status = RegisterStstus.PENDING;
        this.agencyCode = "";
        this.isApproved = false;
        this.isRejected = false;
        this.reason = "";
    }

    public SellerWallet getSellerWallet() {
        return sellerWallet;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStoreTitle() {
        return storeTitle;
    }

    public void setStoreTitle(String storeTitle) {
        this.storeTitle = storeTitle;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProvinceOfSale() {
        return provinceOfSale;
    }

    public void setProvinceOfSale(String provinceOfSale) {
        this.provinceOfSale = provinceOfSale;
    }

    public RegisterStstus getStatus() {
        return status;
    }

    public void setStatus(RegisterStstus status) {
        this.status = status;
    }

    public String getAgencyCode(){
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode){
        this.agencyCode = agencyCode;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public boolean isRejected() {
        return isRejected;
    }

    public void setRejected(boolean rejected) {
        isRejected = rejected;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
