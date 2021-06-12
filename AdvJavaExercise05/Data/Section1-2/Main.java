import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        List<Data> dataList = new ArrayList<Data>();
        UpdateThread uptTrd = new UpdateThread("Danny", dataList);
        ReadThread rdTrd = new ReadThread("Danna", dataList);

        System.out.println("  _____       _ _   _       _   _            __      __   _                 \n" +
                " |_   _|     (_) | (_)     | | (_)           \\ \\    / /  | |                \n" +
                "   | |  _ __  _| |_ _  __ _| |_ ___   _____   \\ \\  / /_ _| |_   _  ___  ___ \n" +
                "   | | | '_ \\| | __| |/ _` | __| \\ \\ / / _ \\   \\ \\/ / _` | | | | |/ _ \\/ __|\n" +
                "  _| |_| | | | | |_| | (_| | |_| |\\ V /  __/    \\  / (_| | | |_| |  __/\\__ \\\n" +
                " |_____|_| |_|_|\\__|_|\\__,_|\\__|_| \\_/ \\___|     \\/ \\__,_|_|\\__,_|\\___||___/\n" +
                "                                                                            \n" +
                "                                                                            ");

        for (Data item : dataList) {
            item.printData();
        }

        System.out.println("  _______ _                        _        _____ _             _         \n" +
                " |__   __| |                      | |      / ____| |           | |      _ \n" +
                "    | |  | |__  _ __ ___  __ _  __| |___  | (___ | |_ __ _ _ __| |_ ___(_)\n" +
                "    | |  | '_ \\| '__/ _ \\/ _` |/ _` / __|  \\___ \\| __/ _` | '__| __/ __|  \n" +
                "    | |  | | | | | |  __/ (_| | (_| \\__ \\  ____) | || (_| | |  | |_\\__ \\_ \n" +
                "    |_|  |_| |_|_|  \\___|\\__,_|\\__,_|___/ |_____/ \\__\\__,_|_|   \\__|___(_)\n" +
                "                                                                          \n" +
                "                                                                          ");
        uptTrd.start();
        rdTrd.start();

    }
}
