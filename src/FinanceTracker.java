import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinanceTracker {

    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }


    public double getBalance() {
        double balance =0;
        for (Transaction t : transactions) {
            if (t.isExpense()) {
                balance = balance - t.getAmount();

            }else {
                balance = balance + t.getAmount();
            }
        }
        return balance;

    }

    public double getTotalExpenses() {
        double expenses = 0;
        for (Transaction t : transactions) {
            if (t.isExpense()) {
                expenses = expenses + t.getAmount();
            }
        }
        return expenses;
    }

    public Map<String, Double> expensesByCategory(){
        Map<String,Double> expenses  = new HashMap<>();
        for (Transaction t : transactions) {
            if (t.isExpense()) {
                expenses.put(t.getCategory() , expenses.getOrDefault(t.getCategory(),0.0) + t.getAmount());

            }
        }
        return expenses;

    }
}