import java.util.Random;

public class UpdateThread extends Thread {
    /*
    This class represent the updater thread
     */

    private Random rand;
    private Data data;

    private final int RAND_FACTOR_BOUND = 2;
    private final int RAND_PAIR_NUMBERS_BOUND = 10;
    private final int SLEEP_OFFSET = 100;

//----------------------------------------------------------------------------------------------------------------------
    // C-tor

    public UpdateThread(String threadName,Data data){
        super(threadName);

        rand = new Random();
        this.data = data;
    }

//----------------------------------------------------------------------------------------------------------------------
    // Overriding the run method

    public void run(){
        super.run();
        int i = 0 ;
        while (i < RAND_PAIR_NUMBERS_BOUND){
            int dx = rand.nextInt(RAND_PAIR_NUMBERS_BOUND)*rand.nextInt(RAND_FACTOR_BOUND) > 0 ? 1 : -1;
            int dy = rand.nextInt(RAND_PAIR_NUMBERS_BOUND)*rand.nextInt(RAND_FACTOR_BOUND) > 0 ? 1 : -1;
            data.update(dx,dy);
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
