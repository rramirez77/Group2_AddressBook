package address;

import java.util.Scanner;

/**
 * Menu class outputs information such as contacts first and last name, address,
 * city, state, zip, telephone, and email
 **/

public class Menu {
    // Create user input
    Scanner myObj = new Scanner(System.in);

    /**
     * displayMenu displays the menu options A-F
     * @return a text display of the menu options
     */
    public String displayMenu(){
        return """
                Please enter your menu selection\s
                a) Loading From File\s
                b) Addition\s
                c) Removal\s
                d) Find\s
                e) Listing\s
                f) Quit
                """;

    }

    /**
     * prompt_FirstName asks for the user's first name
     * @return user's first name
     **/
    public String prompt_FirstName() {
        System.out.print("First Name: ");
        return myObj.nextLine();
    }

    /**
     * prompt_LastName asks for the user's last name
     * @return user's last name
     **/
    public String prompt_LastName() {
        System.out.print("Last Name: ");
        return myObj.nextLine();
    }

    /**
     * prompt_Street asks for the user's street address
     * @return user's street address
     **/
    public String prompt_Street() {
        System.out.print("Street: ");
        return myObj.nextLine();
    }

    /**
     * prompt_City() asks for the user's city
     * @return user's city
     **/
    public String prompt_City() {
        System.out.print("City: ");
        return myObj.nextLine();
    }

    /**
     * prompt_State() asks for the user's state
     * @return user's state
     **/
    public String prompt_State() {
        System.out.print("State: ");
        return myObj.nextLine();
    }

    /**
     * prompt_Zip() asks for the user's zip code
     * @return user's zip code
     **/
    public Integer prompt_Zip() {
        System.out.print("Zip: ");
        return Integer.parseInt(myObj.nextLine());
    }

    /**
     * prompt_Telephone() asks for the user's telephone number
     * @return user's telephone number
     **/
    public String prompt_Telephone() {
        System.out.print("Telephone: ");
        return myObj.nextLine();
    }

    /**
     * prompt_Email() asks for the user's email
     * @return user's email address
     **/
    public String prompt_Email() {
        System.out.print("Email: ");
        return myObj.nextLine();
    }

}
