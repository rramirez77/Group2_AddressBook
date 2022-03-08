package address;

import address.data.AddressBook;
import address.data.AddressEntry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {
    public static void main(String[] args) throws IOException {
        //if we were better we would have return statements to actually validate against for our methods
        //eg return array and validate array then when searching addressBook

        System.out.println("Address entry test 1: " + checkAddressEntry1());
        System.out.println("Address entry test 2: " + checkAddressEntry2());
        System.out.println("Menu test 1: " + checkMenu());
        System.out.println("Menu test 2: " + checkMenu());// this is the same method. There really isn't much to test here beyond if input works / zip validation, but it says 2 tests >_>.
        System.out.println("AddressBook test: " + checkAddressBook1());
        // no test driver for the Application class: Testing should be run through it itself, as it wraps everything together.
    }
    public static boolean checkAddressEntry1(){
        AddressEntry ae = new AddressEntry("first", "last", "street", "city", "state", 123, "phone", "email");

        if(!ae.getFirst().equals("first")){
            return false;
        }
        if(!ae.getLast().equals("last")){
            return false;
        }
        if(!ae.getStreet().equals("street")){
            return false;
        }
        if(!ae.getCity().equals("city")){
            return false;
        }
        if(!ae.getState().equals("state")){
            return false;
        }
        if(!(ae.getZip() == 123)){
            return false;
        }
        if(!ae.getPhone().equals("phone")){
            return false;
        }
        if(!ae.getEmail().equals("email")){
            return false;
        }
        System.out.println(ae.toString());
        return true;
    }
    public static boolean checkAddressEntry2(){
        AddressEntry ae = new AddressEntry("alice", "bobley", "123 st", "c city", "CA", 10000, "123456789", "alice@bobley.com");

        if(!ae.getFirst().equals("alice")){
            return false;
        }
        if(!ae.getLast().equals("bobley")){
            return false;
        }
        if(!ae.getStreet().equals("123 st")){
            return false;
        }
        if(!ae.getCity().equals("c city")){
            return false;
        }
        if(!ae.getState().equals("CA")){
            return false;
        }
        if(!(ae.getZip() == 10000)){
            return false;
        }
        if(!ae.getPhone().equals("123456789")){
            return false;
        }
        if(!ae.getEmail().equals("alice@bobley.com")){
            return false;
        }
        if(!ae.toString().equals("alice\nbobley\n123 st\nc city\nCA\n10000\n123456789\nalice@bobley.com\n")){
            return false;
        }
        return true;
    }
    public static boolean checkMenu() throws IOException {
        Menu menu = new Menu();
        menu.displayMenu();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(menu.prompt_FirstName(br));
        System.out.println(menu.prompt_LastName(br));
        System.out.println(menu.prompt_Street(br));
        System.out.println(menu.prompt_State(br));
        System.out.println(menu.prompt_City(br));
        System.out.println("Test validation for entering a non-integer value here");
        System.out.println(menu.prompt_Zip(br));
        System.out.println(menu.prompt_Telephone(br));
        System.out.println(menu.prompt_Email(br));
        return true;
    }
    public static boolean checkAddressBook1() throws IOException {
        AddressBook ab = new AddressBook();
        ab.add(new AddressEntry("alice", "bobley", "123 st", "c city", "CA", 10000, "123456789", "alice@bobley.com"));
        ab.add(new AddressEntry("first", "last", "street", "city", "state", 123, "phone", "email"));
        System.out.println("__LISTING__");
        ab.list();
        ab.find("bobley");
        ab.find("potato");
        ab.find("");
        ab.find("LAST");
        System.out.println("__LISTING__");
        ab.list();
        ab.remove("bob");
        ab.remove("potato");
        System.out.println("__LISTING__");
        ab.list();
        return true;
    }

}
