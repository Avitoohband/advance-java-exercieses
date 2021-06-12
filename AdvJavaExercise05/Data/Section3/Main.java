
public class Main {

    public static void main(String[] args) throws InterruptedException {

        final int NUM_OF_THREADS = 4;


       Data data = new Data();
        UpdateThread[] updateThreads = new UpdateThread[NUM_OF_THREADS];
        ReadThread[] readThreads = new ReadThread[NUM_OF_THREADS];

        for (int i = 0; i < NUM_OF_THREADS; i++) {
             updateThreads[i] = new UpdateThread("Danny_" + i , data);
             readThreads[i] = new ReadThread("Danna_" + i, data);
        }

        System.out.println("  _______ _                        _        _____ _             _         \n" +
                " |__   __| |                      | |      / ____| |           | |      _ \n" +
                "    | |  | |__  _ __ ___  __ _  __| |___  | (___ | |_ __ _ _ __| |_ ___(_)\n" +
                "    | |  | '_ \\| '__/ _ \\/ _` |/ _` / __|  \\___ \\| __/ _` | '__| __/ __|  \n" +
                "    | |  | | | | | |  __/ (_| | (_| \\__ \\  ____) | || (_| | |  | |_\\__ \\_ \n" +
                "    |_|  |_| |_|_|  \\___|\\__,_|\\__,_|___/ |_____/ \\__\\__,_|_|   \\__|___(_)\n" +
                "                                                                          \n" +
                "                                                                          ");
        for (int i = 0; i < NUM_OF_THREADS; i++) {
            updateThreads[i].start();
            readThreads[i].start();
        }

    }
}
