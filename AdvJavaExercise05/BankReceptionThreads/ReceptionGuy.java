import java.util.List;
import java.util.Random;

public class ReceptionGuy extends Thread{
    /*
    This class represent a Reception guy, working as a thread.
     */

    private TransactionsDatabase transDB;
    private List<BankAccount> bankAccounts;
    private String name;

    private final int REST_TIME = 101;
//----------------------------------------------------------------------------------------------------------------------
    // C-tor

    public ReceptionGuy(String threadName , TransactionsDatabase tdb, List<BankAccount> bAccounts){
        super(threadName);

        name = threadName;
        transDB = tdb;
        bankAccounts = bAccounts;

    }
//----------------------------------------------------------------------------------------------------------------------
    // Run method, gets a action for the transaction
    // when receiving null it stops

    @Override
    public void run() {

        Random rand  = new Random();
        Transaction temp = transDB.getTransation();

        while (temp != null){

            int bankID = temp.getBankIdNumber();
            int amount = temp.getAmount();

            bankAccounts.get(bankID).transaction(amount);
            System.out.println(name + bankAccounts.get(bankID));


            try {
                Thread.sleep(rand.nextInt(REST_TIME));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            temp = transDB.getTransation();
        }

    }
//----------------------------------------------------------------------------------------------------------------------
}
