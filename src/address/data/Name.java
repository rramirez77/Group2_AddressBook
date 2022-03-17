package address.data;

public class Name {
    private String first;
    private String last;

    public Name(String first, String last){
        this.first = first;
        this.last = last;
    }
    public String getFirstName(){
        return first;
    }
    public String getLastName(){
        return last;
    }
    public String toString(){
        return first + " " + last;
    }

    public void setFirstName(String s){
        first = s;
    }
    public void setLastName(String s){
        last = s;
    }
}
