import java.util.Iterator;

public class ReducedSortedGroup {
    /*
    This class purpose is to hold the reduce method
    for the user to use it
     */


//----------------------------------------------------------------------------------------------------------------------
    //This class gets an sortedGroup object and another objects to compare with
    // creating new group of the same instance and add only the items that
    // have value above than x has
    // return new instance with the added objects

    public static <T extends Comparable<T>> SortedGroup<T> reduce (SortedGroup<T> sGroup , T x){

        SortedGroup<T> newSGroup = new SortedGroup<T>();
        Iterator<T> iterator = sGroup.iterator();


        while (iterator.hasNext()){
            T temp = iterator.next();
            if(temp.compareTo(x) > 0)
            {
                newSGroup.add(temp);
            }
        }
        return newSGroup;
    }
//----------------------------------------------------------------------------------------------------------------------
}
