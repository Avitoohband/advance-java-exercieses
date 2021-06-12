import java.util.*;

public class SortedGroup<T extends Comparable<T>> {
    /*
    This class represent the SortedGroup object
    the group holds array of a generic instance which have implemented the Comparable interface,
    sorts it in ascending order
     */


    private ArrayList<T> collection;


    public SortedGroup() {
        collection = new ArrayList<T>();
    }

//----------------------------------------------------------------------------------------------------------------------
    // Adds new object to the array, keeping its ascending order
    // by using compareTo method

    public void add(T ob) {

        for (int i = 0; i < collection.size(); i++) {
            if (ob.compareTo(collection.get(i)) <= 0) {
                collection.add(i, ob);
                return;
            }
        }
        collection.add(ob);
    }

//----------------------------------------------------------------------------------------------------------------------
    // Gets an object and removes all of its occurrences in the array
    // returns how many objects have been removed

    public int remove(T ob) {

        Collection<T> toBeRemoved = new ArrayList<T>();

        for (T element : collection) {
            if (ob.equals(element)) {
                toBeRemoved.add(element);
            }
        }

        collection.removeAll(toBeRemoved);

        return toBeRemoved.size();
    }

//----------------------------------------------------------------------------------------------------------------------
    // Calls toString method for every object in the array

    @Override
    public String toString() {
        String str = "";
        for (T element : collection)
            str += element;
        return str;
    }

//---------------------------------------------------------------------------------------------------------------------
    // Forwarding the iterator method to returns iterator

    public Iterator<T> iterator() {
        return collection.iterator();
    }
}
