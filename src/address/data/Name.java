

package address.data;
/**
 * Name is a class that creates a name: first and last name
 * @author Andrew Zhou
 * @author Karla Villa Estrella
 * @author Romano Edwin Ramirez
 * @author Esad Hasanovic
 */
public class Name {

    /**
     * First name
     */
    private String first;
    /**
     * Last name
     */
    private String last;

    /**
     * Constructor for name
     * @param first new first name
     * @param last new last name
     */
    public Name(String first, String last){
        this.first = first;
        this.last = last;
    }

    /**
     * gets first name
     * @return first name as a string
     */
    public String getFirstName(){
        return first;
    }

    /**
     * gets last name
     * @return last name as a string
     */
    public String getLastName(){
        return last;
    }

    /**
     * returns string as "firstname lastname"
     * @return first and last name as a string
     */
    public String toString(){
        return first + " " + last;
    }

    /**
     * sets first name
     * @param s new first name
     */
    public void setFirstName(String s){
        first = s;
    }

    /**
     * sets last name
     * @param s new last name
     */
    public void setLastName(String s){
        last = s;
    }
}
