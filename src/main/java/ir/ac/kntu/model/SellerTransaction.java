package ir.ac.kntu.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SellerTransaction {
    private LocalDateTime transactionDate;
    private double amount;
    private String type;

    public SellerTransaction(LocalDateTime transactionDate, double amount, String type) {
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.type = type;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
        return String.format("[%s] %s : %.2f dollars", transactionDate.format(formatter), type, amount);

    }
}
