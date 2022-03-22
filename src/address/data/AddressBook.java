package address.data;

import java.io.InputStreamReader;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;

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
     * @param entry
     * add formed entry to book.
     */
    public void add(AddressEntry entry){
        addressEntries.put(entry.getId(), entry);
    }

    /**
     * removes entry by key from book.
     * @param s
     */
    public void remove(String s) {
        addressEntries.remove(s);
    }

}
