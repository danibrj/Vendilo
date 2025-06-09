package ir.ac.kntu.model;

import java.util.HashMap;
import java.util.Map;

public class Products {
    private String name;
    private long price;
    private int instInventory;
    private Seller seller;
    private Map<RegularUser, Integer> productRatings = new HashMap<>();

    public Products(String name, long price, int instanceInventory) {
        this.name = name;
        this.price = price;
        this.instInventory = instanceInventory;
    }

    public boolean hasUserRated(RegularUser user) {
        return productRatings.containsKey(user);
    }

    public void addRating(RegularUser user, int score) {
        if (!productRatings.containsKey((user))) {
            productRatings.put(user, score);
        } else {
            System.out.println("you have already rated this product.");
        }
    }

    public Double getAverageRating() {
        if (productRatings.isEmpty()) {
            return null;
        }
        int sum = 0;
        for (int score : productRatings.values()) {
            sum += score;
        }
        return sum / (double) productRatings.size();
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        price = price;
    }

    public int getInstanceInventory() {
        return instInventory;
    }

    public void setInstanceInventory(int instanceInventory) {
        this.instInventory = instanceInventory;
    }

    public String getType() {
        return "product";
    }

    public void showDetails() {
        System.out.println("Product Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Seller: " + seller.getFirstName() + " " + seller.getLastName());

    }


    @Override
    public String toString() {
        return "seller = " + seller +
                ", name = " + name +
                ", price = " + price +
                ", instInventory = " + instInventory;
    }
}
