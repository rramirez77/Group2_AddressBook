package address.data;

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
     * @param street
     * @param city
     * @param state
     * @param zipcode
     */
    public Address(String street, String city, String state, int zipcode){
         this.street = street;
         this.city = city;
         this.state = state;
         this.zipcode = zipcode;
    }

    /**
     * Get street address
     * @return street
     */
    public String getStreet(){
        return street;
    }

    /**
     * Get city name
     * @return city
     */
    public String getCity(){
        return city;
    }

    /**
     * Get state name
     * @return state
     */
    public String getState(){
        return state;
    }

    /**
     * Gets zipcode
     * @return zipcode
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
     * @param s
     */
    public void setStreet(String s){
        street = s;
    }

    /**
     * set city
     * @param s
     */
    public void setCity(String s){
        city = s;
    }

    /**
     * set state
     * @param s
     */
    public void setState(String s){
        state = s;
    }

    /**
     * set zipcode
     * @param i
     */
    public void setZipcode(int i){
        zipcode = i;
    }
}
