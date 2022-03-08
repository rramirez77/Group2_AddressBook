package address;

import javax.swing.*;

public class activePanel {
    public JPanel myPanel = new JPanel();
    String key = "";
    public activePanel(){};

    public void setPanel(JPanel set){
        myPanel = set;
    }
    public JPanel getPanel(){
        return myPanel;
    }
    public void setKey(String s){
        key = s;
    }
    public String getKey(){
        return key;
    }
}
