
public class ExchangeRate {
    /*
    This class represent the exchanges tables
     */

    private final int SHEKEL = 1;
    private final int DOLLAR = 2;
    private final int EUR = 3;

    private final double SHEKEL_TO_EUR = 0.253;
    private final double SHEKEL_TO_DOLLAR = 0.31;

    private final double DOLLAR_TO_EUR = 0.82;
    private final double DOLLAR_TO_SHEKEL = 3.25;

    private final double EUR_TO_SHEKEL = 3.948;
    private final double EUR_TO_DOLLAR = 1.22;

    private final double SAME = 1.0;


    // Gets the currency that the user is holding and gives back the rates
    // of the exchanges to the desired type
    public double rate(int from, int to) {
        if (!areValidCurrencyNames(from, to)){
            return 0.0;
        }
        double rate = SAME;
        if (from == to){
            return rate;
        }
        switch (from) {
            case SHEKEL: {
                if (to == (EUR)) rate =  SHEKEL_TO_EUR;
                else  rate = SHEKEL_TO_DOLLAR;

                break;
            }
            case DOLLAR: {
                if (to == (SHEKEL)) rate = DOLLAR_TO_SHEKEL;
                else rate = DOLLAR_TO_EUR;

                break;
            }
            case EUR: {
                if (to == (SHEKEL)) rate = EUR_TO_SHEKEL;
                else  rate = EUR_TO_DOLLAR;

                break;
            }
        }
        return rate;
    }
    // Checks if the types of the currency that receive from the user are valid
    private boolean areValidCurrencyNames(int from, int to){
        boolean fromValid;
        boolean rightValid;
        fromValid = (from == SHEKEL || from == EUR || from == DOLLAR);
        rightValid = (to == SHEKEL || to == EUR || to == DOLLAR);
        return fromValid && rightValid;
    }
}

