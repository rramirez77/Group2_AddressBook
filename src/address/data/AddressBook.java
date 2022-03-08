package address.data;

import java.io.InputStreamReader;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;

public class AddressBook {
    /**
     * Primary structure holding data values.
     * Keyed by LastName + First + Phone, last name in lower case.
     * Reduces data loss by having people of similar name.
     */
    // Could be further reduced via complex array-based entry storage and repeat checks.
    // Does introduce potential searching errors when people go beyond an individual's last name.

    private SortedMap<String, AddressEntry> addressEntries = new TreeMap<String, AddressEntry>();

    public SortedMap<String, AddressEntry> getData(){
        return addressEntries;
    }

    /**
     * prints out all values stored.
     */
    public void list(){
        for(AddressEntry a: addressEntries.values()){
            System.out.println(a.toString());
        }
    }

    public String list2(){
        String s = "";
        for(AddressEntry a: addressEntries.values()){
            s += a.toString() + "\n";
        }
        return s;
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
        addressEntries.put(entry.getLast().toLowerCase() + entry.getFirst() + entry.getPhone(), entry);
    }



    /**
     * @param s
     * @throws IOException
     * search and remove entry with last name starting with input string s.
     */
    public void remove(String s) throws IOException {
        //removal is more complex than find, so we aren't just calling find. we need to number the entries etc.
        s = s.toLowerCase();
        ArrayList<String> found = new ArrayList<String>();
        int counter = 0;
        for(String a: addressEntries.keySet()){
            if(a.startsWith(s)){
                if(addressEntries.get(a).getLast().toLowerCase().startsWith(s)) { // extra validation as keys contain more than only last name.
                    found.add(a);
                    System.out.println(++counter + "): ");
                    System.out.println(addressEntries.get(a).toString());
                }
            }
        }
        if(counter == 0){
            System.out.println("No entries for that name could be found.");
            return;
        }
        System.out.print("Confirm number of entry to remove: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        if(counter >= 0 && x <= counter){
            addressEntries.remove(found.get(x-1)); // listing starts at 1 for human readability
            System.out.println("Entry removed.");
        }else{
            System.out.println("User could not be found.");
        }

    }

    /**
     * @param s
     * find and print all entries with last name starting with s.
     */
    public void find(String s){
        s = s.toLowerCase();
        for(String a: addressEntries.keySet()){
            if(a.startsWith(s)){
                if(addressEntries.get(a).getLast().toLowerCase().startsWith(s)) { // extra validation as keys contain more than only last name.
                    System.out.println(addressEntries.get(a).toString());
                }
            }
        }
    }
}
