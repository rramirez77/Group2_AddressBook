package address.data;

import java.sql.SQLException;

public class AddressEntry {

    /**
     * Address object containing Street, City, State, and Zipcode information
     */
    private Address address;
    /**
     * Name object containing FirstName and LastName information
     */
    private Name name;
    /**
     * phone number
     */
    private String phone;
    /**
     * email
     */
    private String email;
    /**
     * id built of form LastnameZipcodeFirstname
     */
    private String id;

    /**
     * blank constructor
     */
    public AddressEntry(){}

    /**
     * constructor from name and address objects
     * @param n
     * @param a
     * @param phone
     * @param email
     * @param id
     */
    public AddressEntry(Name n, Address a, String phone, String email, String id){
        this.address = a;
        this.name = n;
        this.phone = "";
        this.email = "";
        try {
            if(!phone.equals(null)){
                this.phone = phone;
            }
            if(!email.equals(null)){
                this.email = email;
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        if(id.equals("")){this.id = n.getLastName() + this.phone + n.getFirstName();}
            else{this.id = id;}
    }

    /**
     * constructor of individual components
     * @param first
     * @param last
     * @param street
     * @param city
     * @param state
     * @param zip
     * @param email
     * @param phone
     * @param id
     */
    public AddressEntry(String first, String last, String street, String city, String state, int zip, String phone, String email, String id){
        this.name = new Name(first, last);
        this.address = new Address(street, city, state, zip);
        this.phone = "";
        this.email = "";
        try {
            if(!phone.equals(null)){
                this.phone = phone;
            }
            if(!email.equals(null)){
                this.email = email;
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        if(id.equals("")){this.id = last + this.phone + first;}
            else{this.id = id;}
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
     * returns key equivocal id
     * @return String
     */
    public String getId(){
        return id;
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
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * returns name object
     * @return Name
     */
    public Name getName() {
        return name;
    }

    /**
     * returns address object
     * @return Address
     */
    public Address getAddress() {
        return address;
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

    /**
     * sets name to object given
     * @param name
     */
    public void setName(Name name){
        this.name = name;
    }

    /**
     * sets address to object given
     * @param address
     */
    public void setAddress(Address address){
        this.address = address;
    }
}
