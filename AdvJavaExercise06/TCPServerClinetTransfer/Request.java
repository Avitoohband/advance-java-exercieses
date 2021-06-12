import java.io.Serializable;

public class Request implements Serializable {
    /*
    This class represent the Request of the client
    amount of current cash, type, and desired type to get as exchange
     */

    private int currencyCurrentType;
    private int currencyDesiredType;
    private double customerCurrentAmount = 0 ;
    private double returningAmount = 0 ;

    public Request(double amount, int currencyCurType, int currencyDesType){
        customerCurrentAmount = amount;
        currencyCurrentType = currencyCurType;
        currencyDesiredType = currencyDesType;
    }
    // Getters
    public double getCustomerCurrentAmount() {
        return customerCurrentAmount;
    }

    public double getReturningAmount() {
        return returningAmount;
    }
    public int getCurrencyCurrentType() {
        return currencyCurrentType;
    }

    public int getCurrencyDesiredType() {
        return currencyDesiredType;
    }
    // Setter
    public void setReturningAmount(double returningAmount) {
        this.returningAmount = returningAmount;
    }
}
