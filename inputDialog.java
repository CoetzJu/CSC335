
/*
 * Write a description of class inputDialog here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javax.swing.*; // For making the GUI window
import java.awt.event.*; //Listener for the switch statement
import java.awt.*; // For making the GUI window
import java.awt.event.ActionListener; // This is for the text dialogs
import java.awt.event.ActionEvent; // This is needed for the text dialogs
import java.util.Scanner;

public class inputDialog extends JFrame
{
    /*public inputDialog(String title){
        setTitle(title);
        this.getContentPane().setPreferredSize(new Dimension(400,600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        
        InD test = new InD("a question that is longer than the previous one.");
        test.setLocationRelativeTo(this);
        test.setVisible(true);
        String reply = test.getText();
        
        System.out.println(reply);
    }*/

    public void loadFile(){
        Scanner keyboard;
        keyboard = new Scanner(System.in);
        String fileName;

        InD test = new InD("What File do you want to load");
        test.setLocationRelativeTo(this);
        test.setVisible(true);
        String reply = test.getText();

        System.out.println(reply);


    }
}