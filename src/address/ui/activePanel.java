package address.ui;
import javax.swing.*;
/**
 * activePanel class creates panel
 * @author Andrew Zhou
 * @author Karla Villa Estrella
 * @author Romano Edwin Ramirez
 * @author Esad Hasanovic
 */
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
     * @param set set
     */
    public void setPanel(JPanel set){
        myPanel = set;
    }

    /**
     * gets panel
     * @return myPanel
     */
    public JPanel getPanel(){
        return myPanel;
    }

    /**
     * sets key
     * @param s s
     */
    public void setKey(String s){
        key = s;
    }

    /**
     * gets key
     * @return key
     */
    public String getKey(){
        return key;
    }
}
