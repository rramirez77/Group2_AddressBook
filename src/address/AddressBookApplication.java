package address;

import address.data.Address;
import address.data.AddressBook;
import address.data.AddressEntry;
import address.data.Name;

import java.sql.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;


public class AddressBookApplication extends JPanel {
    /**
     * Contains address book information.
     */
    public static AddressBook ab = new AddressBook();
    static activePanel ap = new activePanel();

    //COLOR SCHEME HERE
    static Color basic = new Color(200, 255, 255);
    static Color hover = new Color(150, 255, 255);
    static Color click = new Color(100, 200, 255);
    static Color findBasic = new Color(200,255,200);
    static Color findHover = new Color(150,255,150);

    public static void main(String[] args) throws IOException, SQLException, InterruptedException, ClassNotFoundException {

        //CONNECT TO DATABASE
        Class.forName ("oracle.jdbc.driver.OracleDriver");

        Connection conn =
                DriverManager.getConnection("jdbc:oracle:thin:mcs1018/z4Boy2Du@adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu");

        Statement stmt = conn.createStatement();


        //FRAME INIT
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setBackground(Color.darkGray);

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

        //DISPLAY INIT
        JPanel textHolder = new JPanel();
        textHolder.setLayout(new BoxLayout(textHolder, BoxLayout.PAGE_AXIS));
        JScrollPane scrollPane = new JScrollPane(textHolder);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textHolder.setBackground(Color.darkGray);

        //ADD AND SETUP TO FRAME
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(new Dimension((int) screenSize.getWidth()/5, (int) screenSize.getHeight()/2));
        frame.getContentPane().add(buttons, BorderLayout.SOUTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        buttons.setPreferredSize(new Dimension(frame.getWidth(),frame.getHeight()/10));
        scrollPane.setPreferredSize(new Dimension(frame.getWidth(),9*frame.getHeight()/10));

        frame.setLocation((int) (screenSize.getWidth()/4), (int) (screenSize.getHeight()/8));


        //READ FROM DATABASE
        /**ResultSet rset = stmt.executeQuery("SELECT * FROM ADDRESSENTRYTABLE");

        System.out.println(rset);


        // Iterate through the result and print the employee names

        while (rset.next()) //get next row of table returned
        {
            for (int i = 1; i <= rset.getMetaData().getColumnCount(); i++) { //visit each column

              AddressEntry tryEntry = new AddressEntry( rset.getObject("NAME", Name<>), (Address) rset.getObject("ADDRESS"), rset.getString("PHONE"), rset.getString("EMAIL"), rset.getString("ID"));
              ab.add(tryEntry);

            }

        }**/


//MANUAL TEST ENTRIES BECAUSE DATABASE NOT FILLED.

        AddressEntry ex = new AddressEntry("alice","alastname","","","",123,"","","");
        AddressEntry ex2 = new AddressEntry("bob","midname","","","",123,"","","");
        AddressEntry ex3 = new AddressEntry("cat","lastname","","","",123,"","","");
        ab.add(ex3);
        ab.add(ex2);
        ab.add(ex);

        //add manual entries to database

       // INSERT INTO *ADDRESSENTRYTABLE VALUES('ex.')


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
                        if (s.startsWith(name.getText())) {
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
                        ab.add(newEntry);


                        //ADD NEW ENTRY TO DATABASE
                        //HAD TO CHANGE PHONE WITH EMAIL B/C IT'S PRINTING INCORRECTLY IN DB
                        stmt.executeUpdate("INSERT INTO ADDRESSENTRYTABLE VALUES('" +newEntry.getName() + "','"+newEntry.getAddress() + "', '" + newEntry.getPhone() + "', '" + newEntry.getEmail() + "', '" + newEntry.getID() + "')");

                        // AND THEN UPDATE DISPLAY
                        buildDisplay(textHolder);
                    } catch (NumberFormatException | SQLException nfe) {
                        JOptionPane.showMessageDialog(null,"Error: Non-numeric zipcode!");
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
                                phone.getText(), email.getText(),lastName.getText() + email.getText() + firstName.getText()); //HAD TO CHANGE PHONE TO EMAIL B/C IT'S NOT PRINTING CORRECTLY
                        System.out.println("Phone: " + newEntry.getPhone());
                        System.out.println("Email: " + newEntry.getEmail());
                        System.out.println("ID: " + newEntry.getID());
                        ab.add(newEntry);
                        ab.remove2(ap.getKey());
                        textHolder.remove(ap.getPanel());




                        //TODO: UPDATE DATABASE


                        stmt.executeUpdate("UPDATE ADDRESSENTRYTABLE SET NAME = '"+newEntry.getName()+"' WHERE ID = '"+ae.getID()+"'");
                        stmt.executeUpdate("UPDATE ADDRESSENTRYTABLE SET ADDRESS = '"+newEntry.getAddress()+"' WHERE ID = '"+ae.getID()+"'");
                        stmt.executeUpdate("UPDATE ADDRESSENTRYTABLE SET EMAIL = '"+newEntry.getEmail()+"' WHERE ID = '"+ae.getID()+"'");
                        stmt.executeUpdate("UPDATE ADDRESSENTRYTABLE SET PHONE = '"+newEntry.getPhone()+"' WHERE ID = '"+ae.getID()+"'");
                        stmt.executeUpdate("UPDATE ADDRESSENTRYTABLE SET ID = '"+newEntry.getID()+"' WHERE ID = '"+ae.getID()+"'");



                        // AND THEN UPDATE DISPLAY
                        buildDisplay(textHolder);


                    } catch (NumberFormatException | SQLException nfe) {
                        JOptionPane.showMessageDialog(null,"Error: Non-numeric zipcode!");
                    }

                }
            }
        });

        remButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get address entry to remove
                AddressEntry entry = ab.getData().get(ap.getKey());

                //remove address entry from database
                try {
                    stmt.executeUpdate("DELETE ADDRESSENTRYTABLE  WHERE ID = '"+entry.getID()+"'");
                } catch (SQLException exc) {
                    exc.printStackTrace();
                }
                 //remove from GUI
                ab.remove2(ap.getKey());
                textHolder.remove(ap.getPanel());
                textHolder.revalidate();
                textHolder.repaint();






            }
        });

        while(true){
            //something is causing resize and painting issues.
            //not clean, but does fix.
            Thread.sleep(200);
            textHolder.repaint();
        }
    }

    public static void buildDisplay(JPanel txt){
        //CLEARS DISPLAY AREA AND THEN REBUILDS IT
        //HAS TO BE DONE THIS WAY TO MAINTAIN ORDER
        for(Component x: txt.getComponents()){
            txt.remove(x);
        }
        for (String s : ab.getData().keySet()) {
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
