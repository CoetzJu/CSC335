
/**
 * Write a description of class InD here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javax.swing.*; // For making the GUI window
import java.awt.event.*; //Listener for the switch statement
import java.awt.*; // For making the GUI window
import java.awt.event.ActionListener; // This is for the text dialogs
import java.awt.event.ActionEvent; // This is needed for the text dialogs

public class InD extends JDialog
{
    String remember;
    public InD(String question){
        super (new JFrame(question),question);
        this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        this.setMinimumSize(new Dimension(question.length()*7,11));
        JTextField reply = new JTextField();
        JButton clickMe = new JButton("enter");
        clickMe.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    remember = reply.getText();
                    close();
                }
            });

        this.setLayout(new GridLayout(2,1,5,5));
        this.add(reply);
        this.add(clickMe);
        this.pack();
        setModal(true);
    }
    
    private void close(){this.dispose();}
    
    public String getText() {return remember;}
}