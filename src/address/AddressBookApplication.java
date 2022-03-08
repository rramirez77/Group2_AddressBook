package address;

import address.data.AddressBook;
import address.data.AddressEntry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class AddressBookApplication extends JPanel {
    /**
     * Contains address book information.
     */
    public static AddressBook ab = new AddressBook();;
    public static void main(String args[]) throws IOException {

        //init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ab = new AddressBook();
        Menu myMenu = new Menu();

        Menu.displayMenu();


        //br.readLine().charAt(0);//**TEST HOLDER
        /*
         * normally I would put input options into the Menu class and have passed it the addressBook for reference,
         * or put menu options into this class instead,
         * but design doc requirements say the AddressBookApplication class must "capture user input, and appropriately call appropriate methods."
         */

        //primary run operator. ends when f is input.

        char in = ' ';
        while(in != 'f'){
            System.out.print("Enter option letter: ");
            in = br.readLine().charAt(0);

            switch(in){
                case 'a':
                    System.out.print("Enter filename: ");
                    init(br.readLine());
                    break;
                case 'b':
                    String firstName = myMenu.prompt_FirstName(br);
                    String lastName = myMenu.prompt_LastName(br);
                    ab.add(new AddressEntry(
                            firstName,
                            lastName,
                            myMenu.prompt_Street(br),
                            myMenu.prompt_City(br),
                            myMenu.prompt_State(br),
                            myMenu.prompt_Zip(br),
                            myMenu.prompt_Telephone(br),
                            myMenu.prompt_Email(br))
                    );
                    System.out.println("Entry for " + firstName + " " + lastName + " added.\n");
                    break;
                case 'c':
                    System.out.print("Last name starts with: ");
                    ab.remove(br.readLine());
                    break;
                case 'd':
                    System.out.print("Last name starts with: ");
                    ab.find(br.readLine());
                    break;
                case 'e':
                    ab.list();
                    break;
            }

            myMenu.displayMenu();
        }


    }

    /* DEPRECATED
    public static void initAddressBookExercise(AddressBook ab){

        AddressEntry entryOne = new AddressEntry();
        AddressEntry entryTwo = new AddressEntry();

        ab.add(entryOne);
        ab.add(entryTwo);

        ab.list();
    }*/

    /**
     * reads in and adds all entries from file to address book
     *  format:
     *         (string) first name
     *         (string) last name
     *         (string) street
     *         (string) city
     *         (string) state
     *         (int)    zip
     *         (string) phone
     *         (string) email
     *         first name of next entry
     * @param filename
     * @throws IOException
     */
    public static void init(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        while(in.ready()){
            ab.add(new address.data.AddressEntry(
                    in.readLine(),
                    in.readLine(),
                    in.readLine(),
                    in.readLine(),
                    in.readLine(),
                    Integer.parseInt(in.readLine()),
                    in.readLine(),
                    in.readLine())
            );
        }
        in.close();
    }
}
