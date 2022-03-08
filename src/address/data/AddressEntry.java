package address.data;

public class AddressEntry {
    /**
     * Entry's first name
     */
    private String first;
    /**
     * Entry's last name
     */
    private String last;
    /**
     * Entry's street
     */
    private String street;
    /**
     * Entry's city
     */
    private String city;
    /**
     * Entry's state
     */
    private String state;
    /**
     * Entry's zip code
     */
    private int zip;
    /**
     * Entry's phone
     */
    private String phone;
    /**
     * Entry's email
     */
    private String email;

    public AddressEntry(){};
    public AddressEntry(String firstName, String lastName, String street, String city, String state, int zip, String phone, String email){
        first = firstName;
        last = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    /**
     * converts into string form, split by lines.
     * @return
     */
    @Override
    public String toString() {
        return first + " " + last + '\n' +
               street + "\n" +
               city + ", " + state + " " + zip + '\n' +
               phone + '\n' +
               email + '\n';
    }

    /**
     * returns first name
     * @return
     */
    public String getFirst() {
        return first;
    }

    /**
     * returns last name
     * @return
     */
    public String getLast() {
        return last;
    }

    /**
     * returns street
     * @return
     */
    public String getStreet() {
        return street;
    }

    /**
     * returns city
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     * returns state
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     * returns zip
     * @return
     */
    public int getZip() {
        return zip;
    }

    /**
     * returns phone
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     * returns email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * sets first name
     * @param first
     */
    public void setFirst(String first) {
        this.first = first;
    }

    /**
     * sets last name
     * @param last
     */
    public void setLast(String last) {
        this.last = last;
    }

    /**
     * sets street
     * @param street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * sets city
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * sets state
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * sets zip
     * @param zip
     */
    public void setZip(int zip) {
        this.zip = zip;
    }

    /**
     * sets phone
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * sets email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
