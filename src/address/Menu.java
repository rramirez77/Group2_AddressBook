package address;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Menu {

    /**
     * prints menu options
     */
    public static void displayMenu(){
        System.out.println("a) load from file");
        System.out.println("b) add new entry");
        System.out.println("c) delete person");
        System.out.println("d) search by last name");
        System.out.println("e) list all");
        System.out.println("f) quit");

    }

    /**
     * prompts user for first name
     * @param b
     * @return
     * @throws IOException
     */
    public String prompt_FirstName(BufferedReader b) throws IOException {
        System.out.print("First Name: ");
        return b.readLine();
    };

    /**
     * prompts user for last name
     * @param b
     * @return
     * @throws IOException
     */
    public String prompt_LastName(BufferedReader b) throws IOException {
        System.out.print("Last Name: ");
        return b.readLine();
    }

    /**
     * prompts user for street
     * @param b
     * @return
     * @throws IOException
     */
    public String prompt_Street(BufferedReader b) throws IOException {
        System.out.print("Street: ");
        return b.readLine();
    };

    /**
     * prompts user for city
     * @param b
     * @return
     * @throws IOException
     */
    public String prompt_City(BufferedReader b) throws IOException {
        System.out.print("City: ");
        return b.readLine();
    };

    /**
     * prompts user for state
     * @param b
     * @return
     * @throws IOException
     */
    public String prompt_State(BufferedReader b) throws IOException {
        System.out.print("State: ");
        return b.readLine();
    };

    /**
     * prompts user for zip
     * @param b
     * @return
     * @throws IOException
     */
    public int prompt_Zip(BufferedReader b) throws IOException {
        boolean isInt = false;
        String s = "";
        while(!isInt){ // validate until user gives us integer
            isInt = true;
            System.out.print("Zip: ");
            s = b.readLine();
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) < '0' || s.charAt(i) > '9'){
                    System.out.println("This must be an integer!");
                    isInt = false;
                    break;
                }
            }
        }
        return Integer.parseInt(s);
    };

    /**
     * prompts user for phone
     * @param b
     * @return
     * @throws IOException
     */
    public String prompt_Telephone(BufferedReader b) throws IOException {
        System.out.print("Telephone: ");
        return b.readLine();
    }

    /**
     * prompts user for email
     * @param b
     * @return
     * @throws IOException
     */
    public String prompt_Email(BufferedReader b) throws IOException {
        System.out.print("Email: ");
        return b.readLine();
    };
}
