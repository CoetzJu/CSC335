import java.util.Scanner;
import java.io.File;// File handler
import java.io.IOException;// Error machines
import java.io.FileWriter;

public class TEST
{
    public TEST()
    {
        //The variables I want to use for loading
        Scanner keyboard;
        keyboard = new Scanner(System.in);
        String fileName;
        
        //For the user
        //The command to find the file wanted
        fileName = keyboard.nextLine();

        InD test = new InD("What file do you want to load");
        test.setLocationRelativeTo(null);
        test.setVisible(true);
        String reply = test.getText();

        File myFile = new File(fileName + ".txt");
       
        try{
            Scanner readTheFile = new Scanner(myFile);
            while (readTheFile.hasNextLine()){
                System.out.println(readTheFile.nextLine());
            }
        } catch (IOException e) {
            System.out.println("File could not be found");
            e.printStackTrace();
        }
        try {
            File file = new File("writtenByMe.txt");
            FileWriter writer = new FileWriter(file);

            writer.write("oisjgf");
            writer.write("foige-");
            writer.flush();
            writer.close();
        } catch (IOException e){
            System.out.println("oops");
        }
    }
}
