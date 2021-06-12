public class ServiceChargeChecking extends CheckingAccount{
    private  final double DEFAULT_FEE = 0.005;
    private double fee = 0;

//----------------------------------------------------------------------------------------------------------------------
    //Ctor
    public ServiceChargeChecking(String accountOwnerName, String bankIdNumber, String idNumber, double balance) {
        super(accountOwnerName, bankIdNumber, idNumber, balance);
    }
//----------------------------------------------------------------------------------------------------------------------
    //Ctor with fee
    public ServiceChargeChecking(String accountOwnerName, String bankIdNumber, String idNumber, double balance, double fee) {
        super(accountOwnerName, bankIdNumber, idNumber, balance);
        this.setFee(fee/super.getPerOffset());
    }

//----------------------------------------------------------------------------------------------------------------------
    // Charges the account by the declared fee
    @Override
    public void monthlyManagement() {

        double feeToCharge = super.balanceFormat(super.getBalance() * this.getFee());
        System.out.print(this.getFee()*this.getPerOffset() + "% have been charged from Mr\\Ms"+super.getAccountOwnerName() +" account due to monthly fee");
        super.setBalance(super.getBalance() - feeToCharge);
        System.out.println("("+ feeToCharge +"$)");
    }
//----------------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Service Charge Checking Details{" +
                "Fee=" + this.getFee()*super.getPerOffset() +
                "%}" + super.toString();
    }

//----------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof ServiceChargeChecking)) return false;
        if (!super.equals(o)) return false;
        ServiceChargeChecking that = (ServiceChargeChecking) o;
        return Double.compare(this.getFee(),that.getFee()) == 0;

    }
//----------------------------------------------------------------------------------------------------------------------

    // Getters!
    public double getFee() {
        return this.getFeeDecider();
    }

    private double getDefaultFee() {
        return DEFAULT_FEE;
    }
    // Checks and returns fee if fee is initiated, otherwise returns the default fee
    private double getFeeDecider(){
        if (this.fee == 0){
            return getDefaultFee();
        }
        return this.fee;
    }
//----------------------------------------------------------------------------------------------------------------------

    // Setter!
    public void setFee(double fee) {
        fee = super.balanceFormat(fee);
        this.fee = fee;
    }
//----------------------------------------------------------------------------------------------------------------------
}
