package ir.ac.kntu.model;

import java.util.*;

public class ProductsManager {

    private static final ProductsManager instance = new ProductsManager();
    private Map<Seller,List<Products>> productss = new HashMap<>();

    private ProductsManager() {

    }

    public Map<Seller,List<Products>> getProductss() {
        return productss;
    }

    public void addProduct(Seller seller,Products product) {
        productss.putIfAbsent(seller, new ArrayList<>());
        productss.get(seller).add(product);
    }

    public static ProductsManager getInstance() {
        return instance;
    }

    public List<Products> findByName(String name) {
        List<Products> result = new ArrayList<>();
        for(List<Products> proList : productss.values()) {
            for (Products pro : proList) {
                if (pro.getName().equalsIgnoreCase(name)) {
                    result.add(pro);
                }
            }
        }
        return result;
    }

    public void increaseInventory(Products prod, int amount) {
        if (prod == null) {
            System.out.println("not selected!!!");
            return;
        }
        int newInventory = prod.getInstanceInventory() + amount;
        if (newInventory < 0) {
            System.out.println("the inventory can not be negative");
            return;
        }
        prod.setInstanceInventory(newInventory);
        System.out.println("the inventory updated.\nthe new inventory: " + newInventory);
    }

    public void showAllProducts(Seller seller) {
        List<Products> sortedList = productss.getOrDefault(seller,new ArrayList<>());
        sortedList.sort(Comparator.comparing(Products::getType, String.CASE_INSENSITIVE_ORDER));
        for (Products p : sortedList) {
            System.out.println(p);
        }
    }

    public void decreaseInventory(Products prod, int amount) {
        if (prod == null) {
            System.out.println("not selected!!!");
            return;
        }
        int newInventory = prod.getInstanceInventory();
        if (prod.getInstanceInventory() >= amount) {
            newInventory = prod.getInstanceInventory() - amount;
        }
        if (newInventory < 0) {
            System.out.println("the inventory can not be negative");
            return;
        }
        prod.setInstanceInventory(newInventory);
        System.out.println("the inventory updated.\nthe new inventory: " + newInventory);
    }

    public void showProductsDetails(Products products) {
        if (products == null) {
            System.out.println("not found");
            return;
        }
        System.out.println(products);
    }
}
