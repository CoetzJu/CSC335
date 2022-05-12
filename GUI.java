/**
 * This is the main Gui Class This place will be responsible for the images
 * UI and the menus, however the main calculations for the menu functions
 * will happen elsewhere.
 * 
 * @author Juan Coetzee
 * @version 06.05.2022 
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GUI extends JFrame implements ActionListener
{
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
      menu.add(menuItem);
      
      this.pack();
  }
  
  public void actionPerformed(ActionEvent e){
      String cmd = e.getActionCommand();
      System.out.println(cmd);
  }
}
