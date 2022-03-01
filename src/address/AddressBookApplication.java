package address;

import address.data.addressBook;
import address.data.addressEntry;

import java.util.Scanner;


/**
 * AddressBookApplication is a main application class that creates and stores entries in an address book
 *
 * @author Romano Ramirez
 * @since Version 1.0
 **/
public class AddressBookApplication {

    /**
     * Main method
     * @param args String inputs
     */
    public static void main(String[] args) {
        // Create user input
        Scanner myObj = new Scanner(System.in);

        // Create instance of address book
        addressBook ab = new addressBook();

        // Create instance of menu
        Menu myMenu = new Menu();

        while (true) {
            // Display menu
            System.out.print(myMenu.displayMenu());

            // Prompt user to make a selection
            System.out.print("Please make a selection: ");

            // String input for menu selection
            String choice = myObj.nextLine();

            switch (choice) {
                case "a" -> { // Load an entry (or entries) from file

                    // Create flag to re-prompt user if an error occurs
                    boolean FileNotFound = true;
                    while (FileNotFound) {
                        // Prompt user to enter file name
                        System.out.print("Enter in File name: ");
                        try {
                            // Input file name
                            String fileName = myObj.nextLine();

                            // Read from file
                            addressBook.readFromFile(fileName, ab);

                            // Exit loop
                            FileNotFound = false;

                        } catch (Exception IOException) {
                            // Prompt user that file was not found
                            System.out.println("File not found.\n");
                        }
                    }
                }
                // Back to menu
                case "b" -> { // Add an entry
                    // Create addressEntry object
                    addressEntry entry;

                    // User information is used to create address entry
                    entry = new addressEntry(myMenu.prompt_FirstName(), myMenu.prompt_LastName(), myMenu.prompt_Street(),
                            myMenu.prompt_City(), myMenu.prompt_State(), myMenu.prompt_Zip(), myMenu.prompt_Telephone(), myMenu.prompt_Email());

                    // Add address entry into address book
                    ab.add(entry);

                    // Notify user that entry was added into address book
                    System.out.println("\nEntry added into address book.\n");
                }

                // Back to menu
                case "c" -> { // Remove an entry
                    // Prompt user to type last name of the entry
                    System.out.println("Type last name of the entry to be deleted: ");

                    // Input last name
                    String delLastName = myObj.nextLine();

                    // Find and remove entry via last name
                    ab.removal(delLastName);
                }

                // Back to menu
                case "d" -> { // Find an entry by last name
                    // Prompt user to type all or beginning last name of the entry
                    System.out.println("Type all or beginning of last name of the entry: ");

                    // Input last name
                    String findLastName = myObj.nextLine();

                    // Find entry (or entries) via last name
                    ab.find(findLastName);
                }

                // Back to menu
                case "e" -> // Display all entries in the address book
                        ab.list();


                // Back to menu
                case "f" -> { // Quit program
                    System.out.println("Quitting.");
                    System.exit(0);
                }
                default ->
                        // Notify user if they made an incorrect input
                        System.out.println("Incorrect input. Please try again.");
            }
        }
    }
}
