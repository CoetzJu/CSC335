/**
 * Write a description of class saving here.
 *
 * @author Juan Coetzee
 * @version 0.1 || 26/06/2022
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

// This needs to be able to read CSV files.

public class filing
{
    
    public void load(String fileName){

        File myFile = new File(fileName + ".txt");
        
        try {
            // Stop the no no
            Scanner readTheFile = new Scanner(myFile);
            while (readTheFile.hasNextLine()){
                System.out.println(readTheFile.nextLine());
            }//While
        }//Try
        catch (IOException e) {
            System.out.println("File could not be found");
            e.printStackTrace();
        }//Catch
    }//Method
    
    void save(GUI myFrame){

        InD Save = new InD("Save");
        Save.setLocationRelativeTo(myFrame);
        Save.setVisible(true);
        String reply = Save.getText();
        System.out.println(reply);

        File file = new File (reply+".txt");
        System.out.println(file);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("This is a Test\n");
            writer.write("This is still a Test");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("didn't work");
        };

        //READ THE FILE READING SLIDES
    }
}//Class