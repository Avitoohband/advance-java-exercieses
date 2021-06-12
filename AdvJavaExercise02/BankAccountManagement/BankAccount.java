public abstract class BankAccount {

    private String accountOwnerName;
    private String bankIdNumber;
    private String idNumber;
    private double balance;
    private final int PERCENTAGE_OFFSET = 100;

//----------------------------------------------------------------------------------------------------------------------
    //Ctor
    public BankAccount(String accountOwnerName, String bankIdNumber, String idNumber, double balance) {
        this.accountOwnerName = accountOwnerName;
        this.bankIdNumber = bankIdNumber;
        this.idNumber = idNumber;
        this.setBalance(balance);
    }

//----------------------------------------------------------------------------------------------------------------------
    // Add the given amount of money to the current balance
    public void deposit(double amount){
        this.setBalance(this.getBalance() + amount);
        System.out.println(amount + "$ have been deposited to Mr\\Ms." + this.getAccountOwnerName() + "'s account");
    }
//----------------------------------------------------------------------------------------------------------------------
    // Remove the given amount of money from the account as long as it doesn't go under 0$
    public void withdraw(double amount) throws IllegalBalance{
        amount = this.balanceFormat(amount);
        if (this.getBalance() - amount < 0){
            throw new IllegalBalance("EXCEPTION! exceeding illegal balance Cannot go under 0.0");
        }
        this.setBalance(this.getBalance() - amount);
        System.out.println(amount + "$ have been withdrawn from added to Mr\\Ms." + this.getAccountOwnerName() + "'s account");
    }
//----------------------------------------------------------------------------------------------------------------------
    // An abstract method to be implemented in the inheritance classes
    public abstract void monthlyManagement();
//----------------------------------------------------------------------------------------------------------------------
   // Returns String represent the object of the class
    @Override
    public String toString() {
        return "Bank Account Details{" +
                "Account Owner Name='" + accountOwnerName + '\'' +
                ", Bank ID Number='" + bankIdNumber + '\'' +
                ", Owner ID Number='" + idNumber + '\'' +
                ", Balance="+ this.getBalance() +
                "$}";
    }
//----------------------------------------------------------------------------------------------------------------------
    // Comparing to the other BankAccount object and returns true if equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Double.compare(that.getBalance(), this.getBalance()) == 0 &&
                this.getBankIdNumber().equals(that.getBankIdNumber()) &&
                this.getAccountOwnerName().equals(that.getAccountOwnerName()) &&
                this.getIdNumber().equals(that.getIdNumber());
    }

//----------------------------------------------------------------------------------------------------------------------
    // Returns a more convenience format of double (00.00), better to work with when calculating
    public double balanceFormat(double number){
        return Math.round(number*100)/100.0;
    }
//----------------------------------------------------------------------------------------------------------------------

    // Getters!
    public String getBankIdNumber() {
        return bankIdNumber;
    }

    public String getAccountOwnerName() {
        return accountOwnerName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public double getBalance() {
        return balance;
    }
//----------------------------------------------------------------------------------------------------------------------

    //Setters!
    public void setBankIdNumber(String bankIdNumber) {
        this.bankIdNumber = bankIdNumber;
    }

    public void setAccountOwnerName(String accountOwnerName) {
        this.accountOwnerName = accountOwnerName;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setBalance(double balance) {
        this.balance = this.balanceFormat(balance);
    }

    public int getPerOffset() {
        return PERCENTAGE_OFFSET;
    }
//----------------------------------------------------------------------------------------------------------------------
}
