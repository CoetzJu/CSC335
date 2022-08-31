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

public class GUI2 extends JFrame implements ActionListener, MouseListener
{
    // This will be the main area fo the GUI as all the other bit of GUI come
    //back here
    Canvas mainBoard;
    private String remember;
    public int painty;
    public int paintx;
    public int mousex;
    public int mousey;
    public int gridSize = 50;
    public int gridStart = 120;
    public int squareSize = 50;

    public int pipes [] [];

    public GUI2(){

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
            case "Save" :;
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


        }

        ePipe.paintIcon(this, g, Xdraw(), Ydraw() );

    }

    // Co-ordinates

    public int Ydraw(){
        int ySwag = clickYcoord();
        ySwag = ySwag * squareSize;
        ySwag = ySwag + gridStart;
        System.out.println("Yswag" + ySwag);
        return ySwag;
    }

    public int Xdraw(){
        int xSwag = clickXcoord();
        xSwag = xSwag * squareSize;
        xSwag = xSwag + gridStart;
        return xSwag;
    }

    public int clickYcoord() {
        int cellY;
        cellY = mousey - gridStart;
        cellY = Math.round(cellY/squareSize);
        System.out.println(cellY);
        return cellY;
    }

    public int clickXcoord(){
        int cellX;
        cellX = mousex - gridStart;
        cellX = Math.round(cellX / squareSize);
        System.out.println(cellX);
        return cellX;
    }
    //=======================================================================================================================================================
    // Mouse tracking
    //=======================================================================================================================================================


    public void mouseClicked(MouseEvent e){
        mousex = e.getX();
        mousey = e.getY();
        System.out.println("click at " + mousex + ", " + mousey);
        clickXcoord();
        clickYcoord();
        this.repaint();
    }

    public void mouseExited(MouseEvent e) {/*System.out.println("exit");*/}
    public void mouseEntered(MouseEvent e) {/*System.out.println("enter");*/}
    public void mouseReleased(MouseEvent e) {/*System.out.println("release");*/}
    public void mousePressed(MouseEvent e) {/*System.out.println("press");*/}
}