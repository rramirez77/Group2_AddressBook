package address;

import address.data.AddressBook;
import address.data.AddressEntry;

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

    public static void main(String[] args) throws IOException, InterruptedException {

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

        //MANUAL TEST ENTRIES BECAUSE DATABASE NOT FILLED.
        AddressEntry ex = new AddressEntry("alice","alastname","","","",123,"","","");
        AddressEntry ex2 = new AddressEntry("bob","midname","","","",123,"","","");
        AddressEntry ex3 = new AddressEntry("cat","lastname","","","",123,"","","");
        ab.add(ex3);
        ab.add(ex2);
        ab.add(ex);

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
                        //TODO: UPDATE DATABASE

                        // AND THEN UPDATE DISPLAY
                        buildDisplay(textHolder);
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null,"Error: Non-numeric zipcode!");
                    }
                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddressEntry ae = ab.getData().get(ap.getKey());
                JTextField firstName = new JTextField(ae.getFirst());
                JTextField lastName = new JTextField(ae.getLast());
                JTextField street = new JTextField(ae.getStreet());
                JTextField city = new JTextField(ae.getCity());
                JTextField state = new JTextField(ae.getState());
                JTextField zipcode = new JTextField(ae.getZip() + "");
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
                        ab.add(newEntry);
                        ab.remove2(ap.getKey());
                        textHolder.remove(ap.getPanel());
                        //TODO: UPDATE DATABASE

                        // AND THEN UPDATE DISPLAY
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
