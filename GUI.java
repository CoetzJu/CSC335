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

public class GUI extends JFrame implements ActionListener, MouseListener
{
    // This will be the main area fo the GUI as all the other bit of GUI come
    //back here
    Canvas mainBoard;
    private String remember;
    public int painty;
    public int paintx;
    public int mousex;
    public int mousey;
    public int Xcoord;
    public int Ycoord;
    public int gridSize = 500;
    public int gridStart = 120;
    public int squareSize = 50;
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
        }//Switch
    } //Method

    //=======================================================================================================================================================
    // This is the Main part of the GUI. like the Grids, icons, or other things related to visuals/
    //=======================================================================================================================================================

    //https://www.javatpoint.com/GridLayout
    final String emptyPipe ="assets/emptyPipe.png";
    ImageIcon ePipe = new ImageIcon(emptyPipe);


    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        int size = 500;
        //grid
        for (int i = 0; i <= size; i = i + squareSize){
            // Horizontal
            Line2D line = new Line2D.Float(gridStart, i + gridStart, size + gridStart, i + gridStart);
            // Vertical
            Line2D line2 = new Line2D.Float(gridStart + i,gridStart,  i + gridStart,size + gridStart);

            g2.draw(line);
            g2.draw(line2);

            for (int x = 0; x < 10; x++){
                for (int y = 0; y < 10; y++){
                    if (currentgrid [x] [y] == 1){
                        ePipe.paintIcon(this, g, paintx, painty);
                    }
                }
            }


        }

        ePipe.paintIcon(this, g, paintx, painty);

    }

    // Co-ordinates
    public void coOrdRun(){
        Ydraw();
        Xdraw();
}

    public int Ydraw(){
        int gridY = Ycoord;
        gridY = gridY * squareSize;
        gridY = gridY + gridStart;
        System.out.println("gridY " + gridY);
        painty = gridY;
        return painty;
    }

    public int Xdraw(){
        int gridX = Xcoord;
        gridX = gridX * squareSize;
        gridX = gridX + gridStart;
        System.out.println("gridX " + gridX);
        paintx = gridX;
        return paintx;
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
            network[clickXcoord()] [clickYcoord()] = 1;
            coOrdRun();
        } else {
            System.out.println("this is outside of the grid");
        }
        this.repaint();
    }

    public void mouseExited(MouseEvent e) {/*System.out.println("exit");*/}
    public void mouseEntered(MouseEvent e) {/*System.out.println("enter");*/}
    public void mouseReleased(MouseEvent e) {/*System.out.println("release");*/}
    public void mousePressed(MouseEvent e) {/*System.out.println("press");*/}

}// Class