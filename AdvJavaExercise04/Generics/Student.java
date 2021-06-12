import java.util.Random;

public class Student implements Comparable<Student> {

    /*
    This class represent the student object
     */


    private String name;
    private String id;
    private int grade;

    private final int GRAGE = 100;
    private final int GRAGE_OFFSET = 1; // to add to the random method

//----------------------------------------------------------------------------------------------------------------------
    // Ctor

    public Student(String name, String id) {
        Random rand = new Random();
        this.name = name;
        this.id = id;
        this.grade = rand.nextInt(GRAGE) + GRAGE_OFFSET; // generate random grade in range of  (1 - 100)

    }
//----------------------------------------------------------------------------------------------------------------------
    // Ctor with grade declaration

    public Student(String name, String id, int grade) {
        Random rand = new Random();
        this.name = name;
        this.id = id;
        this.grade = grade;

    }
//----------------------------------------------------------------------------------------------------------------------
    // Overriding the compareTo method, comparing by grade

    @Override
    public int compareTo(Student stu) {

        if(grade > stu.grade) return 1;
        if(grade < stu.grade) return -1;
        return 0;
    }

//----------------------------------------------------------------------------------------------------------------------
    // Overriding the equals method,
    // checks by name and id

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Student)) return false;
        Student student = (Student) o;
        return name.equals(student.getName()) &&
               id.equals(student.getId());
    }

//----------------------------------------------------------------------------------------------------------------------
    // Returns string that represent the student object,
    // name , id  and grade
    // have fixed spaces and lineups for more convenience reading


    @Override
    public String toString() {
        String nm = String.format("Name={%s}", name);
        String id = String.format("ID={%s}", this.id);
        String grd = String.format("Grade={%s}", grade);

        return String.format("|%-26s|   |%-15s|    |%s|\n", nm , id, grd);
    }
//----------------------------------------------------------------------------------------------------------------------

    // Getters!

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
//----------------------------------------------------------------------------------------------------------------------

}
