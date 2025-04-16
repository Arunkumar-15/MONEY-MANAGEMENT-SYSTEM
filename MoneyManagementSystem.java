import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Transaction {
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}

public class MoneyManagementSystem {
    private List<Transaction> transactions;
    private double balance;

    public MoneyManagementSystem() {
        this.transactions = new ArrayList<>();
        this.balance = 0.0;
    }

    public void addTransaction(String type, double amount) {
        Transaction transaction = new Transaction(type, amount);
        transactions.add(transaction);
        if (type.equals("income")) {
            balance += amount;
        } else if (type.equals("expense")) {
            balance -= amount;
        }
    }

    public void displayTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println("Type: " + transaction.getType() + ", Amount: " + transaction.getAmount());
        }
    }

    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public static void main(String[] args) {
        MoneyManagementSystem mms = new MoneyManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. Display Transactions");
            System.out.println("4. Display Balance");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter income amount: ");
                    double incomeAmount = scanner.nextDouble();
                    mms.addTransaction("income", incomeAmount);
                    break;
                case 2:
                    System.out.print("Enter expense amount: ");
                    double expenseAmount = scanner.nextDouble();
                    mms.addTransaction("expense", expenseAmount);
                    break;
                case 3:
                    mms.displayTransactions();
                    break;
                case 4:
                    mms.displayBalance();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }
}
