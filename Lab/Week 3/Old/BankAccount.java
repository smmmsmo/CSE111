
public class BankAccount {

    public int bankAccountNumber = 0;
    public String type = "Not Set";
    
    public String printDetails() {
        return "Account No: " + bankAccountNumber + "\nType: " + type;
    }

    public void setInfo(int accountNumber, String accountType) {
        this.bankAccountNumber = accountNumber;
        this.type = accountType;
        System.out.println("Account information updated!");
    }
}
