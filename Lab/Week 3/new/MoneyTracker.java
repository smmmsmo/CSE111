public class MoneyTracker {

    public String name;
    public double balance;
    public double lastAdded;
    public double lastSpent;

    public String info() {
        return ("Name: " + name + "\n" +
                "Current Balance: " + balance);
    }

    public void createTracker(String name) {
        this.name = name;
        this.balance = 1.0;
    }

    public void income(double amount) {
        this.balance += amount;
        System.out.println("Balance updated");
        this.lastAdded = amount;
    }

    public void expense(double amount) {
        if (this.balance < amount) {
            System.out.println("Not enough balance");
            return;
        } else {
            this.balance -= amount;
            System.out.println("Balance updated");
            this.lastSpent = amount;
        }
    }

    public void showHistory() {
        System.out.println("Last Added: " + lastAdded);
        System.out.println("Last Spent: " + lastSpent);
    }

}
