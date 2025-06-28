package ir.ac.kntu.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static ir.ac.kntu.model.Color.*;

public class SellerWallet {
    private double inventory;
    private double total = 0;
    private List<SellerTransaction> sellerTrans = new ArrayList<>();
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
            System.out.println("you withdraw ( " + targetMoneyAmount + " dollars) from your Wallet");
            sellerTrans.add(new SellerTransaction(LocalDateTime.now(),targetMoneyAmount,"withdraw"));
        } else {
            System.out.println(red + "your inventory not enough!!!" + reset);
        }
    }

    public void increaseInventory(double newMoney) {
        inventory += newMoney;
        setInventory(inventory);
        sellerTrans.add(new SellerTransaction(LocalDateTime.now(),newMoney,"new money"));
    }

    public void setTotalSales(double totalSale) {
        total += totalSale;
    }

    public double getTotal(){
        return total;
    }

    public void showAllTransaction(){
        if (sellerTrans.isEmpty()) {
            System.out.println(red+"not found any transaction"+reset);
        } else {
            for (SellerTransaction selt : sellerTrans) {
                System.out.println(selt);
            }
        }
    }

    public void showTransactionsBetween(LocalDateTime start, LocalDateTime end) {
        boolean isFound = false;
        for (SellerTransaction transaction : sellerTrans) {
            if (!transaction.getTransactionDate().isBefore(start) && !transaction.getTransactionDate().isAfter(end)) {
                System.out.println(transaction);
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println(red+"No transactions found in the selected date range."+reset);
        }
    }
}
