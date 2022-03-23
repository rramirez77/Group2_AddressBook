/**
 * AddressEntry is a class that creates a new address entry
 * @author: Andrew Zhou
 * @author: Karla Villa Estrella
 * @author: Romano Edwin Ramirez
 * @author: Esad Hasanovic
 */
package address.data;
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
     * @param n name of person
     * @param a address
     * @param phone phone number
     * @param email email
     * @param id ID of entry
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
     * @param first first name
     * @param last last name
     * @param street street name
     * @param city city name
     * @param state state name
     * @param zip zipcode
     * @param email email
     * @param phone phone number
     * @param id id
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
     * @return String for name, address, phone and email of an addressEntry
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
     * @return id as a string
     */
    public String getId(){
        return id;
    }

    /**
     * returns phone
     * @return phone number as a string
     */
    public String getPhone() {
        return phone;
    }

    /**
     * returns email
     * @return email as a string
     */
    public String getEmail() {
        return email;
    }

    /**
     * returns name object
     * @return name as a Name object
     */
    public Name getName() {
        return name;
    }

    /**
     * returns address object
     * @return address and an Address object
     */
    public Address getAddress() {
        return address;
    }

    /**
     * sets phone
     * @param phone new phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * sets email
     * @param email new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * sets name to object given
     * @param name new name
     */
    public void setName(Name name){
        this.name = name;
    }

    /**
     * sets address to object given
     * @param address new address
     */
    public void setAddress(Address address){
        this.address = address;
    }
}
