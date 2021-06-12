public class InterestChecking extends NoServiceChargeChecking{

    private final double DEFAULT_MIN_BALANCE_AVAILABLE = 30;
    private final double DEFAULT_INTERESET = 0.005;
    private double interest = 0;


//----------------------------------------------------------------------------------------------------------------------
    // Ctor
    public InterestChecking(String accountOwnerName, String bankIdNumber, String idNumber, double balance) {
            super(accountOwnerName, bankIdNumber,idNumber, balance);
            super.setMinBalanceAvailable(this.DEFAULT_MIN_BALANCE_AVAILABLE);
    }
//----------------------------------------------------------------------------------------------------------------------
    // Ctor with interest
    public InterestChecking(String accountOwnerName, String bankIdNumber, String idNumber, double balance, double interest) {
        super(accountOwnerName, bankIdNumber, idNumber, balance);
        super.setMinBalanceAvailable(this.DEFAULT_MIN_BALANCE_AVAILABLE);
        this.interest = interest/super.getPerOffset();
    }
//----------------------------------------------------------------------------------------------------------------------

    // implement of the abstract method monthly management, grants the account the monthly interest
    @Override
    public void monthlyManagement() {
        System.out.println(this.computeInterest() + "$ have been added to the account due to monthly interest ("
                + getInterest()*super.getPerOffset() + "%)");
        super.deposit(this.computeInterest());
    }

//----------------------------------------------------------------------------------------------------------------------

    // Computes the interest
    public double computeInterest(){
        return (super.getBalance() * this.getInterest());
    }
//----------------------------------------------------------------------------------------------------------------------

    @Override
    public boolean equals(Object o){
        if (this == o)return true;
        if (o == null || !( o instanceof InterestChecking)) return false;
        if (!super.equals(o)) return false;
        InterestChecking that = (InterestChecking) o;
        return Double.compare(this.getInterest(), that.getInterest()) == 0;
    }

//----------------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Interest Checking Account Details{" +
                "Interest=" + this.getInterest()*super.getPerOffset() +
                "%}" + super.toString();
    }

//----------------------------------------------------------------------------------------------------------------------

    // Getters!
    public double getInterest (){
        return this.getInterestDecider();
    }

    private double getDefaultInterest(){
        return this.DEFAULT_INTERESET;
    }

    private double getInterestDecider(){
        if (this.interest == 0){
            return this.getDefaultInterest();
        }
        return this.interest;
    }
//----------------------------------------------------------------------------------------------------------------------
}
