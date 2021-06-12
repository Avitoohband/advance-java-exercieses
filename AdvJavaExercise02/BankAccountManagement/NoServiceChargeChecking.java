public class NoServiceChargeChecking extends CheckingAccount{
    private final double DEFAULT_MIN_BALANCE_AVAILABLE = 14.70;
    private  double minBalanceAvailable = 0 ;
//----------------------------------------------------------------------------------------------------------------------
    // Ctor
    public NoServiceChargeChecking(String accountOwnerName, String bankIdNumber, String idNumber, double balance) {
        super( accountOwnerName, bankIdNumber,idNumber, balance);
    }

//----------------------------------------------------------------------------------------------------------------------
    // Ctor with minimum available balance
    public NoServiceChargeChecking(String accountOwnerName, String bankIdNumber, String idNumber, double balance, double minBalanceAvailable) {
        super( accountOwnerName, bankIdNumber,idNumber, balance);
        this.minBalanceAvailable = minBalanceAvailable ;
    }

//----------------------------------------------------------------------------------------------------------------------
    // A new implemented withdraw, checks the new feature of this class ( Minimum available balance)
    @Override
    public void withdraw(double amount) throws IllegalBalance {

            if (!this.isAmountAvaileableToWithraw(amount)){
                throw new IllegalBalance("EXCEPTION! exceeding illegal balance! Cannot go under "+ this.getMinBalanceAvailable());
            }

        super.withdraw(amount);
    }


//---------------------------------------------------------------------------------------------------------------------
    // A new implemented write check, checks the new feature of this class ( Minimum available balance)
    @Override
    public void writeCheck(double amount)throws IllegalBalance{

        System.out.println("An attempt of a check of " + amount + "$ has been written");
        if (!this.isAmountAvaileableToWithraw(amount)){
            throw new IllegalBalance("EXCEPTION! exceeding illegal balance! Cannot go under "+ this.getMinBalanceAvailable());
        }
        super.withdraw(amount);
}
//----------------------------------------------------------------------------------------------------------------------
    //  Implement of the abstract method monthly management, it does nothing for this type of account
    @Override
    public void monthlyManagement() {
        System.out.println("Mr\\Ms "+ (super.getAccountOwnerName()) +"'s account has no monthly fee!");
    }

//----------------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "No Service Charge Checking Details{" +
                "Min Balance Available=" + this.getMinBalanceAvailable() +
                "$}" + super.toString();
    }

    //----------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof NoServiceChargeChecking)) return false;
        if (!super.equals(o)) return false;
        NoServiceChargeChecking that = (NoServiceChargeChecking) o;
        return Double.compare(this.getMinBalanceAvailable(),that.getMinBalanceAvailable()) == 0;

    }
//----------------------------------------------------------------------------------------------------------------------
    // checks if an amount is available to withdrawn\writecheck and does not going under the minimum available
    private boolean isAmountAvaileableToWithraw(double amount ){
        amount = super.balanceFormat(amount);

        if ((this.getBalance() - amount) < this.getMinBalanceAvailable()){
            return false;
        }
        return true;

    }

//----------------------------------------------------------------------------------------------------------------------

    // Getters!
    private double getDefaultMinAvailable() {
        return DEFAULT_MIN_BALANCE_AVAILABLE;
    }

    public double getMinBalanceAvailable() {
        return this.getMinBalanceAvailableDecider();
    }

    private double getMinBalanceAvailableDecider(){
        if(this.minBalanceAvailable == 0){
            return this.getDefaultMinAvailable();
        }
        return this.minBalanceAvailable;
    }
//----------------------------------------------------------------------------------------------------------------------

    // Setter!
    public void setMinBalanceAvailable(double minBalanceAvailable) {
        this.minBalanceAvailable = minBalanceAvailable;
    }

//----------------------------------------------------------------------------------------------------------------------
}
