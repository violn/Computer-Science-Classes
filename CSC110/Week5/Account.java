//Step 1: You will need to add proper package name here:

public class Account
{
    private double balance;
    private String name;
    private long acctNumber;
    // ---------------------------------------------
    //Constructor --initializes balance, owner, and account number
    // --------------------------------------------
    public Account(double initBal, String owner, long number)
    {
        balance = initBal;
        name = owner;
        acctNumber = number;
    }
        // --------------------------------------------
        // Checks to see if balance is sufficient for withdrawal.
        // If so, decrements balance by amount; if not, prints message.
        // --------------------------------------------
    public void withdraw(double amount)
    {
        if (balance >= amount)
            balance -= amount;
        else 
            System.out.println("Insufficient funds");
    }
    // --------------------------------------------
    // Adds deposit amount to balance.
    // --------------------------------------------
    public void deposit(double amount)
    {
        balance += amount;
    }
    // --------------------------------------------
    // Returns balance.
    // --------------------------------------------
    public double getBalance()
    {
        return balance;
    }
    // --------------------------------------------
    // Returns a string containing the name, account number, and balance.
    // --------------------------------------------
    public String toString()
    {
        return (name + " " + acctNumber + " " + balance);
    }
    // --------------------------------------------
    // Deducts $10 service fee 
    //
    // --------------------------------------------
    public double chargeFee(double fee)
    {
        balance -= fee;
        return balance;
    }
    // --------------------------------------------
    // Changes the name on the account
    // --------------------------------------------
    public void changeName(String newName)
    {
        name = newName;
    }
}