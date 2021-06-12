public class HighInterestSavings extends SavingsAccount{

    private final double DEFAULT_INTERESET = 0.01;
    private final double DEFAULT_MIN_BALANCE_AVAILABLE = 14.70;
    private  double minBalanceAvailable = 0 ;

//----------------------------------------------------------------------------------------------------------------------
    // Ctor
    public HighInterestSavings(String accountOwnerName, String bankIdNumber, String idNumber, double balance) {
        super(accountOwnerName, bankIdNumber, idNumber, balance);
        super.setInterest(this.DEFAULT_INTERESET);

    }
//----------------------------------------------------------------------------------------------------------------------
    // Ctor with interest and minimum availables
    public HighInterestSavings(String accountOwnerName, String bankIdNumber, String idNumber, double balance, double interest,double minAvailable) {
        super(accountOwnerName, bankIdNumber, idNumber, balance, interest);
        super.setInterest(interest/super.getPerOffset());
        this.minBalanceAvailable = minAvailable;

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


//----------------------------------------------------------------------------------------------------------------------
    // checks if an amount is available to withdrawn\writecheck and does not going under the minimum available
    private boolean isAmountAvaileableToWithraw(double amount ){
        amount = super.balanceFormat(amount);

        if ((this.getBalance() - amount) < this.getMinBalanceAvailable()){
            return false;
        }
        return true;
    }

//---------------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "High Interest Savings Account Details{" +
                "Min Balance Available=" + this.getMinBalanceAvailable() +
                "$}" + super.toString();
    }

//----------------------------------------------------------------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof HighInterestSavings )) return false;
        if (!super.equals(o)) return false;
        HighInterestSavings that = (HighInterestSavings) o;
        return Double.compare(this.getMinBalanceAvailable(), that.getMinBalanceAvailable() )== 0;
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

    //Setter!
    public void setMinBalanceAvailable(double minBalanceAvailable) {
        this.minBalanceAvailable = minBalanceAvailable;
    }

//----------------------------------------------------------------------------------------------------------------------
}
