import java.util.*;

public class TransactionsDatabase {
    /*
    Represent the Transaction DataBase
     */

    private List<Transaction> transList;

    private final int FIRST_PLACE = 0;

//----------------------------------------------------------------------------------------------------------------------
    // C-tor

    public TransactionsDatabase(List<Transaction> transList) {
        this.transList = transList;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns a transaction from the list, if the list is empty returns null

    public Transaction getTransation() {
        if (transList.size() != 0 ){
            Transaction temp = transList.get(FIRST_PLACE);
            removeTransaction(temp);
            return temp;
        }
        return null;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Overriding toString method

    public String toString(){
        return transList.toString();
    }
//----------------------------------------------------------------------------------------------------------------------
    // Removes a certain record from the list

    private void removeTransaction(Transaction trans){
        transList.remove(trans);
    }
}
