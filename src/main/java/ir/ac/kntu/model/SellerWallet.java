package ir.ac.kntu.model;

import static ir.ac.kntu.model.Color.*;

public class SellerWallet {
    private double inventory;

    public double getInventory() {
        return inventory;
    }

    public void setInventory(double money) {
        this.inventory = money;
    }

    public void getMoney(double targetMoneyAmount) {
        if (inventory >= targetMoneyAmount) {
            inventory -= targetMoneyAmount;
            setInventory(inventory);
        } else {
            System.out.println(red+"your inventory not enough!!!"+reset);
        }
    }

    public void increaseInventory(double newMoney) {
        inventory += newMoney;
        setInventory(inventory);
    }
}
