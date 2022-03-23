package address.data;
import java.util.*;
/**
 * AddressBook is a class that creates an
 * address book that holds a local copy of
 * all the address entries
 * @author Andrew Zhou
 * @author Karla Villa Estrella
 * @author Romano Edwin Ramirez
 * @author Esad Hasanovic
 */
public class AddressBook {

    /**
     * Primary structure holding data values.
     * Keyed by LastName + Phone + First, last name in lower case.
     * Reduces data loss by having people of similar name.
     */
    // Could be further reduced via complex array-based entry storage and repeat checks.
    // Does introduce potential searching errors when people go beyond an individual's last name.
    private SortedMap<String, AddressEntry> addressEntries = new TreeMap<String, AddressEntry>();

    /**
     * returns map containing entry data
     * @return SortedMap<String, AddressEntry>
     */
    public SortedMap<String, AddressEntry> getData(){
        return addressEntries;
    }

    /**
     * blank constructor
     */
    public AddressBook(){}

    /**
     * add formed entry to book
     * @param entry entry
     */
    public void add(AddressEntry entry){
        addressEntries.put(entry.getId(), entry);
    }

    /**
     * removes entry by key from book.
     * @param s s
     */
    public void remove(String s) {
        addressEntries.remove(s);
    }

}
