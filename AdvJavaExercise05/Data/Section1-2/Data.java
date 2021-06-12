
public class Data{
    /*
    This class represent the Data object, it holds pair of value
    x and y adn the options to update those value, or get the diff between them
     */

    private int x;
    private int y;

    private boolean isUpdateTurn = true;


//----------------------------------------------------------------------------------------------------------------------
    // C-tor

    public Data (int x, int y){
        this.x = x;
        this.y = y;
    }

//----------------------------------------------------------------------------------------------------------------------
    // Returns the difference between x and y

    public synchronized int getDiff(){

        while (isUpdateTurn){ // checks if its "My Turn"
            try {
                wait(); // if not , wait
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        changeTurns();
        System.out.format("%s is getting the diff:    ", Thread.currentThread().getName());
        return (Math.abs(x - y));
    }
//----------------------------------------------------------------------------------------------------------------------
    // Updates the pair with new values

    public synchronized void update(int dx, int dy){
        while(!isUpdateTurn){ // checks if its "My Turn"
            try {
                wait(); // if not , wait
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.format("%s is updating the pair: ", Thread.currentThread().getName());
        x = x + dx;
        y = y + dy;
        printData();
        changeTurns();
    }
//----------------------------------------------------------------------------------------------------------------------
    // Changes turns and wake up whoever are waits

    private  synchronized void changeTurns(){
        isUpdateTurn = !isUpdateTurn;
        notifyAll();
    }

//----------------------------------------------------------------------------------------------------------------------
    // Prints the values of x and y

    public void printData(){
        System.out.format("( %-2d,%-2d )   \n", x, y);
    }
}
