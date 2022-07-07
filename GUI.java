/**
 * This is the main Gui Class This place will be responsible for the images
 * UI and the menus, however the main calculations for the menu functions
 * will happen elsewhere.
 * 
 * @author Juan Coetzee
 * @version 0.6 || 06.05.2022 
 */

import javax.swing.*; // For making the GUI window
import java.awt.event.*; //Listener for the switch statement
import java.awt.*; // For making the GUI window
import java.awt.event.ActionListener; // This is for the text dialogs
import java.awt.event.ActionEvent; // This is needed for the text dialogs
import java.awt.geom.*;

public class GUI extends JFrame implements ActionListener
{
    // This will be the main area fo the GUI as all the other bit of GUI come
    //back here
    private String remember;

    public GUI(){
        // This is to create the window for the program to use.
        setTitle("Wellington Waterways");
        this.getContentPane().setPreferredSize(new Dimension(400,600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.toFront();
        this.setVisible(true);

        // Menu for saving and loading.
        // The Menus variables.
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;

        // The Menu itself
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        menu = new JMenu("File");
        menuBar.add(menu);

        menuItem = new JMenuItem("New");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Open");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Save");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Save As");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Close Window");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("TEST");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        this.pack();
        
    }//Switch

    //This method is for the menu being clicked on and used

    public void actionPerformed(ActionEvent e){
        String cmd = e.getActionCommand();
        System.out.println(cmd);

        switch(cmd){
            case "New" : ;
            break;
            case "Open" :
                InD box = new InD("What File do you want to load");
                box.setLocationRelativeTo(this);
                box.setVisible(true);
                String reply = box.getText();
                System.out.println(reply);
                filing open = new filing();
                open.load(reply);
            break;
            case "Save" : filing Save = new filing();
            Save.save(this);
            break;
            case "Save As" : ;
            break;
            case "Close Window" : System.exit(0);
            break;
            case "TEST" : TEST test = new TEST();
        }//Switch
    } //Method

    //This method is for dialogBoxes. This will be used for saving loading
    // and other things that will be similar to that.
    public void dialogBoxes(){
        JDialog box = new JDialog(this);
        box.setBounds(400,400,250,100);
        TextArea area = new TextArea("More information");
        box.add(area);
        area.setEditable(false); // This prevents the user from editing the text
        box.toFront();
        box.setVisible(true);
        box.setTitle("Hello");

    }//Method

    //=======================================================================================================================================================
    // This is the Main part of the GUI. like the Grids, icons, or other things related to visuals/
    //=======================================================================================================================================================



}// Class