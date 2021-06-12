import java.util.concurrent.locks.*;

public class Data{
    /*
    This class represent the Data object, it holds pair of value
    x and y adn the options to update those value, or get the diff between them
     */

    private int x;
    private int y;

    private int readers = 0;
    private boolean isUpdating = false;

    private Lock lock = new ReentrantLock();
    private Condition allowUpdate = lock.newCondition();
    private Condition allowRead = lock.newCondition();


//----------------------------------------------------------------------------------------------------------------------
    // C-tor

    public Data (){
        this.x = 0;
        this.y = 0;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns the difference between x and y

    public int getDiff(){
        int diff;
        lock.lock(); // lock simultaneously access the reader counter
        try
        {
            while (isUpdating){ // checks if updating is going on
                try {
                    allowRead.await(); // if true, wait
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            readers++; // there are readers
        }
        finally {
            lock.unlock();
        }

        System.out.format("%s is getting the diff:\n", Thread.currentThread().getName());
        diff = (Math.abs(x - y)); // read

        lock.lock(); // lock simultaneously access the reader counter
        try
        {
            readers--;
            allowUpdate.signalAll(); // wake up the updater

        }
        finally {
            lock.unlock();
        }
        return diff;
    }

//----------------------------------------------------------------------------------------------------------------------
    // Updates the pair with new values

    public void update(int dx, int dy){
        lock.lock();
        try{
            while(readers > 0){ // checks if there are any readers atm
                try {
                    allowUpdate.await(); // if true , wait
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isUpdating = true;  // currently updating
            x = x + dx;
            y = y + dy;
            System.out.format("%s is updating the pair: ( %-2d,%-2d )\n", Thread.currentThread().getName(), x, y);
        }
        finally {
            isUpdating = false; // finished updating
            allowRead.signalAll(); // wake up readers
            lock.unlock();
        }
    }

//----------------------------------------------------------------------------------------------------------------------
}
