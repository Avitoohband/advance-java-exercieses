
public class ReadThread extends Thread {
    /*
    This class represent the reader thread
     */

    Data data;

    private final int NUM_OF_ACTIONS = 10;
    private final int SLEEP_OFFSET = 100;

//----------------------------------------------------------------------------------------------------------------------
    // C-tor

    public ReadThread(String threadName, Data data){
        super(threadName);

        this.data = data;

    }
//----------------------------------------------------------------------------------------------------------------------
    // Overriding the run method

    public void run(){
        super.run();
        int i = 0;
        while(i < NUM_OF_ACTIONS){
            System.out.println(data.getDiff());
            i++;
            try {
                sleep(SLEEP_OFFSET);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------

}
