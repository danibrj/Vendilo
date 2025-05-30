package ir.ac.kntu.model;

import java.util.ArrayList;
import java.util.List;
import static ir.ac.kntu.model.Color.*;


public class RegisterSellerBugs {
    private List<Seller> sellers = new ArrayList<>();

    public List<Seller> getSellers() {
        return sellers;
    }

    public boolean isTitleExists(String storeTitle) {
        for (Seller sl : sellers) {
            if (sl.getStoreTitle().equals(storeTitle)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPhoneNumberExists(String phoneNumber) {
        for (Seller sl : sellers) {
            if (sl.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    public boolean isNationalCodeExists(String nationalCode) {
        for (Seller sl : sellers) {
            if (sl.getNationalCode().equals(nationalCode)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPasswordOk(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%&+=]).{8,}$");
    }

    public boolean isPnFormatOk(String phoneNumber) {
        return phoneNumber.matches("^09\\d{9}$");
    }

    //public

    public boolean registerSeller(Seller seller) {
        if (isTitleExists(seller.getStoreTitle())) {
            System.out.println(red+"the store title is repetitive"+reset);
            return false;
        }
        if (isPhoneNumberExists(seller.getPhoneNumber())) {
            System.out.println(red+"the phone number is repetitive"+reset);
            return false;
        }
        if (isNationalCodeExists(seller.getNationalCode())) {
            System.out.println(red+"the national code is repetitive"+reset);
            return false;
        }
        if (!isPasswordOk(seller.getPassword())) {
            System.out.println(red+"the password format is wrong!!!"+reset);
            return false;
        }

        if (!isPnFormatOk(seller.getPhoneNumber())) {
            System.out.println(red+"the phoneNumber format is wrong!!!"+reset);
            return false;
        }

        sellers.add(seller);
        return true;
    }

    public Seller login(String agencyCode, String password) {
        for (Seller sl : sellers) {
            if (sl.getAgencyCode().equals(agencyCode) && sl.getPassword().equals(password)) {
                return sl;
            }
        }
        return null;
    }
}