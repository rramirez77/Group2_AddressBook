package address.data;

public class AddressEntry {

    private Address address;
    private Name name;
    private String email;
    private String phone;
    private int id;

    public AddressEntry(){}

    public AddressEntry(Name n, Address a, String phone, String email, int id){
        this.address = a;
        this.name = n;
        this.phone = phone;
        this.email = email;
        this.id = id;
    }

    public AddressEntry(String first, String last, String street, String city, String state, int zip, String email, String phone, int id){
        this.name = new Name(first, last);
        this.address = new Address(street, city, state, zip);
        this.phone = phone;
        this.email = email;
        this.id = id;
    }

    /**
     * converts into string form, split by lines.
     * @return
     */
    @Override
    public String toString() {
        return name.toString() + "\n" +
                address.toString() + "\n" +
                phone + "\n" +
                email + "\n";
    }

    /**
     * returns first name
     * @return String
     */
    public String getFirst() {
        return name.getFirstName();
    }

    /**
     * returns last name
     * @return String
     */
    public String getLast() {
        return name.getLastName();
    }

    /**
     * returns street
     * @return String
     */
    public String getStreet() {
        return address.getStreet();
    }

    /**
     * returns city
     * @return String
     */
    public String getCity() {
        return address.getCity();
    }

    /**
     * returns state
     * @return String
     */
    public String getState() {
        return address.getState();
    }

    /**
     * returns zip
     * @return int
     */
    public int getZip() {
        return address.getZipcode();
    }

    /**
     * returns phone
     * @return String
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
        name.setFirstName(first);
    }

    /**
     * sets last name
     * @param last
     */
    public void setLast(String last) {
        name.setLastName(last);
    }

    /**
     * sets street
     * @param street
     */
    public void setStreet(String street) {
        address.setStreet(street);
    }

    /**
     * sets city
     * @param city
     */
    public void setCity(String city) {
        address.setCity(city);
    }

    /**
     * sets state
     * @param state
     */
    public void setState(String state) {
        address.setState(state);
    }

    /**
     * sets zip
     * @param zip
     */
    public void setZip(int zip) {
        address.setZipcode(zip);
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

    public void setName(Name n){
        this.name = n;
    }
    public void setAddress(Address a){
        this.address = a;
    }
}