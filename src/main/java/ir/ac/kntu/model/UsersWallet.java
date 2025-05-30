package ir.ac.kntu.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static ir.ac.kntu.model.Color.*;

public class UsersWallet {
    private double inventory;

    private List<Userstransaction> userstransactions = new ArrayList<>();

    public void setInventory(double inventory) {
        this.inventory = inventory;
    }

    public double getInventory() {
        return inventory;
    }

    public void charge(double amount) {
        inventory += amount;
        userstransactions.add(new Userstransaction(LocalDateTime.now(), amount, "Charge"));
    }

    public void decreaseInventory(double amount) {
        inventory -= amount;
        userstransactions.add(new Userstransaction(LocalDateTime.now(), amount, "Shopping"));

    }

    public List<Userstransaction> getUserstransactions() {
        return userstransactions;
    }

    public void showAllTransaction() {
        if (userstransactions.isEmpty()) {
            System.out.println(red+"not found any transaction"+reset);
        } else {
            for (Userstransaction t : userstransactions) {
                System.out.println(t);
            }
        }
    }

    public void showTransactionsBetween(LocalDateTime start, LocalDateTime end) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        boolean isFound = false;
        for (Userstransaction transaction : userstransactions) {
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
