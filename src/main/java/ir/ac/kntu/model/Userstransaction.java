package ir.ac.kntu.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Userstransaction {

    private LocalDateTime transactionDate;
    private double amount;
    private String type;

    public Userstransaction(LocalDateTime transactionDate, double amount, String type) {
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.type = type;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
        return String.format("[%s] %s: %.2f dollars", transactionDate.format(formatter), "Charge".equals(type) ? "Charge" : "Shopping", amount);
    }

    public double getAmount() {
        return amount;
    }
}
//    public void setChargeTransaction(LocalDate chargeDate,Long invention){
//        chargeTransaction.put(chargeDate,invention);
//    }
//
//    public Map<LocalDate,Long> getChargeTransaction(){
//        return chargeTransaction;
//    }

