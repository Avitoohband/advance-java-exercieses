public class BankAccount {
    /*
    This class represent the bank accounts, hold its ID and Balance
     */

    private int accountID;
    private int balance;


//----------------------------------------------------------------------------------------------------------------------
    // C-tor

    public BankAccount(int bankId, int newBalance){
        accountID = bankId;
        balance = newBalance;

    }
//----------------------------------------------------------------------------------------------------------------------
    // Manages the both positive or negative transaction preventing concurrency so the every action is updated before
    // next one is taking place.
    // Also preventing a overdrawn balance scenario
    public synchronized void transaction(int amount ){
        System.out.println(Thread.currentThread().getName() + "| is attempting to make a transaction");
        if (amount >=0){
            System.out.println(Thread.currentThread().getName() + "| is depositing money into account: " + accountID);
            deposit(amount);
            System.out.format(Thread.currentThread().getName() +"| Deposited %d into account: %d\n", amount , accountID);
        }
        else{
            System.out.println(Thread.currentThread().getName() + "| is attempting to make a withdraw for account : " + accountID);

           while(balance - amount < 0 ){
                try {
                    System.out.println("Please deposit some money first");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "| is withdrawing money from account: " + accountID);
            deposit(amount);
            System.out.format(Thread.currentThread().getName() +"| made a Withdrawn of %d from account: %d\n", amount, accountID);

        }
    }
//----------------------------------------------------------------------------------------------------------------------
    //

    private synchronized void deposit(int amount){
        balance += amount;
        notifyAll();
    }
//----------------------------------------------------------------------------------------------------------------------
    public String toString(){
        return String.format("| Account ID: %s|Balance: %d",accountID , balance);
    }
//----------------------------------------------------------------------------------------------------------------------

    public int getBalance() {
        return balance;
    }
}
