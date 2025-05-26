package ir.ac.kntu.model;

import java.time.LocalDateTime;
import java.util.List;

public class OrderUser {
    private List<Products> orderedProducts;
    private Address deliveryAddress;
    private LocalDateTime orderDate;
    private double totalPrice;
    private RegularUser buyer;

    public OrderUser(List<Products> orderedProducts, Address deliveryAddress, double totalPrice, RegularUser buyer) {
        this.orderedProducts = orderedProducts;
        this.deliveryAddress = deliveryAddress;
        this.orderDate = LocalDateTime.now();
        this.totalPrice = totalPrice;
        this.buyer = buyer;
    }

    public List<Products> getOrderedProducts() {
        return orderedProducts;
    }

    public RegularUser getBuyer() {
        return buyer;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void showOrderDetails() {
        System.out.println("Order Date: " + orderDate);
        System.out.println("Delivery Address: " + deliveryAddress);
        System.out.println("Ordered Products:");
        for (Products p : orderedProducts) {
            System.out.println("- " + p.getName() + " from seller: " + p.getSeller().getFirstName() + " " + p.getSeller().getLastName());
        }
        System.out.println("Total Paid: " + totalPrice + " $");
    }

    @Override
    public String toString() {
        return "Order by: " + buyer.getEmail() + " | Date: " + orderDate + " | Total: " + totalPrice;
    }

}
