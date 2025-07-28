package ir.ac.kntu.model;

import java.util.HashMap;
import java.util.Map;

public class Products {
    private String name;
    private double price;
    private int instInventory;
    private Seller seller;
    private Map<RegularUser, Integer> productRatings = new HashMap<>();
    private Map<RegularUser, String> productComments = new HashMap<>();

    private Map<RegularUser, Boolean> letMeKnow = new HashMap<>();

    public Products(String name, double price, int instanceInventory) {
        this.name = name;
        this.price = price;
        this.instInventory = instanceInventory;
    }

    public Map<RegularUser, Boolean> getLetMeKnow() {
        return letMeKnow;
    }

    public void setLetMeKnow(RegularUser user, Boolean bool) {
        letMeKnow.put(user, bool);
    }

    public boolean hasUserRated(RegularUser user) {
        return productRatings.containsKey(user);
    }

    public boolean hasUserComment(RegularUser user) {
        return productComments.containsKey(user);
    }

    public void addRating(RegularUser user, int score) {
        if (!productRatings.containsKey((user))) {
            productRatings.put(user, score);
        } else {
            System.out.println("you have already rated this product.");
        }
    }

    public void addComments(RegularUser user, String comments) {
        if (!productComments.containsKey((user))) {
            productComments.put(user, comments);
        } else {
            System.out.println("you have already gave comment to this product.");
        }
    }

    public void getUserComments() {
        if (productComments.isEmpty()) {
            System.out.println("nothing!");
        } else {
            for (Map.Entry<RegularUser, String> prodComment : productComments.entrySet()) {
                System.out.println("person: " + prodComment.getKey().getFirstName() + " " + prodComment.getKey().getLastName() + " | comment: " + prodComment.getValue());
            }
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double money) {
        price = money;
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
        return "seller = " + seller.getFirstName() + " " + seller.getLastName() +
                ", name = " + name +
                ", price = " + price +
                ", instInventory = " + instInventory;
    }
}
