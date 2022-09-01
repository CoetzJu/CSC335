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
import java.awt.geom.*; // This is used for geometry. Or the grid lines

public class GUI extends JFrame implements ActionListener, MouseListener
{
    // This will be the main area fo the GUI as all the other bit of GUI come
    //back here
    Canvas mainBoard;
    public int pipeType;
    public int painty;
    public int paintx;
    public int mousex;
    public int mousey;
    public int Xcoord;
    public int Ycoord;
    public int gridSize = 500;
    public int gridStart = 120;
    public int squareSize = 50;
    public int dataGridX;
    public int dataGridY;
    flow network = new flow();

    public GUI(){
        // This is to create the window for the program to use.
        setTitle("Wellington Waterways");
        this.getContentPane().setPreferredSize(new Dimension(900,900));
        addMouseListener(this);
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400,400));
        mainBoard = new Canvas();
        panel.add(mainBoard);
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

        menu = new JMenu("Pipes");
        menuBar.add(menu);

        menuItem = new JMenuItem("Straight pipe");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Cross Pipe");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Source Pipe");
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
        }//Switch

        switch(cmd){
            case "Straight pipe" : pipeType = 1;
            break;
            case "Cross Pipe" : pipeType = 2;
            break;
            case "Source Pipe" : pipeType = 3;
        }
    } //Method

    //=======================================================================================================================================================
    // This is the Main part of the GUI. like the Grids, icons, or other things related to visuals/
    //=======================================================================================================================================================

    //https://www.javatpoint.com/GridLayout
    dataField dataSet = new dataField();


    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        int size = 500;

        //Test image
        /*final String Plum ="assets/Plum.jpg";
        ImageIcon testPlum = new ImageIcon(Plum);*/

        //Empty pipes
        final String emptyPipe ="assets/emptyPipe.png";
        ImageIcon ePipe = new ImageIcon(emptyPipe);
        
        //Empty Cross pipes
        final String emptyCross ="assets/emptyCrossPipe.png";
        ImageIcon eCrossPipe = new ImageIcon(emptyCross);

        //Empty source
        final String emptySource = "assets/sourceCross.png";
        ImageIcon eSource = new ImageIcon(emptySource);

        /*ePipe.paintIcon(this, g, 300, 300);
        System.out.println("Test " + ePipe);
        System.out.println(ePipe.getImageLoadStatus());*/

        //Full pipes


        //This for loop draws the Grid
        for (int i = 0; i <= size; i = i + squareSize){
            // Horizontal
            Line2D line = new Line2D.Float(gridStart, i + gridStart, size + gridStart, i + gridStart);
            // Vertical
            Line2D line2 = new Line2D.Float(gridStart + i,gridStart,  i + gridStart,size + gridStart);

            g2.draw(line);
            g2.draw(line2);

        }


        // This for loop runs through the grid checking the values of each set co-ordinates, and then painting the pipes based on the values.
        for (int dataGridX = 0; dataGridX < 10; dataGridX++){
            for (int dataGridY = 0; dataGridY < 10; dataGridY++)
                // Horizontal pipes
             if (dataSet.currentgrid [dataGridX] [dataGridY] == 1){

                int gridY = dataGridY;
                gridY = gridY * squareSize;
                gridY = gridY + gridStart;
                painty = gridY;

                int gridX = dataGridX;
                gridX = gridX * squareSize;
                gridX = gridX + gridStart;
                paintx = gridX;
                ePipe.paintIcon(this, g, paintx, painty);

            } else if (dataSet.currentgrid [dataGridX] [dataGridY] == 2){ // Source Cross Pipes

                int gridY = dataGridY;
                gridY = gridY * squareSize;
                gridY = gridY + gridStart;
                painty = gridY;

                int gridX = dataGridX;
                gridX = gridX * squareSize;
                gridX = gridX + gridStart;
                paintx = gridX; 

                eSource.paintIcon(this, g, paintx, painty);
            } else if (dataSet.currentgrid [dataGridX] [dataGridY] == 3){   // Cross pipes  

                int gridY = dataGridY;
                gridY = gridY * squareSize;
                gridY = gridY + gridStart;
                painty = gridY;

                int gridX = dataGridX;
                gridX = gridX * squareSize;
                gridX = gridX + gridStart;
                paintx = gridX;                
                eCrossPipe.paintIcon(this, g, paintx, painty);
            }
        }
    }    


    // Co-ordinates

    public void coordInput(){
        int gridY = Ycoord;
        int gridX = Xcoord;
        System.out.println("Placing " + gridX + " and " + gridY + " into the dataset");
        dataSet.currentgrid [gridX] [gridY] = pipeType;
        System.out.println("return value = " + dataSet.currentgrid [gridX] [gridY]);
        this.repaint();
    }

    public int clickYcoord() {
        int cellY;
        cellY = mousey - gridStart;
        cellY = Math.round(cellY/squareSize);
        System.out.println(cellY);
        Ycoord = cellY;
        return Ycoord;
    }

    public int clickXcoord(){
        int cellX;
        cellX = mousex - gridStart;
        cellX = Math.round(cellX / squareSize);
        System.out.println(cellX);
        Xcoord = cellX;
        return Xcoord;
    }
    //=======================================================================================================================================================
    // Mouse tracking
    //=======================================================================================================================================================


    public void mouseClicked(MouseEvent e){
        mousex = e.getX();
        mousey = e.getY();
        System.out.println("click at " + mousex + ", " + mousey);
        if (mousex > gridStart && mousey > gridStart &&  mousex <  gridStart + squareSize * 10 && mousey <  gridStart + squareSize * 10){
            clickXcoord();
            clickYcoord();
            coordInput();
            //network[clickXcoord()] [clickYcoord()] = 1;
        } else {
            System.out.println("this is outside of the grid");
        }
    }

    public void mouseExited(MouseEvent e) {/*System.out.println("exit");*/}
    public void mouseEntered(MouseEvent e) {/*System.out.println("enter");*/}
    public void mouseReleased(MouseEvent e) {/*System.out.println("release");*/}
    public void mousePressed(MouseEvent e) {/*System.out.println("press");*/}

}// Class