/**
 * Write a description of class saving here.
 *
 * @author Juan Coetzee
 * @version 0.1 || 26/06/2022
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.io.FileWriter;

// This needs to be able to read CSV files.

public class filing
{
    dataField dataSet = new dataField();
    final int MAXLINES = 100;
    final int valuesPerLine = 3;
    public int GRIDSIZE = 10;
    public int loadGrid [] [] = new int [GRIDSIZE] [GRIDSIZE];
    public String Remember [] [] = new String [GRIDSIZE] [GRIDSIZE];

    
    public void load(String fileName){

        File myFile = new File("saveData/" + fileName + ".csv");
        String CSVlines[] = new String[MAXLINES];
        String AllLinesAllElements[][] = new String [MAXLINES][valuesPerLine];
        int lineCount = 0;
        try {
            
            Scanner readTheFile = new Scanner(myFile);

            while (readTheFile.hasNextLine() && lineCount < MAXLINES){

                String line= readTheFile.nextLine();
                CSVlines[lineCount]=line;
                lineCount++;
            }//While

            for (int i = 0; i < lineCount; i++){
                //System.out.println(CSVlines[i]);
            
                    String value [] = CSVlines[i].split(",");
                    System.out.print(value[i]);
                    for (int h = 0; h < lineCount; h++){
                        Remember [i] [h] = value[h];

                        //loadedGrid();
                    }//GUI giveLoad = new GUI(); //giveLoad.changeDataSet(loadGrid);
            }
            for (int h = 0; h < lineCount; h++){
                for(int i = 0; i < 10; i++){
                    loadGrid [i] [h] = Integer.parseInt(Remember[h] [i]);
                }

                //loadedGrid();
            }//GUI giveLoad = new GUI(); //giveLoad.changeDataSet(loadGrid);
        
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

