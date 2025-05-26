package ir.ac.kntu.model;

import java.util.ArrayList;
import java.util.List;

public class SellerRepository {
    private static final SellerRepository Sinstance = new SellerRepository();
    private List<Seller> sellers = new ArrayList<>();

    public static SellerRepository getSinstance(){
        return Sinstance;
    }

    public void addSeller(Seller seller) {
        sellers.add(seller);
    }

    public List<Seller> getAllSellers() {
        return sellers;
    }

    public Seller findByPhoneOrNationalCode(String input) {
        for (Seller seller : sellers) {
            if (seller.getPhoneNumber().equals(input) || seller.getNationalCode().equals(input)) {
                return seller;
            }
        }
        return null;
    }
}
