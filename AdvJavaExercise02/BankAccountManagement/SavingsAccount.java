public class SavingsAccount extends BankAccount{

    private final double DEFAULT_INTERESET = 0.005;
    private double interest = 0;
//----------------------------------------------------------------------------------------------------------------------

    // Ctor
    public SavingsAccount(String accountOwnerName, String bankIdNumber, String idNumber, double balance) {
        super(accountOwnerName, bankIdNumber, idNumber, balance);
    }
//----------------------------------------------------------------------------------------------------------------------

    // Ctor with interest
    public SavingsAccount(String accountOwnerName, String bankIdNumber, String idNumber, double balance, double interest) {
        super(accountOwnerName, bankIdNumber, idNumber, balance);
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

    @Override
    public String toString() {
        return "Savings Account Details{" +
                "Interest=" + getInterest()*super.getPerOffset() +
               "%}" + super.toString();
    }

//----------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean equals(Object o){
        if (this == o)return true;
        if (o == null || !( o instanceof SavingsAccount)) return false;
        if (!super.equals(o)) return false;
        SavingsAccount that = (SavingsAccount) o;
        return Double.compare(this.getInterest(), that.getInterest()) == 0;
    }
//----------------------------------------------------------------------------------------------------------------------

    // Computes the interest
    public double computeInterest(){
        return (super.getBalance() * this.getInterest());
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

    //Setter!
    public void setInterest(double interest){
        this.interest = interest;
    }
//----------------------------------------------------------------------------------------------------------------------
}
