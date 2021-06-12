public abstract class CheckingAccount extends BankAccount{


//----------------------------------------------------------------------------------------------------------------------
    // Ctor
    public CheckingAccount(String bankIdNumber, String accountOwnerName, String idNumber, double balance) {
        super(bankIdNumber, accountOwnerName, idNumber, balance);
    }
//----------------------------------------------------------------------------------------------------------------------
    public void writeCheck(double amount)throws IllegalBalance{
        System.out.println("An attempt of a check of " + amount + "$ has been written");
        super.withdraw(amount);
    }
//----------------------------------------------------------------------------------------------------------------------
}
