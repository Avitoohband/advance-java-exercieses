public class Transaction {
    /*
    This class represent a single transaction, hold the bank id and the amount to withdraw\deposit
     */

    private int  bankIdNumber;
    private int amount;
//----------------------------------------------------------------------------------------------------------------------
    // C-tor

    public Transaction(int bankIdNumber, int amount) {
        this.bankIdNumber = bankIdNumber;
        this.amount = amount;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns the bank id number

    public int getBankIdNumber() {
        return bankIdNumber;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Overriding toString method

    public String toString(){
        return String.format("|Trans Bank ID: %d|Amount of Trans: %d|", bankIdNumber, amount);
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns the amount of the transaction

    public int getAmount() {
        return amount;
    }
}
