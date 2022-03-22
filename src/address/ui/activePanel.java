package address.ui;

import javax.swing.*;

public class activePanel {
    /**
     * marker for tracked panel
     */
    private JPanel myPanel = new JPanel();
    /**
     * key of data entry the panel contains
     */
    private String key = "";

    /**
     * constructor
     */
    public activePanel(){}

    /**
     * sets panel
     * @param set
     */
    public void setPanel(JPanel set){
        myPanel = set;
    }

    /**
     * gets panel
     * @return JPanel
     */
    public JPanel getPanel(){
        return myPanel;
    }

    /**
     * sets key
     * @param s
     */
    public void setKey(String s){
        key = s;
    }

    /**
     * gets key
     * @return
     */
    public String getKey(){
        return key;
    }
}
