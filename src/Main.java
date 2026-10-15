import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FinanceTracker tracker = new FinanceTracker();
        Scanner scanner = new Scanner(System.in);

        tracker.addTransaction(new Transaction("Salary", 1000, "Work", false));
        tracker.addTransaction(new Transaction("Supermarket", 45.5, "Food" , true));
        tracker.addTransaction(new Transaction("rent" , 400 ,"Hone", true));


        boolean running = true;
        while (running) {
            System.out.println("1. Add transaction");
            System.out.println("2. Show all");
            System.out.println("3. Show balance");
            System.out.println("4. Expenses by category");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                try {
                    System.out.print("Description: ");
                    String description = scanner.nextLine();

                    System.out.print("Amount: ");
                    double amount = Double.parseDouble(scanner.nextLine());

                    System.out.print("Category: ");
                    String category = scanner.nextLine();

                    System.out.print("Is it an expense? (yes/no): ");
                    String answer = scanner.nextLine();
                    boolean expense = answer.equals("yes");

                    tracker.addTransaction(new Transaction(description, amount, category, expense));
                    System.out.println("Added!");
                }catch (NumberFormatException e) {
                    System.out.println("Amount must be number");
                }catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            }else if (choice.equals("2")) {
                for (Transaction t : tracker.getTransactions()) {
                    System.out.println(t.getDescription() + " - " + t.getAmount() + " (" + t.getCategory() + ")");
                }

            } else if (choice.equals("3")) {
                System.out.println("Balance: " + tracker.getBalance());

            } else if (choice.equals("4")) {
                System.out.println("Expenses by category:" + tracker.expensesByCategory());

            } else if (choice.equals("0")) {
                running = false;
            }

        }

        for (Transaction t : tracker.getTransactions()){
            System.out.println(t.getDescription() + " - " + t.getAmount() + " - " + t.getCategory() + " - " + t.isExpense());
        }
        System.out.println("Balance is: " + tracker.getBalance());
        System.out.println("Total expenses are: " + tracker.getTotalExpenses());

    }
}