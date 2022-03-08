package address;

import address.data.addressEntry;

import javax.swing.*;

public class activePanel {
    public JPanel myPanel = new JPanel();
    addressEntry ae;
    public activePanel(){};

    public void setPanel(JPanel set){
        myPanel = set;
    }
    public JPanel getPanel(){
        return myPanel;
    }
    public void setKey(addressEntry s){
        ae = s;
    }
    public addressEntry getKey(){
        return ae;
    }
}
