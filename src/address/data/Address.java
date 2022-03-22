package address.data;

public class Address {
    private String street;
    private String city;
    private String state;
    private int zipcode;

    public Address(String street, String city, String state, int zipcode){
         this.street = street;
         this.city = city;
         this.state = state;
         this.zipcode = zipcode;
    }
    public String getStreet(){
        return street;
    }

    public String getCity(){
        return city;
    }

    public String getState(){
        return state;
    }

    public int getZipcode(){
        return zipcode;
    }

    public String toString(){
        return street + " " + city + ", " + state + " " + zipcode;
    }  //removed \n
    public void setStreet(String s){
        street = s;
    }
    public void setCity(String s){
        city = s;
    }
    public void setState(String s){
        state = s;
    }
    public void setZipcode(int i){
        zipcode = i;
    }
}
