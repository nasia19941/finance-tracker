public class Transaction {
    private String description;
    private double amount;
    private String category;
    private boolean expense;

    public Transaction(String description, double amount, String category, boolean expense) {
        if (amount <=  0) {
            throw new InvalidAmountException("Amount must be greater than 0");
        }
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.expense = expense;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public boolean isExpense(){
        return expense;
    }

}
