package address.data;

/**
 * addressEntry class represents a single entry
 */
public class addressEntry {
    /**
     * First name of addressEntry contact
     **/
    private String firstName;

    /**
     * Last name of addressEntry contact
     **/
    private String lastName;

    /**
     * Street of addressEntry contact
     **/
    private String street;

    /**
     * City of addressEntry contact
     **/
    private String city;

    /**
     * State of addressEntry contact
     **/
    private String state;

    /**
     * ZIP of addressEntry contact
     **/
    private int zip;

    /**
     * Phone of addressEntry contact
     **/
    private String phone;

    /**
     * Email of addressEntry contact
     **/
    private String email;

    /**
     * Default Constructor initializes all attributes to a default value
     **/
    public addressEntry(){
        firstName = " ";
        lastName = " ";
        street = "";
        city = "";
        state = "";
        zip = 0;
        phone = "";
        email = "";
    }

    /**
     * Other constructor initializes all attributes to a new value
     * @param firstName new first name
     * @param lastName new last name
     * @param street new street name
     * @param city new city name
     * @param state new state
     * @param zip new zipcode
     * @param phone new phone number
     * @param email new email
     */
    public addressEntry(String firstName, String lastName, String street, String city,
                        String state, int zip, String phone, String email){
        // Initialize the class variables
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    /**
     * Creates a formatted string of all the attributes
     * @return a String with all attributes
     */
    public String toString(){
        return firstName + " " + lastName + "\n" + street +
                "\n" + city + ", " + state + " " + zip + "\n" + email + "\n"+ phone + "\n\n";
    }

    /* Setters */

    /**
     * Sets firstName to new value
     * @param firstName new first name
     **/
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
     *  Sets lastName to new value
     * @param lastName new last name
     **/
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets street to new value
     * @param street new street name
     **/
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Sets city to new value
     * @param city new city name
     **/
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *Sets state to new value
     * @param state - new state name
     **/
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Sets zip to new value
     * @param zip new zipcode
     **/
    public void setZip(Integer zip) {
        this.zip = zip;
    }

    /**
     * Sets phone to new value
     * @param phone new phone number
     **/
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Sets email to new value
     * @param email new email
     **/
    public void setEmail(String email) {
        this.email = email;
    }


    /* Getters */

    /**
     * Gets firstName
     * @return firstName
     **/
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets lastName
     * @return lastName
     **/
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets street
     * @return street
     **/
    public String getStreet() {
        return street;
    }

    /**
     * Gets city
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Gets state
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * Gets zip
     * @return zip
     **/
    public Integer getZip() {
        return zip;
    }

    /**
     * Gets phone number
     * @return phone
     **/
    public String getPhone() {
        return phone;
    }

    /**
     * Gets email
     * @return email
     **/
    public String getEmail() {
        return email;
    }
}
