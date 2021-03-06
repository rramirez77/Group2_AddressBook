
package address.data;
/**
 * Address is a class that creates an address
 * @author Andrew Zhou
 * @author Karla Villa Estrella
 * @author Romano Edwin Ramirez
 * @author Esad Hasanovic
 */
public class Address {

    /**
     * Street address
     */
    private String street;
    /**
     * City
     */
    private String city;
    /**
     * State
     */
    private String state;
    /**
     * Zipcode
     */
    private int zipcode;

    /**
     * Build address from values
     * @param street new street
     * @param city new city
     * @param state new state
     * @param zipcode new zipcode
     */
    public Address(String street, String city, String state, int zipcode){
         this.street = street;
         this.city = city;
         this.state = state;
         this.zipcode = zipcode;
    }

    /**
     * Get street name
     * @return street as a string
     */
    public String getStreet(){
        return street;
    }

    /**
     * Get city name
     * @return city as a string
     */
    public String getCity(){
        return city;
    }

    /**
     * Get state name
     * @return state as a string
     */
    public String getState(){
        return state;
    }

    /**
     * Gets zipcode
     * @return zipcode as an int
     */
    public int getZipcode(){
        return zipcode;
    }

    /**
     * Returns address in readable string form
     * @return String of form {123 Banana St\nBanana, BN 00000}
     */
    public String toString(){
        return street + "\n" + city + ", " + state + " " + zipcode;
    }

    /**
     * set street
     * @param s new street
     */
    public void setStreet(String s){
        street = s;
    }

    /**
     * set city
     * @param s new city
     */
    public void setCity(String s){
        city = s;
    }

    /**
     * set state
     * @param s new state
     */
    public void setState(String s){
        state = s;
    }

    /**
     * set zipcode
     * @param i new zipcode
     */
    public void setZipcode(int i){
        zipcode = i;
    }
}
