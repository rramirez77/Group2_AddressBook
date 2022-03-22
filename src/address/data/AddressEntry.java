package address.data;

public class AddressEntry {

    private Address address;
    private Name name;
    private String email;
    private String phone;
    private String id;

    public AddressEntry(){}

    public AddressEntry(Name n, Address a, String phone, String email, String id){
        this.address = a;
        this.name = n;
        this.phone = phone;
        this.email = email;
        if(id.equals("")){
            this.id = n.getLastName() + phone + n.getFirstName();
        }else{
            this.id = id;
        }

    }

    public AddressEntry(String first, String last, String street, String city, String state, int zip, String email, String phone, String id){
        this.name = new Name(first, last);
        this.address = new Address(street, city, state, zip);
        this.phone = phone;
        this.email = email;
        if(id.equals("")){
            this.id = last + phone + first;
        }else{
            this.id = id;
        }
    }

    /**
     * converts into string form, split by lines
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
     * sets name
     * @param n
     */
    public void setName(Name n){
        this.name = n;
    }

    /**
     * sets address
     * @param a
     */
    public void setAddress(Address a){
        this.address = a;
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
     * returns name
     * @return
     */
    public Name getName(){return this.name;}

    /**
     * returns address
     * @return
     */
    public Address getAddress(){return this.address;}


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

    /**\
     * returns id
     * @return
     */
    public String getID(){return this.id;}










}