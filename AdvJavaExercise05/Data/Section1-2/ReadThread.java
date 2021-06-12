import java.util.List;

public class ReadThread extends Thread {
    /*
    This class represent the reader thread
     */

    List<Data> dataList;

    private final int NUM_OF_ACTIONS = 10;
    private final int SLEEP_OFFSET = 1000;

//----------------------------------------------------------------------------------------------------------------------
    // C-tor

    public ReadThread(String threadName, List<Data> dataList){
        super(threadName);

        this.dataList = dataList;

    }
//----------------------------------------------------------------------------------------------------------------------
    // Overriding the run method

    public void run(){
        super.run();
        int i = 0;
        while(i < NUM_OF_ACTIONS){
            System.out.println(dataList.get(i).getDiff());
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
