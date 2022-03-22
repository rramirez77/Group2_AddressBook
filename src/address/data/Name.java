package address.data;

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
     * @param first
     * @param last
     */
    public Name(String first, String last){
        this.first = first;
        this.last = last;
    }

    /**
     * gets first name
     * @return first
     */
    public String getFirstName(){
        return first;
    }

    /**
     * gets last name
     * @return last
     */
    public String getLastName(){
        return last;
    }

    /**
     * returns string as "firstname lastname"
     * @return [full name]
     */
    public String toString(){
        return first + " " + last;
    }

    /**
     * sets first name
     * @param s
     */
    public void setFirstName(String s){
        first = s;
    }

    /**
     * sets last name
     * @param s
     */
    public void setLastName(String s){
        last = s;
    }
}
