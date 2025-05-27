package ir.ac.kntu.model;

import java.util.*;

public class ShoppingCart {

    private static final ShoppingCart SpInstance = new ShoppingCart();
    private List<Products> proOfCart = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private final float SHIPPING_COST = 1;
    private float totalCost = 0;
    private float totalPrice = 0;
    private Set<Seller> uniqueSeller = new HashSet<>();
    private boolean isSellerSameP = true;

    public static ShoppingCart getSpInstance() {
        return SpInstance;
    }

    public List<Products> getProOfCart() {
        return proOfCart;
    }

    public void addProToCart(Products prod) {
        proOfCart.add(prod);
    }

    public void showAllProOfCart() {
        int sum = 0;
        for (Products prod : proOfCart) {
            System.out.println("name: " + prod.getName() + "  price: " + prod.getPrice());
            sum += (int) prod.getPrice();
        }
        System.out.println("sum of price: " + sum);
    }

    public void removePro(Products prod) {
        boolean removed = proOfCart.removeIf(a -> a.equals(prod));
        if (removed) {
            System.out.println("product removed successfully");
        } else {
            System.out.println("product not found!!!");
        }
    }

    public void showPDetails(Products prod) {
        if (prod == null) {
            System.out.println("not found!!!");
            return;
        }
        System.out.println(prod);
    }

    public void costOfSend(Address address, RegularUser user) {
        List<Products> pdt = user.getCart().getProOfCart();
        if (pdt.isEmpty()) {
            System.out.println("your cart is empty.");
            return;
        }
        for (Products prod : pdt) {
            if (prod.getInstanceInventory() <= 0) {
                System.out.println("this product" + prod.getName() + " has not inventory");
                return;
            }
            totalCost += prod.getPrice();
            uniqueSeller.add(prod.getSeller());
        }
        for (Seller sel : uniqueSeller) {
            if (!sel.getProvinceOfSale().equalsIgnoreCase(address.getProvince())) {
                isSellerSameP = false;
                break;
            }
        }
        float shippingCost = isSellerSameP ? (SHIPPING_COST * uniqueSeller.size()) / 3 : SHIPPING_COST * uniqueSeller.size();
        totalPrice = totalCost + shippingCost;
        shows(pdt, shippingCost, user, address);
    }

    public void shows(List<Products> pdt, double shippingCost, RegularUser user, Address address) {
        System.out.println("-----product list-----");
        for (Products p : pdt) {
            System.out.println(p);
        }
        System.out.print("the cost of product : " +totalCost + " $\n the cost of send : "+shippingCost + " $\nthe generally cost :  " +totalPrice + " $\n");
        System.out.println("do you want to payment?");
        String yesOrNo = scanner.nextLine();
        if ("yes".equalsIgnoreCase(yesOrNo)) {
            showPayment(user, pdt, totalPrice, address);
        } else {
            return;
        }
        System.out.println();
    }

    public void showPayment(RegularUser user, List<Products> pdt, double totalPrice, Address address) {
        if (user.getUsersWallet().getInventory() < totalPrice) {
            System.out.println("ERROR: your inventory not enough");
            System.out.println("going to wallet for charge ...");
            ShowWallet.getShowWal().show(user);
            if (user.getUsersWallet().getInventory() >= totalPrice) {
                completePayment(user, pdt, totalPrice, address);
                for (Products prod : pdt) {
                    prod.getSeller().getSellerWallet().increaseInventory(prod.getPrice()*0.9);
                }
            } else {
                System.out.println("Still insufficient balance. Returning to cart.");
            }
        } else {
            completePayment(user, pdt, totalPrice, address);
            for (Products prod : pdt) {
                prod.getSeller().getSellerWallet().increaseInventory(prod.getPrice()*0.9);
            }
        }
    }

    private void completePayment(RegularUser user, List<Products> pdt, double totalPrice, Address address) {
        user.getUsersWallet().decreaseInventory(totalPrice);

        OrderUser order = new OrderUser(new ArrayList<>(pdt), address, totalPrice, user);
        user.addorder(order);
        OrderManager.getOMInstance().addOrder(order);
        for (Products prod : pdt) {
            prod.setInstanceInventory(prod.getInstanceInventory() - 1);
        }

        pdt.clear();
        System.out.println("Payment successful! Your order has been placed.");
        System.out.println("Remaining Wallet Balance: " + user.getUsersWallet().getInventory() + " $");
    }
}
