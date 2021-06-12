
public class Main {

    public static void main(String[] args) {
//----------------------------------------------------------------------------------------------------------------------
        // My Objects...

        SortedGroup<Student> studentGroup = new SortedGroup<Student>();
        SortedGroup<Student> newStdGroup;

        Student reduceStudent = new Student("Temp Student" , "000000000", 60); // to use with the reduce method
//----------------------------------------------------------------------------------------------------------------------
        // First initialize of the Students

        Student jared_watkins = new Student("Jared Watkins", "561641574");
        Student elina_delacruz = new Student("Elina Delacruz", "595531569");
        Student layton_haines = new Student("Layton Haines", "949494829");
        Student paris_cartwright = new Student("Paris Cartwright", "936779341");
        Student leona_atkins = new Student("Leona Atkins", "296453779");
        Student daanyal_fitzpatrick = new Student("Daanyal Fitzpatrick", "396464237");
        Student kyan_valenzuela = new Student("Kyan Valenzuela", "278399499");
        Student tala_chapman = new Student("Tala Chapman", "329855559");
        Student abbigail_ortega = new Student("Abbigail Ortega", "176132855");
        Student ciaron_ellison = new Student("Ciaron Ellison", "489773156");
//----------------------------------------------------------------------------------------------------------------------
        // My Code...


        studentGroup.add(jared_watkins);
        studentGroup.add(elina_delacruz);
        studentGroup.add(layton_haines);
        studentGroup.add(paris_cartwright);
        studentGroup.add(leona_atkins);
        studentGroup.add(daanyal_fitzpatrick);
        studentGroup.add(kyan_valenzuela);
        studentGroup.add(tala_chapman);
        studentGroup.add(abbigail_ortega);
        studentGroup.add(ciaron_ellison);

        System.out.println("   ____       _       _             _    _____ _             _            _      _____                       \n" +
                "  / __ \\     (_)     (_)           | |  / ____| |           | |          | |    / ____|                      \n" +
                " | |  | |_ __ _  __ _ _ _ __   __ _| | | (___ | |_ _   _  __| | ___ _ __ | |_  | |  __ _ __ ___  _   _ _ __  \n" +
                " | |  | | '__| |/ _` | | '_ \\ / _` | |  \\___ \\| __| | | |/ _` |/ _ \\ '_ \\| __| | | |_ | '__/ _ \\| | | | '_ \\ \n" +
                " | |__| | |  | | (_| | | | | | (_| | |  ____) | |_| |_| | (_| |  __/ | | | |_  | |__| | | | (_) | |_| | |_) |\n" +
                "  \\____/|_|  |_|\\__, |_|_| |_|\\__,_|_| |_____/ \\__|\\__,_|\\__,_|\\___|_| |_|\\__|  \\_____|_|  \\___/ \\__,_| .__/ \n" +
                "                 __/ |                                                                                | |    \n" +
                "                |___/                                                                                 |_|    ");
        System.out.println(studentGroup);

        studentGroup.add(new Student("Jared Watkins", "561641574"));
        studentGroup.add(new Student("Elina Delacruz", "595531569"));
        studentGroup.add(new Student("Elina Delacruz", "595531569"));
        studentGroup.add( new Student("Ciaron Ellison", "489773156"));
        studentGroup.add( new Student("Ciaron Ellison", "489773156"));
        studentGroup.add( new Student("Ciaron Ellison", "489773156"));

        System.out.println("              _     _          _    _____ _             _            _      _____                       \n" +
                "     /\\      | |   | |        | |  / ____| |           | |          | |    / ____|                      \n" +
                "    /  \\   __| | __| | ___  __| | | (___ | |_ _   _  __| | ___ _ __ | |_  | |  __ _ __ ___  _   _ _ __  \n" +
                "   / /\\ \\ / _` |/ _` |/ _ \\/ _` |  \\___ \\| __| | | |/ _` |/ _ \\ '_ \\| __| | | |_ | '__/ _ \\| | | | '_ \\ \n" +
                "  / ____ \\ (_| | (_| |  __/ (_| |  ____) | |_| |_| | (_| |  __/ | | | |_  | |__| | | | (_) | |_| | |_) |\n" +
                " /_/    \\_\\__,_|\\__,_|\\___|\\__,_| |_____/ \\__|\\__,_|\\__,_|\\___|_| |_|\\__|  \\_____|_|  \\___/ \\__,_| .__/ \n" +
                "                                                                                                 | |    \n" +
                "                                                                                                 |_|    ");
        System.out.println(studentGroup);


        System.out.println("  _____                                   _    _____ _             _            _      _____                       \n" +
                " |  __ \\                                 | |  / ____| |           | |          | |    / ____|                      \n" +
                " | |__) |___ _ __ ___   _____   _____  __| | | (___ | |_ _   _  __| | ___ _ __ | |_  | |  __ _ __ ___  _   _ _ __  \n" +
                " |  _  // _ \\ '_ ` _ \\ / _ \\ \\ / / _ \\/ _` |  \\___ \\| __| | | |/ _` |/ _ \\ '_ \\| __| | | |_ | '__/ _ \\| | | | '_ \\ \n" +
                " | | \\ \\  __/ | | | | | (_) \\ V /  __/ (_| |  ____) | |_| |_| | (_| |  __/ | | | |_  | |__| | | | (_) | |_| | |_) |\n" +
                " |_|  \\_\\___|_| |_| |_|\\___/ \\_/ \\___|\\__,_| |_____/ \\__|\\__,_|\\__,_|\\___|_| |_|\\__|  \\_____|_|  \\___/ \\__,_| .__/ \n" +
                "                                                                                                            | |    \n" +
                "                                                                                                            |_|    ");
        System.out.println("Removed " + ciaron_ellison.getName());
        System.out.println(studentGroup.remove(ciaron_ellison) + " Students have been removed\n");
        System.out.println(studentGroup);

        newStdGroup = ReducedSortedGroup.reduce(studentGroup, reduceStudent);

        System.out.println("  ____        __                 _____          _                \n" +
                " |  _ \\      / _|               |  __ \\        | |               \n" +
                " | |_) | ___| |_ ___  _ __ ___  | |__) |___  __| |_   _  ___ ___ \n" +
                " |  _ < / _ \\  _/ _ \\| '__/ _ \\ |  _  // _ \\/ _` | | | |/ __/ _ \\\n" +
                " | |_) |  __/ || (_) | | |  __/ | | \\ \\  __/ (_| | |_| | (_|  __/\n" +
                " |____/ \\___|_| \\___/|_|  \\___| |_|  \\_\\___|\\__,_|\\__,_|\\___\\___|\n" +
                "                                                                 \n" +
                "                                                                 ");

        System.out.println(studentGroup);


        System.out.println("            __ _              _____          _            \n" +
                "     /\\    / _| |            |  __ \\        | |           \n" +
                "    /  \\  | |_| |_ ___ _ __  | |__) |___  __| |_   _  ___ \n" +
                "   / /\\ \\ |  _| __/ _ \\ '__| |  _  // _ \\/ _` | | | |/ __|\n" +
                "  / ____ \\| | | ||  __/ |    | | \\ \\  __/ (_| | |_| | (__ \n" +
                " /_/    \\_\\_|  \\__\\___|_|    |_|  \\_\\___|\\__,_|\\__,_|\\___|\n" +
                "                                                          \n" +
                "                                                          ");


        System.out.println(newStdGroup);






    }
}
