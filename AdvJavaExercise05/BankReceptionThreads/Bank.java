import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bank{

    /*
    This class represent the bank, hold the Threads, Transactions Data Base and Bank Accounts information
     */

    private List<ReceptionGuy> receptions;
    private List<BankAccount> bankAccounts;
    private TransactionsDatabase transDB;

    private final int NUM_OF_THREADS = 10;
    private final int NUM_OF_TRANSACTIONS = 20;
    private final int NUM_OF_BACCOUNTS = 5;
    private final int MAX_AMOUNTS = 1001;
//----------------------------------------------------------------------------------------------------------------------
    // C-tor

    public Bank(){
        initializeAccounts();
        initializeTransDB();
        initializeReceptions();

    }
//----------------------------------------------------------------------------------------------------------------------
    // Initialize the transaction data base


    private void initializeTransDB() {
        Random rand = new Random();
        List<Transaction> transList = new ArrayList<Transaction>();
        int i = 0;
        while (i < NUM_OF_TRANSACTIONS){ // for each account of the 5
            for (int j = 0 ; j <NUM_OF_BACCOUNTS ; j++){
                int factor = (rand.nextInt(5) > 1 ? 1 : -1); // ratio of 3:2 positive to negative transactions(to prevent deadlock)
                transList.add(new Transaction(j++, rand.nextInt(MAX_AMOUNTS) * factor));
            }
            i++;
        }

        transDB = new TransactionsDatabase(transList);
    }
//----------------------------------------------------------------------------------------------------------------------
    // Initialize the threads(Receptions)

    private void initializeReceptions() {
        receptions = new ArrayList<ReceptionGuy>();

        int i = 0 ;
        while(i < NUM_OF_THREADS){
            String name  = "Mr.Thready_" + i;
            receptions.add(new ReceptionGuy(name, transDB, bankAccounts));
            i++;
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    // Initialize the bank acocunts list

    private void initializeAccounts() {
        bankAccounts = new ArrayList<BankAccount>();

        int i = 0 ;
        while (i < NUM_OF_BACCOUNTS){
        bankAccounts.add(new BankAccount(i++,0));
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    // Printing the lists information
    public void showGeneralInformation(){
        System.out.println("   _____                           _   _____        __                           _   _             \n" +
                "  / ____|                         | | |_   _|      / _|                         | | (_)            \n" +
                " | |  __  ___ _ __   ___ _ __ __ _| |   | |  _ __ | |_ ___  _ __ _ __ ___   __ _| |_ _  ___  _ __  \n" +
                " | | |_ |/ _ \\ '_ \\ / _ \\ '__/ _` | |   | | | '_ \\|  _/ _ \\| '__| '_ ` _ \\ / _` | __| |/ _ \\| '_ \\ \n" +
                " | |__| |  __/ | | |  __/ | | (_| | |  _| |_| | | | || (_) | |  | | | | | | (_| | |_| | (_) | | | |\n" +
                "  \\_____|\\___|_| |_|\\___|_|  \\__,_|_| |_____|_| |_|_| \\___/|_|  |_| |_| |_|\\__,_|\\__|_|\\___/|_| |_|\n" +
                "                                                                                                   \n" +
                "                                                                                                   ");
        System.out.println(receptions);
        System.out.println(bankAccounts);
        System.out.println(transDB);
    }
//----------------------------------------------------------------------------------------------------------------------
    // Start the threads(Receptions)

    public void theBankIsOpen(){
        int i = 0 ;
        System.out.println("  _____                     _   _               _                              _ \n" +
                " |  __ \\                   | | (_)             (_)                            | |\n" +
                " | |__) |___  ___ ___ _ __ | |_ _  ___  _ __    _ ___    ___  _ __   ___ _ __ | |\n" +
                " |  _  // _ \\/ __/ _ \\ '_ \\| __| |/ _ \\| '_ \\  | / __|  / _ \\| '_ \\ / _ \\ '_ \\| |\n" +
                " | | \\ \\  __/ (_|  __/ |_) | |_| | (_) | | | | | \\__ \\ | (_) | |_) |  __/ | | |_|\n" +
                " |_|  \\_\\___|\\___\\___| .__/ \\__|_|\\___/|_| |_| |_|___/  \\___/| .__/ \\___|_| |_(_)\n" +
                "                     | |                                     | |                 \n" +
                "                     |_|                                     |_|                 ");

        while(i < NUM_OF_THREADS){
            receptions.get(i++).start();
        }
    }
//----------------------------------------------------------------------------------------------------------------------
}
