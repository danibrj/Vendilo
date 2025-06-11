package ir.ac.kntu.model;

import java.time.LocalDateTime;
import java.util.*;

import static ir.ac.kntu.model.Color.*;

public class ShoppingCart {

    private static final ShoppingCart SpInstance = new ShoppingCart();
    private List<Products> proOfCart = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private final float SHIPPING_COST = 1;
    private float totalCost = 0;
    private float totalPrice = 0;
    private Set<Seller> uniqueSeller = new HashSet<>();
//    private DiscountCode disC;
    private float shippingCost=0;
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
            System.out.println(green + "product removed successfully" + reset);
        } else {
            System.out.println(red + "product not found!!!" + reset);
        }
    }

    public void showPDetails(Products prod) {
        if (prod == null) {
            System.out.println(red + "not found!!!" + reset);
            return;
        }
        System.out.println(prod);
    }

    public void costOfSend(Address address, RegularUser user) {
        totalCost = 0;
        totalPrice = 0;
        uniqueSeller.clear();
        boolean isSellerSameP = true;
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
        float shipCost = returnShopCost(user, isSellerSameP);
        totalPrice = totalCost + shipCost;
        shows(pdt, shipCost, user, address);
    }

    private float returnShopCost(RegularUser user, boolean isSellerSameP) {
        VendiloPlus targetVend = VendiloPlusManager.getVpmInstance().findVendByUser(user);
        LocalDateTime now = LocalDateTime.now();
        if(isSellerSameP){
            if(targetVend!=null && (targetVend.getExpirationDate().isEqual(now) || targetVend.getExpirationDate().isAfter(now))){
                shippingCost =0;
            }else{
                shippingCost = (SHIPPING_COST * uniqueSeller.size()) / 3;
            }
        }else{
            if(targetVend!=null && (targetVend.getExpirationDate().isEqual(LocalDateTime.now()) || targetVend.getExpirationDate().isAfter(LocalDateTime.now()))){
                shippingCost =(SHIPPING_COST * uniqueSeller.size()) / 3;
            }else {
                shippingCost = SHIPPING_COST * uniqueSeller.size();
            }
        }
        return shippingCost;
    }

    public void shows(List<Products> pdt, float shipCost, RegularUser user, Address address) {
        System.out.println(cyan + "-----product list-----" + reset);
        for (Products p : pdt) {
            System.out.println(p);
        }
        System.out.print("the cost of product : " + totalCost + " $\nthe cost of send : " + shipCost + " $\nthe generally cost :  " + totalPrice + " $\n");
        System.out.println(cyan + "do you want to payment?" + reset);
        String yesOrNo = scanner.nextLine();
        if ("yes".equalsIgnoreCase(yesOrNo)) {
            System.out.println(blue + "do you want to use discount code?" + reset);
            String yesOrNo2 = scanner.nextLine();
            if ("yes".equalsIgnoreCase(yesOrNo2)) {
                DiscountCodeManager dcMan = DiscountCodeManager.getDisManInstance();
                System.out.println("codes: \n");
                dcMan.showCodesGenerally(user);
                System.out.print("--------------------\n");
                payByDiscount(dcMan,user,pdt,address);
            } else {
                showPayment(user, pdt, totalPrice, address);
            }
        } else {
            return;
        }
        System.out.println();
    }

    public void payByDiscount(DiscountCodeManager dcMan,RegularUser user,List<Products> pdt,Address address){
        boolean isEnd = true;
        while (isEnd) {
            System.out.println("codes that yo can use them: ");
            for (RegularUser reUser : dcMan.getUserDisCode().keySet()) {
                if (reUser.equals(user)) {
                    for (int i = 0; i < dcMan.getUserDisCode().get(user).size(); i++) {
                        System.out.println((i + 1) + " " + dcMan.getUserDisCode().get(user).get(i).getName());
                    }
                }
            }
            System.out.println(blue + "choose one: " + reset);
            int num = scanner.nextInt();
            scanner.nextLine();
            if (num < 1 || num > dcMan.getUserDisCode().get(user).size()) {
                System.out.println(red + "invalid num" + reset);
                return;
            }
            if(dcMan.getUserDisCode().get(user).get(num - 1).getNumsOfTimesOfUse() <= 0){
                System.out.println(red + "you can not use this code.because finished" + reset);
                return;
            }
            KindsOfCode type = dcMan.getUserDisCode().get(user).get(num - 1).getKindsOfCode();
            if (type.equals(KindsOfCode.SPECIAL) && !(totalCost > 10 * dcMan.getUserDisCode().get(user).get(num - 1).getDiscountValue())) {
                System.out.println(red + "you can not use this code.because your totalCost not enough" + reset);
                return;
            }
            DiscountCode disCode = dcMan.getUserDisCode().get(user).get(num - 1);
            dcMan.showCodesDetails(disCode);
            isEnd = showww(disCode,user,pdt,address);
        }
    }

    public boolean showww(DiscountCode disCode,RegularUser user,List<Products> pdt,Address address){
        System.out.println("it's ok to use?");
        String yesOrNo3 = scanner.nextLine();
        if ("yes".equalsIgnoreCase(yesOrNo3)) {
            float newTotalPrice = shows2(disCode);
            System.out.println("finally, shopping?");
            String yesOrNo4 = scanner.nextLine();
            if ("yes".equalsIgnoreCase(yesOrNo4)) {
                disCode.setNumsOfTimesOfUse(disCode.getNumsOfTimesOfUse() - 1);
                showPayment(user, pdt, newTotalPrice, address);
                return false;
            }
        }
        return true;
    }

    public float shows2(DiscountCode disCode){
        float newTotalCost = 0.0f;
        float newTotalPrice= 0;
        if (disCode.getKindsOfCode().equals(KindsOfCode.USUAL)) {
            newTotalCost = (1 - disCode.getDiscountValue()) * totalCost;
            System.out.println("the code value: " + disCode.getDiscountValue() + " %");
        } else if (disCode.getKindsOfCode().equals(KindsOfCode.SPECIAL)) {
            newTotalCost = totalCost - disCode.getDiscountValue();
            System.out.println("the code value: " + disCode.getDiscountValue() + " $");
        }
        System.out.println("the total cost before put discount code: " + totalCost + " $");
        System.out.println("the total cost after put discount code: " + newTotalCost + " $");
        newTotalPrice = shippingCost + newTotalCost;
        return newTotalPrice;
    }

    public void showPayment(RegularUser user, List<Products> pdt, double totalPrice, Address address) {
        if (user.getUsersWallet().getInventory() < totalPrice) {
            System.out.println(red + "ERROR: your inventory not enough" + reset);
            System.out.println(blue + "going to wallet for charge ..." + reset);
            ShowWallet.getShowWal().show(user);
            if (user.getUsersWallet().getInventory() >= totalPrice) {
                completePayment(user, pdt, totalPrice, address);
//                for (Products prod : pdt) {
//                    prod.getSeller().getSellerWallet().increaseInventory(prod.getPrice()*0.9);
//                }
            } else {
                System.out.println("Still insufficient balance. Returning to cart.");
            }
        } else {
            completePayment(user, pdt, totalPrice, address);
//            for (Products prod : pdt) {
//                prod.getSeller().getSellerWallet().increaseInventory(prod.getPrice()*0.9);
//            }
        }
    }

    private void completePayment(RegularUser user, List<Products> pdt, double totalPrice, Address address) {
        user.getUsersWallet().decreaseInventory(totalPrice);

        OrderUser order = new OrderUser(new ArrayList<>(pdt), address, totalPrice, user);
        user.addorder(order);
        OrderManager.getOMInstance().addOrder(order);
        for (Products prod : pdt) {
            prod.setInstanceInventory(prod.getInstanceInventory() - 1);

            Seller realSeller = SellerRepository.getSinstance().findByPhoneOrNationalCode(prod.getSeller().getPhoneNumber());
            if (realSeller != null) {
                VendiloPlus targetVend = VendiloPlusManager.getVpmInstance().findVendByUser(user);
                if (targetVend != null && (targetVend.getExpirationDate().isEqual(LocalDateTime.now()) || targetVend.getExpirationDate().isAfter(LocalDateTime.now()))) {
                    realSeller.getSellerWallet().increaseInventory((prod.getPrice()/0.95) * 0.9);
                    realSeller.getSellerWallet().setTotalSales((prod.getPrice()/0.95) * 0.9);
                    prod.setPrice(prod.getPrice()/0.95);
                }else{
                    realSeller.getSellerWallet().increaseInventory(prod.getPrice() * 0.9);
                    realSeller.getSellerWallet().setTotalSales(prod.getPrice() * 0.9);
                    prod.setPrice(prod.getPrice()/0.95);
                }
            } else {
                System.out.println(red + "Seller not found in repository for product: " + prod.getName() + reset);
            }

        }
        pdt.clear();
        System.out.println(green + "Payment successful! Your order has been placed." + reset);
        System.out.println("Remaining Wallet Balance: " + user.getUsersWallet().getInventory() + " $");
    }
}
