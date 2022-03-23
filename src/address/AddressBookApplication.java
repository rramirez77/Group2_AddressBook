package address;



import address.data.AddressBook;
import address.data.AddressEntry;
import address.ui.activePanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

import java.sql.*;

/**
 * AddressBookApplication is the GUI class that will present
 * a GUI address book application
 * @author Andrew Zhou
 * @author Karla Villa Estrella
 * @author Romano Edwin Ramirez
 * @author Esad Hasanovic
 */
public class AddressBookApplication extends JPanel {
    /**
     * Contains address book information.
     */
    private static AddressBook ab = new AddressBook();
    /**
     * ActivePanel helper object.
     */
    private static activePanel ap = new activePanel();

    //COLOR SCHEME HERE
    /**
     * AddressBook entry normal color
     */
    static Color basic = new Color(200, 255, 255);

    /**
     * AddressBook entry color on mouse hover
     */
    static Color hover = new Color(150, 255, 255);

    /**
     * AddressBook entry color on select
     */
    static Color click = new Color(100, 200, 255);

    /**
     * Find panel entry normal color
     */
    static Color findBasic = new Color(200,255,200);

    /**
     * Find panel color on mouse hover
     */
    static Color findHover = new Color(150,255,150);

    public static void main(String[] args) throws IOException, InterruptedException, SQLException, ClassNotFoundException{

        //FRAME INIT
        JFrame frame = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(new Dimension((int) screenSize.getWidth()/5, (int) screenSize.getHeight()/2));
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setBackground(Color.darkGray);
        frame.setLocation((int) (screenSize.getWidth()/4), (int) (screenSize.getHeight()/8));

        //BUTTONS INIT
        JPanel buttons = new JPanel(new GridLayout(1,3));
        JButton findButton = new JButton("Search");
        JButton addButton = new JButton("New");
        JButton editButton = new JButton("Edit");
        JButton remButton = new JButton("Remove");

        buttons.add(findButton);
        buttons.add(addButton);
        buttons.add(editButton);
        buttons.add(remButton);

        frame.getContentPane().add(buttons, BorderLayout.SOUTH);
        buttons.setPreferredSize(new Dimension(frame.getWidth(),frame.getHeight()/10));

        //DISPLAY INIT
        JPanel textHolder = new JPanel();
        textHolder.setLayout(new BoxLayout(textHolder, BoxLayout.PAGE_AXIS));
        JScrollPane scrollPane = new JScrollPane(textHolder);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textHolder.setBackground(Color.darkGray);

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.setPreferredSize(new Dimension(frame.getWidth(),9*frame.getHeight()/10));

        //DATABASE CONNECTION
        Class.forName ("oracle.jdbc.driver.OracleDriver");
        Connection conn =
                DriverManager.getConnection("jdbc:oracle:thin:mcs1018/z4Boy2Du@adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu");
        Statement stmt = conn.createStatement ();
        ResultSet rset = stmt.executeQuery("SELECT * FROM ADDRESSENTRYTABLE");
        //TABLE SCHEMA
        //ID    |NAME    |ADDRESS   |PHONE  |EMAIL
        //ID (String) - Built from data as "LastnamePhoneFirstname"
        //NAME (String): "Lastname,Firstname"
        //ADDRESS (String): "Street,City,State,Zip"
        //PHONE (String): as is
        //EMAIL (String): as is

        //READING DATABASE
        while (rset.next ()) //get next row of table returned
        {

            String[] name = rset.getString(2).split(",",2);
            String[] address = rset.getString(3).split(",");

            ab.add(new AddressEntry(name[1],name[0],
                    address[0],address[1],address[2],Integer.parseInt(address[3]),
                    rset.getString(4),
                    rset.getString(5),
                    ""));


        }

        //INITIAL UI BUILD
        buildDisplay(textHolder);
        frame.setVisible(true);

        //BUTTON FUNCTIONS

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField name = new JTextField();
                Object[] fields = {"Last Name", name};
                JOptionPane prompt = new JOptionPane();
                int x = prompt.showConfirmDialog(null, fields, "Search by last name", JOptionPane.OK_CANCEL_OPTION);
                if(x == 0){
                    JFrame finder = new JFrame();
                    finder.setPreferredSize(frame.getPreferredSize());
                    finder.setSize(finder.getPreferredSize());
                    finder.getContentPane().setLayout(new BorderLayout());

                    finder.setLocation((int) (screenSize.getWidth()/4 + screenSize.getWidth()/20), (int) (screenSize.getHeight()/8 + screenSize.getWidth()/20));

                    JPanel findHolder = new JPanel();
                    findHolder.setLayout(new BoxLayout(findHolder, BoxLayout.PAGE_AXIS));

                    JScrollPane findScroller = new JScrollPane(findHolder);
                    findScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                    findScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                    findScroller.setBackground(Color.darkGray);

                    finder.add(findScroller);
                    boolean found = false;
                    for (String s : ab.getData().keySet()) {
                        if (s.toLowerCase().startsWith(name.getText().toLowerCase())) {
                            found = true;
                            AddressEntry a = ab.getData().get(s);
                            JPanel myDisplay = new JPanel(new BorderLayout());
                            //int h = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()*9/100;
                            int h = 87;
                            myDisplay.setPreferredSize(new Dimension(Integer.MAX_VALUE, h));
                            myDisplay.setMaximumSize(myDisplay.getPreferredSize());
                            JTextArea addressData = new JTextArea(a.toString());
                            addressData.setPreferredSize(myDisplay.getPreferredSize());
                            myDisplay.setBorder(BorderFactory.createLineBorder(Color.black));
                            myDisplay.add(addressData, BorderLayout.WEST);

                            addressData.setEditable(false);
                            addressData.setOpaque(false);
                            myDisplay.setBackground(findBasic);
                            addressData.addMouseListener(new MouseListener() {
                                @Override
                                public void mouseClicked(MouseEvent e) {

                                }

                                @Override
                                public void mousePressed(MouseEvent e) {

                                }

                                @Override
                                public void mouseReleased(MouseEvent e) {

                                }

                                @Override
                                public void mouseEntered(MouseEvent e) {
                                    myDisplay.setBackground(findHover);
                                }

                                @Override
                                public void mouseExited(MouseEvent e) {
                                    myDisplay.setBackground(findBasic);
                                }
                            });

                            findHolder.add(myDisplay);
                        }
                    }

                    if(found){
                        finder.setVisible(true);
                        findHolder.repaint();
                    }else {
                        finder.dispose();
                        JOptionPane.showMessageDialog(null,"No entries found!");
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException exc) {
                        exc.printStackTrace();
                    }
                    findHolder.repaint();
                }
                //}
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField firstName = new JTextField();
                JTextField lastName = new JTextField();
                JTextField street = new JTextField();
                JTextField city = new JTextField();
                JTextField state = new JTextField();
                JTextField zipcode = new JTextField();
                JTextField phone = new JTextField();
                JTextField email = new JTextField();

                Object[] fields = {
                        "First Name", firstName,
                        "Last Name", lastName,
                        "Street", street,
                        "City" , city,
                        "State", state,
                        "Zipcode", zipcode,
                        "Phone" , phone,
                        "Email", email

                };
                JOptionPane prompt = new JOptionPane();
                int i = prompt.showConfirmDialog(null, fields, "New Entry", JOptionPane.OK_CANCEL_OPTION);

                //ONLY DO STUFF IF OK BUTTON IS PUSHED
                if(i == 0){
                    try {
                        //CHECK IF ZIPCODE IS INTEGER
                        AddressEntry newEntry = new AddressEntry(firstName.getText(), lastName.getText(),
                                street.getText(), city.getText(), state.getText(), Integer.parseInt(zipcode.getText()),
                                phone.getText(), email.getText(),lastName.getText() + phone.getText() + firstName.getText());

                        //ADD TO LOCAL BOOK
                        ab.add(newEntry);
                        //ADD TO DATABASE
                        stmt.executeUpdate("INSERT INTO ADDRESSENTRYTABLE " + "VALUES ('" + newEntry.getId() + "','" +
                                lastName.getText() + "," + firstName.getText() + "','" +
                                street.getText() + "," + city.getText() + "," + state.getText() + "," + zipcode.getText() + "','" +
                                phone.getText() + "','" +
                                email.getText() + "')");

                        // AND THEN UPDATE DISPLAY
                        buildDisplay(textHolder);
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null,"Error: Non-numeric zipcode!");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddressEntry ae = ab.getData().get(ap.getKey());
                JTextField firstName = new JTextField(ae.getName().getFirstName());
                JTextField lastName = new JTextField(ae.getName().getLastName());
                JTextField street = new JTextField(ae.getAddress().getStreet());
                JTextField city = new JTextField(ae.getAddress().getCity());
                JTextField state = new JTextField(ae.getAddress().getState());
                JTextField zipcode = new JTextField(ae.getAddress().getZipcode() + "");
                JTextField phone = new JTextField(ae.getPhone());
                JTextField email = new JTextField(ae.getEmail());
                Object[] fields = {
                        "First Name", firstName,
                        "Last Name", lastName,
                        "Street", street,
                        "City" , city,
                        "State", state,
                        "Zipcode", zipcode,
                        "Phone" , phone,
                        "Email", email
                };

                JOptionPane prompt = new JOptionPane();
                int i = prompt.showConfirmDialog(null, fields, "New Entry", JOptionPane.OK_CANCEL_OPTION);

                //ONLY DO STUFF IF OK BUTTON IS PUSHED
                if(i == 0){
                    try {
                        //CHECK IF ZIPCODE IS INTEGER
                        AddressEntry newEntry = new AddressEntry(firstName.getText(), lastName.getText(),
                                street.getText(), city.getText(), state.getText(), Integer.parseInt(zipcode.getText()),
                                phone.getText(), email.getText(),lastName.getText() + phone.getText() + firstName.getText());


                        //"EDIT" LOCAL
                        ab.remove(ap.getKey());
                        ab.add(newEntry);

                        //"EDIT" DATABASE
                        try {
                            stmt.executeUpdate("DELETE FROM ADDRESSENTRYTABLE " + "WHERE ID = '" + ap.getKey() + "'");
                            stmt.executeUpdate("INSERT INTO ADDRESSENTRYTABLE " + "VALUES ('" + newEntry.getId() + "','" +
                                    lastName.getText() + "," + firstName.getText() + "','" +
                                    street.getText() + "," + city.getText() + "," + state.getText() + "," + zipcode.getText() + "','" +
                                    phone.getText() + "','" +
                                    email.getText() + "')");
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }

                        // AND THEN UPDATE DISPLAY
                        textHolder.remove(ap.getPanel());
                        ap.setKey("");
                        buildDisplay(textHolder);
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null,"Error: Non-numeric zipcode!");
                    }
                }
            }
        });

        remButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    stmt.executeUpdate("DELETE FROM ADDRESSENTRYTABLE " + "WHERE Id = '" + ap.getKey() + "'");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                ab.remove(ap.getKey());
                textHolder.remove(ap.getPanel());
                textHolder.revalidate();
                textHolder.repaint();
            }
        });

        //OPERATIONAL LOOP DO NOT REMOVE
        //something is causing resize and repainting issues.
        //not clean, but does fix.
        while(true){
            Thread.sleep(200);
            textHolder.repaint();
        }
    }

    /**
     * clears and rebuilds main display area (param textholder)
     * @param txt txt
     */
    public static void buildDisplay(JPanel txt){
        //CLEARS DISPLAY AREA AND THEN REBUILDS IT
        //HAS TO BE DONE THIS WAY TO MAINTAIN ALPHABETICAL ORDER
        for(Component x: txt.getComponents()){
            txt.remove(x);
        }
        for (String s : ab.getData().keySet()) {
            AddressEntry a = ab.getData().get(s);
            JPanel myDisplay = new JPanel(new BorderLayout());
            //int h = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()*9/100;
            int h = 87; //HARDCODED 87 ALLOWS 5 LINES OF TEXT AT DEFAULT TEXT SIZE.
            myDisplay.setPreferredSize(new Dimension(Integer.MAX_VALUE, h));
            myDisplay.setMaximumSize(myDisplay.getPreferredSize());
            JTextArea addressData = new JTextArea(a.toString());
            addressData.setPreferredSize(myDisplay.getPreferredSize());
            myDisplay.setBorder(BorderFactory.createLineBorder(Color.black));
            myDisplay.add(addressData, BorderLayout.WEST);

            addressData.setEditable(false);
            addressData.setOpaque(false);
            myDisplay.setBackground(basic);
            addressData.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ap.getPanel().setBackground(basic);
                    myDisplay.setBackground(click);
                    ap.setPanel(myDisplay);
                    ap.setKey(s);
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    if (myDisplay.getBackground() != (click)) {
                        myDisplay.setBackground(hover);
                    }

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (myDisplay.getBackground() != (click)) {
                        myDisplay.setBackground(basic);
                    }
                }
            });

            txt.add(myDisplay);
        }
        txt.revalidate();
        txt.repaint();
    }

}
