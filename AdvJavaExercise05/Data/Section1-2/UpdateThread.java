import java.util.List;
import java.util.Random;

public class UpdateThread extends Thread {
    /*
    This class represent the updater thread
     */

    private Random rand;
    private List<Data> dataList;

    private final int RAND_FACTOR_BOUND = 2;
    private final int RAND_PAIR_NUMBERS_BOUND = 10;
    private final int SLEEP_OFFSET = 1000;

//----------------------------------------------------------------------------------------------------------------------
    // C-tor

    public UpdateThread(String threadName, List<Data> dataList){
        super(threadName);

        rand = new Random();
        this.dataList = dataList;
        createTenRandomPairs();
    }
//----------------------------------------------------------------------------------------------------------------------
    // Creates random 10 pairs(x and y values for the Data objects)

    private void createTenRandomPairs(){
        int i = 0 ;

        while (i < RAND_PAIR_NUMBERS_BOUND ){
        int factor1 = (rand.nextInt(RAND_FACTOR_BOUND) > 0 ? 1 : -1);
        int factor2 = (rand.nextInt(RAND_FACTOR_BOUND) > 0 ? 1 : -1);
        dataList.add(new Data(rand.nextInt(RAND_PAIR_NUMBERS_BOUND)*factor1,rand.nextInt(RAND_PAIR_NUMBERS_BOUND)*factor2));
        i++;
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    // Overriding the run method

    public void run(){
        super.run();
        int i = 0 ;
        while (i < RAND_PAIR_NUMBERS_BOUND){
            int dx = rand.nextInt(RAND_PAIR_NUMBERS_BOUND)*rand.nextInt(RAND_FACTOR_BOUND) > 0 ? 1 : -1;
            int dy = rand.nextInt(RAND_PAIR_NUMBERS_BOUND)*rand.nextInt(RAND_FACTOR_BOUND) > 0 ? 1 : -1;
            dataList.get(i).update(dx,dy);
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
