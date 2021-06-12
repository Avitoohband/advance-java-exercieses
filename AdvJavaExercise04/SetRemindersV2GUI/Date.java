
public class Date {

    /*
    This class represent the Date object
     */

    int day;
    int month;
    int year;

//----------------------------------------------------------------------------------------------------------------------
    // Ctor

    public Date(int day, int month, int year){

        this.day = day;
        this.month = month;
        this.year = year;

    }
//----------------------------------------------------------------------------------------------------------------------
    // Overriding equlas method to compare by day, month and year
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Date)) return false;
        Date date = (Date) o;
        return day == date.day &&
                month == date.month &&
                year == date.year;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Overrind hashCode method to return hashcode by day, month and year
    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = prime * result + day;
        result = prime * result + month;
        result = prime * result + year;

        return result;

    }
//----------------------------------------------------------------------------------------------------------------------
    // Overriding toString method

    public String toString(){
        return String.format("%d %d %d\n",day,month,year);
    }
//----------------------------------------------------------------------------------------------------------------------

}
