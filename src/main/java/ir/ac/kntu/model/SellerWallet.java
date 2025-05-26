package ir.ac.kntu.model;

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
            System.out.println("your inventory not enough!!!");
        }
    }

    public void increaseInventory(double newMoney) {
        inventory += newMoney;
        setInventory(inventory);
    }
}
