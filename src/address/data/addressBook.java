package address.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * addressBook is a class that creates a list of address entries and adds new entries
 */
public class addressBook {
    // Create user input
    Scanner myObj = new Scanner(System.in);

    /**
     * Collection variable that stores a set of AddressEntry objects that are currently in addressBook
     **/
    private final ArrayList<addressEntry> addressEntryList = new ArrayList<>();

    /**
     * Reads a file into the address book
     *
     * @param fileName file to be read
     * @param ab address book to add entries into
     * @throws IOException if file not found
     **/
    public static void readFromFile(String fileName, addressBook ab) throws IOException {
        // Create a file reader
        FileReader file_input = new FileReader(fileName);
        // Create a buffered reader
        BufferedReader br = new BufferedReader(file_input);

        // If buffered reader is ready to read, create a new addressEntry and add to address book
        while (br.ready()) {
            // Create a new instance of addressEntry and add data from text file
            addressEntry fileEntry = new addressEntry(br.readLine(), br.readLine(), br.readLine(),
                    br.readLine(), br.readLine(), Integer.parseInt(br.readLine()), br.readLine(), br.readLine());
            // Add addressEntry to current address book
            ab.add(fileEntry);
        }

        // Close BufferedReader
        br.close();
        // Close FileReader
        file_input.close();
        // Display file read successfully
        System.out.println("File read successfully!\n");
    }

    /**
     * Adds a new entry to AddressEntryList
     * @param newEntry new entry to add to the list
     */
    public void add(addressEntry newEntry) {
        addressEntryList.add(newEntry);
    }

    /**
     * Removes an entry from the address book
     * @param delEntry entry to be removd from the list
     **/
    public void removal(String delEntry) {
        // Check if the list is empty
        if (addressEntryList.isEmpty()) {
            // Notify user that list is empty
            System.out.println("Address book is currently empty.\n");
        }
        else {
            // Create flag to return to menu
            boolean removeEntry = true;

            while (removeEntry) {
                // Create variable for entry to be removed
                addressEntry entryToBeRemoved = new addressEntry();
                // Iterate through the list
                for (address.data.addressEntry addressEntry : addressEntryList) {
                    // If the last names of the entries match the user entry
                    if (addressEntry.getLastName().equals(delEntry)) {
                        //
                        entryToBeRemoved = addressEntry;
                    }
                }
                // Notify user this is the entry found
                System.out.println("The following entry was found in the address book: ");
                // Display entry to be removed
                System.out.println(entryToBeRemoved);
                // Notify user if they want this entry to be removed
                System.out.println("'y' to remove entry or 'n' to return to main menu");
                // User inputs character
                char choice = myObj.next().charAt(0);

                switch (choice) {
                    case 'y': // If 'y', remove entry
                        addressEntryList.remove(entryToBeRemoved);
                    case 'n': // If 'n', return to menu
                        removeEntry = false;
                        break;
                    default:
                        System.out.println("Please choose y or n.");
                }
            }
        }
    }

    /**
     * Finds an entry in the list by last name
     * @param searchEntry entry (or entries) to be found by last name
     **/
    public void find(String searchEntry) {
        // Check if the list is empty
        if (addressEntryList.isEmpty()) {
            // Notify user that list is empty
            System.out.println("Address book is currently empty.\n");
        }
        else {
            // Iterate through the list
            for (address.data.addressEntry addressEntry : addressEntryList) {
                // If the last names of the entries match the user entry
                if (addressEntry.getLastName().contains(searchEntry)) {
                    // Print the entries
                    System.out.print(addressEntry);
                }
            }
        }
    }

    /**
     * Goes through AddressEntryList and print all entries in list
     **/
    public void list() {
        // Check if the list is empty
        if (addressEntryList.isEmpty()) {
            // Notify user that list is empty
            System.out.println("Address book is currently empty.\n");
        }
        // Otherwise, display list
        else {
            for (address.data.addressEntry addressEntry : addressEntryList) {
                System.out.print(addressEntry);
            }
        }
    }
}
